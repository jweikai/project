<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<%@include file="../public/head.jspf" %>
		<script type="text/javascript" src="${pageContext.request.contextPath }/backpages/js/global.js" ></script>
	</head>
	<body>
		<!-- header start -->
		<%@include file="../public/nav.jspf" %>
		<!-- header end -->
		
		<div class="container" id="main">
			<div class="row">
				<%@include file="../public/left.jspf" %>
				<div id="content" class="col-lg-10 col-md-10">
					<!-- nav breadcrumb start -->
					<%@include file="../public/breadcrumb.jspf" %>
					<!-- nav breadcrumb end -->		
					<div class="panel panel-default js-authority-list" style="position: relative;">
						<%@include file="../public/content-head.jspf" %>
						<div class="panel-body">
							<form class="form-horizontal" method="post"  action="${id == null? 'add':'update'}">
								<s:hidden name="id"></s:hidden>
								<div class="form-group">
								    <label for="role-name" class="col-sm-2 control-label">角色名称</label>
								    <div class="col-sm-10">
								      <s:textfield name="name" cssClass="form-control" placeholder="请输入名称"></s:textfield>
								    </div>
							  	</div>
							  	<div class="form-group">
								    <label for="role-content" class="col-sm-2 control-label">角色描述</label>
								    <div class="col-sm-10">
								      <s:textfield name="content" cssClass="form-control" placeholder="请输入描述"></s:textfield>
								    </div>
							  	</div>
							  	<button class="btn btn-success-outline pull-right">提交</button>
							</form>
						</div>
					</div>
				</div>
			</div>			
		</div>
	</body>	
</html>
