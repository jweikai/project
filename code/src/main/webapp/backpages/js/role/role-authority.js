$(function(){
	$(".js-user-authority>.bs-callout-list :checkbox").click(function() {
		var $this = $(this),
			$p = $this.parents(".bs-callout-list");		
		parentsCheck($p, $p.prev());
		
		function parentsCheck($p, $tar) {
			var checkAll = 0 != $p.find(":checked").length;
			$tar.find(":checkbox").prop("checked", checkAll);
			if ( $p.parent().parent().hasClass('js-user-authority') ) {
				$p = $p.parent().parent();				
				checkAll = 0 != $p.children('.js-user-authority').find('.js-authority-parent').find(":checked").length;
				$p.children('.js-authority-parent').find(":checkbox").prop("checked", checkAll);
			}
		}
	});
	$(".js-authority-parent :checkbox").click(function() {
		var $this = $(this),
			$p = $this.parents(".js-authority-parent"),
			$plist = $p.nextAll();		
		$plist.find(":checkbox").prop("checked", $this.prop("checked"));
	});
});