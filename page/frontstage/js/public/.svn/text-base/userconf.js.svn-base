$(function() {
	//sidebar 
	$("#sidebar .list-group > li").click(function(e) {		
		if ( e.target.nodeName.toLocaleLowerCase() == "ul" ) return ; 
		//if ( $(this).hasClass("active") ) return ;
		$(this).parent().find("li").removeClass("active");
		$(this).addClass("active");
		$(".sidebar-sign").animate({
			top: $(this).position().top
		}, 400);
		$(this).find(".category-sort").fadeOut(300);
	});	
	$("#sidebar .list-group > li.active").trigger("click");
	$("#sidebar .list-group li").hover(function() {
		if ( $(this).hasClass("active") ) return;
		$(this).addClass("hover");		
		$(this).parent().children("li").each(function(index){
			$(this).find(".category-sort").css({opactiy:0,display:"none"});
		});
		$(this).find(".category-sort").stop().fadeIn(300);		
	}, function() {
		$(this).removeClass("hover");		
		$(this).find(".category-sort").stop().fadeOut(300);
	});	
	$("#content .head-change-btn").on({
		mouseover: function() {
			$(this).find(".fa").addClass("fa-spin");
		},
		mouseleave:function() {			
			$(this).find(".fa").removeClass("fa-spin");
		},
		click: function() {
			var idx = ((Math.random()*5+1)|0);
			$("#content .head-img img").attr("src", "img/test/user"+idx+".jpg");
			$(".my-head").attr("src", "img/test/user"+idx+".jpg");
		}
	});
});
