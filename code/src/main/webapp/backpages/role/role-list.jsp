<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<%@include file="../public/head.jspf" %>
		<script type="text/javascript" src="${pageContext.request.contextPath }/backpages/js/global.js"></script>		
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
					<div class="panel panel-default">						
						<%@include file="../public/content-head.jspf" %>
						<div class="panel-body">
							<form class="form-inline">
								<input type="button" class="btn btn-secondary-outline checkall" name="checkall" id="checkall-btn" value="全选">
								<s:a cssClass="btn btn-primary-outline" action="role_addUI">添加角色</s:a>
								<s:a action="user_delete" cssClass="btn btn-danger-outline" id="delAllBtn">批量删除</s:a>
							</form>
							<div class="data-show">
								<table class="table table-hover" id="model-tab">
						        	<thead>
						        		<tr>
						        			<th>选择</th>
						        			<th>编号</th>
						        			<th>用户名</th>
						        			<th>描述</th>
						        			<th>操作</th>
						        		</tr>
						        	</thead>
						        	<tbody>
						        		<s:iterator value="#list">
						        		<tr>
								          <td><input type="checkbox" name="ids" value="${id }" /></td>
								          <td><strong>${id }</strong></td>
								          <td>${name }</td>
								          <td>${content }</td>
								          <td>
								          	<div class="dropdown">
											  <button class="btn btn-warning-outline dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
											  	<span class="fa fa-cog"></span>
											    <span class="caret"></span>
											  </button>
											  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
											    <li role="presentation"><s:a role="menuitem" tabindex="-1" action="role_updateUI?id=%{id}">修改角色</s:a></li>
											    <li role="presentation"><s:a role="menuitem" cssClass="js-delete" tabindex="-1" action="role_delete?ids=%{id }">删除角色</s:a></li>
											    <li role="presentation"><s:a role="menuitem" tabindex="-1" action="role_setUI?id=%{id }">设置权限</s:a></li>
											  </ul> 
											</div>
								          </td>
								        </tr>								        
						        		</s:iterator>
						        	</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>	
</html>
