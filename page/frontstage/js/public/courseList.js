$(function() {
	//sidebar 
	$("#sidebar .list-group > li").click(function(e) {		
		if ( e.target.nodeName.toLocaleLowerCase() == "ul" ) return ; 
		if ( $(this).hasClass("active") ) return ;
		$(this).parent().find("li").removeClass("active");
		$(this).addClass("active");
		$(".sidebar-sign").animate({
			top: $(this).position().top
		}, 400);
		$(this).find(".category-sort").fadeOut(300);
	});
	
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
	$("#content .head-sign").css({
		left: $("#content .group li:first").position().left
	});
	$("#content .group li").click(function(e) {		
		$(this).siblings().removeClass("active");
		$(this).addClass("active");
		$("#content .head-sign").animate({
			left: $(this).position().left
		},300);
	});
	
	$("#filter-icon").hover(function() {
		$(this).addClass("hover");		
		$(this).find(".sidebar-filter").show();
	}, function() {
		$(this).removeClass("hover");
		$(this).find(".sidebar-filter").hide();
	});
	
	// transform: scale(1.2);
//	$("#content .panel-body").on("mouseover", ".row > div", function() {
//		$(this).addClass("hover");
//	});
//	$("#content .panel-body").on("mouseout", ".row > div", function() {
//		$(this).removeClass("hover");
//	});
});
