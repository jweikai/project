$(function() {
	$(".dot-curr").css("left", $(".space-tabs-menu li.active").position().left);
	$(".space-tabs-menu li a").click(function() {
		var _this = this;
		$(this).parent().siblings().removeClass("active");
		$(this).parent().addClass("active");		
		$(".dot-curr").animate({
			left: $(_this).parent().position().left
		}, 300);
	});
	
	//delete
	$("#userleft .fa-trash-o").click(function() {
		$(this).css("display", 'none');
		$(this).next().css("display", 'block');
		$(".my-space-course .course-list-new .del-btn").css("display", "block");
		$(".my-space-course .course-item").addClass("run");
		
		$(".my-space-course .course-item").on("mouseover", function() {
			$(this).removeClass("run");
		});
		$(".my-space-course .course-item").on("mouseleave", function() {
			$(this).addClass("run");
		});
	});
	
	$("#userleft .trash-complete").click(function() {
		$(this).css("display", 'none');
		$(this).prev().css("display", 'block');
		$(".my-space-course .course-list-new .del-btn").css("display", "none");
		$(".my-space-course .course-item").removeClass("run");
		$(".my-space-course .course-item").off("mouseover");
		$(".my-space-course .course-item").off("mouseleave");
	});	
	//红心动画
	$(".my-space-course .course-item .course-list-img .fa-heart").click(function() {		
		$(this).removeClass("run").addClass("hide");
		$(this).prev().removeClass("hide");
	});
	$(".my-space-course .course-item .course-list-img .fa-heart-o").click(function() {
		if ( $(this).next().hasClass("run") ) return ;
		$(this).next().removeClass("hide").addClass("run");		
	});
	$(".my-space-course .course-item .course-list-img .fa-heart").on("webkitAnimationEnd", function() {
		$(this).prev().addClass("hide");
	});
	$(".my-space-course .course-item .course-list-img .fa-heart").on("animationend", function() {
		$(this).prev().addClass("hide");
	});	
	
	/* 在学时, 显示 */
	if ( $(".space-tabs-menu li.active").index() == 1 ) {		
		$(".course-checkbox").css("display", "block");
	}
	/* 是否显示0进度课程 */
	$(".course-checkbox").click(function() {		
		if ( $(this).hasClass("selected") ) {
			$(this).removeClass("selected");
			//跳转action
		}else {
			$(this).addClass("selected");
		}
	});
})
