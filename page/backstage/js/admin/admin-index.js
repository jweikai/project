//全局
function requestFullScreen() {
    var de = document.documentElement;
    if (de.requestFullscreen) {
        de.requestFullscreen();
    } else if (de.mozRequestFullScreen) {
        de.mozRequestFullScreen();
    } else if (de.webkitRequestFullScreen) {
        de.webkitRequestFullScreen();
    }
}
$(function() {	
	var c = false;
	$("[name=checkall]").click(function() {
	//全选
		c = !c;
		$("[name=id]").each(function(index, obj) {			
			$(obj).prop("checked", c);
		});		
	});
	//delete animation
	$("#delAllBtn").click(function() {
		$("[name=id]:checked").each(function(index) {
			$(this).parents("tr").fadeOut(600);
		});
	});
	$("[data-toggle='collapse']").parent().parent().click(function() {		
		$($(this).find("[data-toggle='collapse']").attr("href")).collapse('toggle');		
	});
});

