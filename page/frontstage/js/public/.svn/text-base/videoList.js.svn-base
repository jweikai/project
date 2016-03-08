$(function() {	    		   
	$(".course-info-intro").hover(function() {	    		
		var $heart = $(this).find("span"); 
		$heart.removeClass("fa-heart-o");
		$heart.addClass("fa-heart");
	}, function() {
		var $heart = $(this).find("span");
		$heart.addClass("fa-heart-o");
		$heart.removeClass("fa-heart");
	});
	var $courseTime = $(".course-info-state .course-time");
	var $learnedTime = $(".course-info-state .learned-time");	
	var ch = $courseTime.find(".ft-hour").length ? parseInt($courseTime.find(".ft-hour").text()):0,
		cm = $courseTime.find(".ft-minute").length ? parseInt($courseTime.find(".ft-minute").text()):0,
		ct = ch*60 + cm,
		leh = $learnedTime.find(".ft-hour").length ? parseInt($learnedTime.find(".ft-hour").text()) : 0,
		lem = $learnedTime.find(".ft-minute").length ? parseInt($learnedTime.find(".ft-minute").text()) : 0,
		let = leh*60 + lem;	
	var end = (let/ct).toFixed(3)*100;		
	var start = 0.0;	
	var t = setInterval(function() {
		start += Math.random()*8;
		if ( start > end ) {
			start = end;
			if ( end == 100 ) $learnedTime.find(".learn-pro").css("color", "limegreen");
			$learnedTime.find(".learn-pro").text(end);
			clearInterval(t);
		}else {
			$learnedTime.find(".learn-pro").text(start.toFixed(1));
		}
	}, 20);	
	
	//按钮循环运动
	$(".user-list .fresh-btn").click(function() {
		$(this).addClass("run");
		var _this = this;		
		//ajax请求结束, 这里做模拟	
		$(".user-list .media").fadeOut(400);
		setTimeout(function() {
			$(_this).removeClass("run");
			var users = [];
			var $users = $(".user-list .media");			
			for (var i = 0; i < $users.length; i ++) {
				var obj = $($users.get(i)).clone();
				obj.find("img").attr("src", "img/test/user4.jpg");
				obj.find(".media-body").html("<h4 class='media-heading'><a href='javascript:;'>Wings</a></h4>无名");
				users.push(obj);
			}
			$users.remove();
			$(".user-list .panel-body").append(users);		
			users.forEach(function(user) {
				$(user).fadeIn(400);
			});
		}, 1000);		
	});
	
	$(".item-parent").click(function() {
		if ( $(this).parent().hasClass('mopen') ) { 
			$(this).parent().removeClass("mopen").addClass("mclose");
			$(this).parent().find(".item-childs").animate({
				height:0,
			}, 200);
		}else {
			var items = $(this).parent().find(".item-childs").children();
			$(this).parent().removeClass("mclose").addClass("mopen");
			$(this).parent().find(".item-childs").animate({
				height: items.outerHeight()*items.length				
			}, 200);
		}
	});
});