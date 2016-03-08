$(function() {
	$(".js-question-tabs li").click(function() {
		var $this = $(this), 
			idx = $this.index();
		if ( $this.hasClass('active') ) return ;
		$this.addClass('active').siblings().removeClass('active');
		$('.course-list .panel-body').find('[class^=js-video]').eq(idx).removeClass('hide').siblings().addClass('hide');
	});
});
