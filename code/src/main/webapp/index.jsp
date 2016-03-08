<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/extends/js/jquery-1.10.2.min.js" ></script>
<script type="text/javascript">
$(function() {
	var img = $("#imgId");
	var rw, rh;	
	$("<img>").attr("src", img.attr("src"))
		.load(function() {
			rw = this.width;
			rh = this.height;
			var $parent = img.parent();
			img.css({
				width: rw,
				height: rh,
				marginLeft: ($parent.width()-rw)/2,
				marginTop: ($parent.height()-rh)/2
			});
		});
});
</script>
</head>
<body>
<h2>Hello World!</h2>
<form action="demo/index.htm">
	<input type="text" name="name">
	<input type="hidden" name="id" value="1">
	<button type="submit">sub</button>
</form>
<div style="width:300px; height:200px; background: red; position: relative;">
	<img id="imgId" height="100" width="200" alt="aa" src="${pageContext.request.contextPath }/frontpages/images/1-7.jpg" />
</div>
</body>
</html>
