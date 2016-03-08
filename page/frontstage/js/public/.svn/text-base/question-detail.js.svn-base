$(function() {
	$("#detail-left ._heart").click(function() {
		var $this = $(this);
		if ( $this.hasClass("fa-heart-o") ) {
			$this.removeClass("fa-heart-o").addClass("fa-heart");
		}else {
			$this.removeClass("fa-heart").addClass("fa-heart-o");
		}
	});
	var b = false;
	$(".js-qa-comment-support").click(function() {
		//判断改用户是否赞过
		if ( !b ) {
			b = true;
			$(this).find(".js-qa-support-num").text(function() {
				$(this).text($(this).text()-(-1));
			});
		}else {
			alert('你已赞过');
		}
	});	
	$('.js-reply-item-reply').click(function() {
		var $txtContent = $(this).parents('.js-qa-comment').find('.js-qa-reply-ibox').removeClass('hide').find('textarea');
		var rname = $(this).parents('.qa-reply-item-inner').find('.qa-reply-nick:first').text();
		if ( rname.length > 0 ) {
			$txtContent.val('回复  ' + rname + ': ');
		}else {
			$txtContent.val('');
		}
		$txtContent.focus();
	});
	$(".js-qa-reply-ibox").find(".js-ipt-cancel").click(function() {
		$(this).parents('.js-qa-reply-ibox').addClass('hide');
	});
	$(".js-qa-reply-ibox").find(".js-ipt-submit").click(function() {
		if ( $.trim($("#replyComment").val()) == "" ) {
			$(this).siblings('.qa-tips').removeClass('hide');
		}
	});
	$(".js-qa-reply-ibox").find('textarea').change(function() {
		if ( $('.qa-tips').hasClass('hide') ) {
			return ;
		}
		$('.qa-tips').addClass('hide');
	});
});
