$(function() {	
	var $tar = $('.js-data-deal');
	$("#data-back").click(function() {
		var $bspan = $('<span class="fadeInLeft animated color-primary"><i class="fa fa-spinner fa-pulse"></i>&nbsp;正在备份...</span>');
		var $suspan = $('<span class="fadeIn animated color-success"><i class="fa fa-check"></i>&nbsp;备份成功</span>');		
		$('.js-data-help').text('---最多保存10个备份文件');
		$tar.empty();
		$tar.append($bspan);
		$.ajax({
			type: 'POST',
			url: 'back',
			dataType: 'json',
			success:function(resp) {	
				if ( !resp.success ) {
					$suspan.removeClass('color-success').addClass('color-danger').html('<i class="fa fa-close"></i>&nbsp;备份失败');					
				}
				$bspan.removeClass('fadeInLeft').addClass('fadeOutRight')
				$tar.append($suspan);				
			}
		});
		return false; 
	});
	$("#data-recover").click(function() {
		$tar.empty();
		$('.js-data-help').text('---格式: data-年-月-日-时-分-秒');
		$.ajax({
			type: 'post',
			url: 'recoverUI',
			dataType: 'json',
			success: function(resp) {
				for (var i = 0; i < resp.obj.length; i ++) {
					var $obj = $('<div class="data-file-sql js-data-file-sql"><span class="js-data-content"></span><button type="button" class="btn btn-success js-data-recover-btn">恢复</button></div>');
					$obj.find('.js-data-content').text(resp.obj[i]);
					$obj.hide();
					$tar.append($obj);
					$obj.fadeIn();
				}
			}
		});
		return false;
	});
	$(".js-data-deal").on("click", ".js-data-recover-btn", function() {
		var $suspan = $('<span class="fadeInDown animated color-success"><i class="fa fa-check"></i>&nbsp;恢复成功</span>');
		var sqlName = $(this).prev().text();
		$.ajax({
			type: 'post',
			url: 'recover',
			data: {
				sqlName: sqlName
			},
			dataType: 'json',
			success:function(resp) {
				if ( !resp.success ) {
					$suspan.removeClass('color-success').addClass('color-danger').html('<i class="fa fa-close"></i>&nbsp;恢复失败');
				}
				$tar.empty();
				$tar.append($suspan);
				setTimeout(function() {
					window.location.reload();
				}, 1000);
			}
		});
	});
	$("#removeAllAuthorityBtn").click(function() {
		var params = '?userIds=' + $(".js-td-user-id")[0].innerHTML;
		var len = $(".js-td-user-id").length;
		for (var i = 1; i < len; i ++) {
			params += '&userIds=' + $(".js-td-user-id")[i].innerHTML;
		}
		window.location.href = 'deleteAll' + params;
		return false;
	});
});