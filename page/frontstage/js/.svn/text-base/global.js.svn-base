$(function() {
	/*回到顶部*/
	$(window).scroll(function() {
		var wTop = ($(this).scrollTop()*3.5).toFixed(0);
		var wHeight = $("html,body").height();
		if ( wTop >= wHeight ) {
			$("#backTop").css("display", "block");
		}else {
			$("#backTop").css("display", "none");
		}
	});
	$("#backTop").click(function() {
		$("html,body").stop().animate({
			scrollTop: 0
		}, 600);
	});
	
	$("#loginBtn").click(function() {
		$(".nav-login").css("display", "none");
		$(".nav-user").css("display", "block");
		$("#userLogin").modal("hide");
	});
	$("#user-exit").click(function() {
		$(".nav-login").css("display", "block");
		$(".nav-user").css("display", "none");
	});
});
