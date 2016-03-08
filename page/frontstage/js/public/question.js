$(function() {
	$("#save-left .category a").click(function() {
		if ( $(this).hasClass("active") ) return ;
		$(this).siblings().removeClass("active");
		$(this).addClass("active");
	});
	
	//tags
	$(".ques-title .list-tag").click(function() {
		var $target = $("#tagcontent");		
		var $thisName = $(this).attr("name");
		var b = $target.find(".list-tag").length > 2;
		$target.find(".list-tag").each(function(index) {
			if ( $(this).attr("name") == $thisName ) {				
				return b=false;
			}
		});
		if ( b ) {			
			return ;
		}
		if ( $(this).hasClass("active") ) {
			$(this).removeClass("active");
			var name = $(this).attr("name");			
			$target.find(".list-tag").filter(function(index) {
				return $(this).attr("name") == name;
			}).remove();
			if ( $target.children(".list-tag").length == 0 ) {
				$target.children("span").css("display", "inline");
			}
			return ;
		}
		$(this).addClass("active");		
		$target.children("span").css("display", "none");
		var $source = $(this).clone();
		$source.append("<span class='fa fa-close pull-right'></span>");
		$target.append($source);
	});	
	//事件委托
	$("#tagcontent").on("click", ".list-tag", function() {		
		var $target = $("#tagcontent");
		$(this).remove();		
		if ( $target.children(".list-tag").length == 0 ) {
			$target.children("span").css("display", "inline");
		}
	})	
	
	//accomplate
	var a = false;			
	$("#title").autocomplete({
		source: function(query, process) {
			var result = [
				{regionName: '北京', regionNameEn: 'Beijing', regionShortnameEn:'BJ', regionCode: '123123'},
				{regionName: '河北省', regionNameEn: 'Heibei', regionShortnameEn:'HE', regionCode: '130000'},
				{regionName: '上海', regionNameEn: 'Shanghai', regionShortnameEn:'SH', regionCode: '310000'},
				{regionName: '浙江省', regionNameEn: 'Zhejiang', regionShortnameEn:'ZJ', regionCode: '340000'},
				{regionName: '福建省', regionNameEn: 'Fujiang Sheng', regionShortnameEn:'FJ', regionCode: '350000'},
			];		
			var filter = [];						
			for (i in result) {
				var b = false;
				for (obj in result[i]) {														
					if ( result[i][obj].toLowerCase().indexOf(query.toLowerCase()) > -1) {
						b = true;
						break;
					}
				}
				if ( b ) {
					filter.push(result[i]);
				}
			}
			process(filter);
		},
		formatItem:function(item){
			return item["regionName"]+"("+item["regionNameEn"]+"，"+item["regionShortnameEn"]+") - "+item["regionCode"];
		},
		setValue:function(item){
			return {'data-value':item["regionName"],'real-value':item["regionCode"]};
		}
	});
});
