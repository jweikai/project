$(function () {
	//章 增
	$(".page-list").on("click", ".page-add-btn", function() {
		var $prev = $(this).prev();
		if ( $prev.val().trim() === "" ) {
			alert("章名称不能为空!");
			return ;
		}
		$prev.prop("readonly", true);
		$(this).find("span").removeClass("fa-plus-circle").addClass("fa-minus-circle");
		var $p = $('<div class="input-group page"><input type="text" class="form-control" name="page" placeholder="请输入章节名称"><span class="input-group-addon page-add-btn"><span class="fa fa-plus-circle"></span></span></div>');
		var $s = $('<div class="list-group"><div class="input-group section-list"><input type="text" class="form-control" name="section" placeholder="请输入小节名称"><span class="input-group-addon section-add-btn"><span class="fa fa-plus-circle"></span></span></div></div>');
		$(this).parents(".page-list").append($s).append($p);
		$(this).removeClass("page-add-btn").addClass("page-reduce-btn");
	});
	//章 删
	$(".page-list").on("click", ".page-reduce-btn", function() {
		$(this).parent().next().remove();
		$(this).parent().remove();
	});
	
	//节 增
	$(".page-list").on("click", ".section-add-btn", function() {
		var $prev = $(this).prev();
		if ( $prev.val().trim() === "" ) {
			alert("小节名称不能为空!");
			return ;
		}
		console.log(1);
		$prev.prop("readonly", true);
		$(this).find("span").removeClass("fa-plus-circle").addClass("fa-minus-circle");		
		var $s = $('<div class="input-group section-list"><input type="text" class="form-control" name="section" placeholder="请输入小节名称"><span class="input-group-addon section-add-btn"><span class="fa fa-plus-circle"></span></span></div>');
		$(this).parents(".list-group").append($s);
		$(this).removeClass("section-add-btn").addClass("section-reduce-btn");
	});
	//节删
	$(".page-list").on("click", ".section-reduce-btn", function() {		
		$(this).parent().remove();
	});
});
