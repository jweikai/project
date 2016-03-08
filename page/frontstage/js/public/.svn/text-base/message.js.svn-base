$(function() {	
	//初使化#main高度
	$("#main").height($(window).height()-$(".header").innerHeight()-42);
	$(window).resize(function() {		
		$("#main").height($(window).height()-$(".header").innerHeight()-42);
		$("#chat_content").height($("#main .container").height()-$("#chat_editor").height()-31);
	});
	//初使化chat_edit高度	
	$("#chat_content").height($("#main .container").height()-$("#chat_editor").height()-31);	
	
	var maplist = ["#lastChat", "#friends"];
	$("#left_panel_nav > li").click(function() {
		if ( !$(this).hasClass("active") ) {			
			$(this).siblings().removeClass("active");
			$(this).addClass("active");
			var idx = $(this).index();
			$(maplist[idx]).css("display", "block");
			$(maplist[(idx+1)%2]).css("display", "none");
		}
		init();
	});
	
	//点击 '最近'
	$("#lastChat > li").click(function() {
		var uid = $(this).attr("uid");
		$(this).siblings().removeClass("active");
		$(this).addClass("active");
		$("#chat_content ul").css("display", "none");
		$("#chat_content ul[uid="+uid+"]").css("display", "block");
		$("#chat_editor").css("display", "block");
		$("#chat_content").find(".userinfo_layer").css("display", "none");
	});
	
	//点击 '好友'
//	$("#friends > li").click();
	
	//初使化聊天界面
	function init() {		
		$("#lastChat > li").removeClass("active");
		$("#chat_content ul").css("display", "none");
		$("#chat_editor").css("display", "none");
		$("#textInput").val('');
	}	
	
	//笑脸
	$("#sendEmojiIcon").click(function(e) {
		if ( $(this).hasClass("sendEmojiIcon_ac") ) {
			$(document).trigger("click");
			return ;
		}
		var $this = $(this);
		$(document).one("click", function() {
			$this.removeClass("sendEmojiIcon_ac");
			$("#face_panel").css("display", "none");
		});		
		$("#face_panel").css("display", "block");
		$(this).addClass("sendEmojiIcon_ac");
		e.stopPropagation();	//防止事件冒泡
	});
	//相机
	$("#msgUploadImg").change(function() {		
		$(this).parent().addClass("chat_upImg_ac");
		$(this).css("display", "none");
		$("#msg_upImg_box").css("display", "block");
		$("#imgDel").css("display", "block");
		$("#textInput").css("display", "none").val('<img class="chatPhoto" src="'+$("#tempViewImg").attr("src")+'">');
		//把input:file内上传，并清空file
		$(this).val('');
	});
	$("#imgDel").click(function() {
		$("#msgUploadImg").parent().removeClass("chat_upImg_ac");
		$("#msgUploadImg").css("display", "block");
		$("#msg_upImg_box").css("display", "none");
		$("#imgDel").css("display", "none");
		$("#textInput").css("display", "block").val('');
	});
	//选择表情
	$("#face_panel a").click(function() {		
		$("#textInput").val($("#textInput").val() + $(this).attr("title"));
	});
	//发送消息
	$("#chat-send").click(function() {
		//这里应该是提交表单
		var conText = $("#textInput").val();
		var regex = /\[.{1,2}\]/g;
		var emotions = conText.match(regex);
		if ( emotions != null ) {
			emotions.forEach(function(emotion) {
				var $e = $("#choose_face a").each(function(index) {
					if ( $(this).attr("title") == emotion ) {					
						conText = conText.replace(emotion, '<img class="ph_face" src="'+$(this).find("img").attr("src")+'">');
						return false;
					}
				});	
			});				
		}
		var o = $('<li class="me"><div class="chat_avata"><a><img width="40" height="40" class="img_border_one" src="img/test/my.jpg"></a></div><div class="a_msg_info" id="0"><pre>'+conText+'</pre><i class="arrow_left_b"></i></div><small class="time">2014-09-07 10:07</small></li>');		
		$("#userchatUl10000").append(o);
		$("#textInput").val('');
		//滚动底部
		$("#chat_content").scrollTop($("#chat_content").height()+40);		
	});	
});
function showUserInfo(obj, headImg, id, name, job, location, message) {
	$("#chat_content").height($("#main .container").height()-31);
	var uid = $(obj).attr("uid");
	var p = $('<div class="userinfo_layer"><p class="headpic"><img src="'+headImg+'" width="130" height="130"></p><p class="name">'+name+'</p><p class="job">'+job+'</p><p>'+location+'</p><p>'+message+'</p><div class="btn_area"><a href="'+id+'" class="btn btn-primary" target="_blank">访问主页</a> <a id="gotoSend" uid="'+id+'" class="btn btn-success" href="javascript:;">发消息</a> <a id="rmfriend" class="btn btn-danger" href="javascript:;">删除好友</a></div></div>');
	if ( id == '10000' ) {
		p.find("#rmfriend").remove();
	}
	p.css("display", "block");
	$("#chat_content").find(".userinfo_layer").remove();
	$("#chat_content").append(p);		
}	
