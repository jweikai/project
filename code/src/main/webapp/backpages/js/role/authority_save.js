$(function() {	
	var obj = [];
	$("#js-search-key").autocomplete({
		source: function(query, process) {
			$(".js-error").hide();
			isSelect = false;
			$.ajax({
				type:"post",
				url:"../user/search",
				data: {
					key: $("#js-search-key").val()
				},
				dataType: 'json',
				success: function(resp) {					
					if ( resp.obj.length == 0 || !resp.success ) {						
						errorInfo(resp.msg);
					}else {					
						obj = resp.obj;
						return process(resp.obj);
					}
					if (resp.obj.length == 0) return process([]);
				}
			});			
		},
		formatItem: function(item) {
			return item["name"];
		},
		setValue: function(item) {
			return {
				'data-value': item["name"],
				'real-value': JSON.stringify(item)
			};
		},
		selectEvent: function(item) {
			selectItem(item);
			successDeal();
		}
	});
	$("#js-search-key").blur(function() {			
		var b = false, k = -1;
		var key = $(this).val();
		for (var i = 0; i < obj.length; i ++) {
			if ( obj[i].name == key ) {
				b = true;
				k = i;
				break;
			}
		}	
		if ( !b ) errorInfo('用户不存在');
		else {						
			selectItem(obj[k]);
			successDeal();
		}
	});
	$(".js-reselect-user").click(function() {
		$(this).parent().removeClass('input-group');
		$(this).hide();
		$("#js-search-key").val('').prop('readonly', false);
		$("#user-role-btn").hide();
		$(".js-roles option").prop("selected", false);
	});
	function errorInfo(msg) {
		$(".js-error").html('<i class="fa fa-times-circle"></i>&nbsp;' + msg).fadeIn();
		$(".js-form-username").addClass("has-error");
		$("#user-role-btn").hide();
	}
	function selectItem(item) {
		var roles = item.rolesVO;
		var visit = [];
		for (var i = 0; i < roles.length; i ++) {				
			visit[roles[i].id] = true;
		}		
		$(".js-roles option").each(function() {
			var $this = $(this);
			var b = false;
			if ( visit[$this.val()] ) b = true;
			$this.prop("selected", b);
		});
	}
	function successDeal() {
		$(".js-error").hide();
		$("#js-search-key").prop("readonly", true)
		.parent().addClass('input-group').css('padding-left', '15px');
		$(".js-reselect-user").show();
		$(".js-form-username").removeClass("has-error");
		$("#user-role-btn").show();
	}
});