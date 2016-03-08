<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<%@include file="../public/head.jspf" %>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/extends/css/animate.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/backpages/css/role/role-authority.css" />	    
		<script type="text/javascript" src="${pageContext.request.contextPath }/backpages/js/global.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/backpages/js/role/authority_list.js" ></script>
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
							<form class="form-inline">
								<s:a action="authority_addUI" cssClass="btn btn-primary-outline">添加权限</s:a>
								<s:a cssClass="btn btn-danger-outline" action="authority_delete" id="removeAllAuthorityBtn">清空所有用户权限</s:a>
							</form>
							<table class="table table-hover">
								<thead>
									<tr>
										<th>编号</th>
										<th>用户列表</th>
										<th>拥有权限</th>
									</tr>
								</thead>
						        <tbody>
						        	<s:iterator value="#users" var="u">
						        	<tr>
						        		<td class="js-td-user-id">${id }</td>						        		
						        		<td><s:a cssClass='single-word' action="authority_addUI?userId=%{id }">${name }</s:a></td>
						        		<td>
					        			<s:iterator value="roles">
					        				<span class="minus-right"><s:a cssClass="fa fa-minus js-delete" action="authority_delete?userId=%{#u.id}&id=%{id }"></s:a>&nbsp;${name }</span>
					        			</s:iterator>
						        		</td>
						        	</tr>
						        	</s:iterator>
						        </tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="col-md-10">
					<div class="panel panel-default">
						<div class="panel-heading"><span class="fa fa-plus"></span>&nbsp;权限备份/恢复<small class='data-help js-data-help'>---最多保存10个备份文件</small></div>
						<div class="panel-body">
							<a class="btn btn-warning-outline" id="data-back" href="javascript:;">数据备份</a>
							<a class="btn  btn-success-outline" id="data-recover" href="javascript:;">数据恢复</a>
						</div>
						<div class="panel-footer row">
							<div class='col-md-12 js-data-deal' style="padding:10px 20px;">	
							</div>
						</div>
					</div>
				</div>
			</div>			
		</div>
	</body>	
</html>
