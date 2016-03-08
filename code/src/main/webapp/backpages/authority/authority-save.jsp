<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<%@include file="../public/head.jspf" %>
	    <link rel="stylesheet" href="${pageContext.request.contextPath }/backpages/css/role/role-authority.css" />
	    <script type="text/javascript" src="${pageContext.request.contextPath }/extends/js/bootstrap.autocomplete.js" ></script>	   
	    <script type="text/javascript" src="${pageContext.request.contextPath }/backpages/js/global.js" ></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath }/backpages/js/role/authority_save.js" ></script>
	</head>
	<body>
		<!-- header start -->
		<%@ include file="../public/nav.jspf" %>
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
							<form class="form-horizontal" action="add" method="post">							
								<s:hidden name="userId" value="%{#user.id}"></s:hidden>
								<div class="form-group js-form-username">
								    <label class="col-sm-2 control-label">用户名</label>
								    <div class="col-sm-8">								    	
								      <s:textfield type="text" autocomplete="off" cssClass="form-control" name="userName" id="js-search-key" value="%{#user.name}"></s:textfield>
								      <span class="input-group-addon js-reselect-user" style="display:none;"><i class="fa fa-minus"></i></span>								      
								    </div>
								    <div class="col-sm-2">
								    	<span class="js-error"></span>
								    </div>
								</div>
								<div class="form-group">
								    <label class="col-sm-2 control-label">选择权限</label>
								    <div class="col-sm-10">								    													    				    	
										<s:select list="#roles" multiple="true" size="5" name="roleIds" cssClass="form-control js-roles"
											listKey="id" listValue="name"></s:select>
								    </div>
								</div>															
								<button type="submit" id="user-role-btn" style="margin-top: 10px; <s:if test="%{#user.id == null}">display: none;</s:if>" class="btn btn-success-outline pull-right">确认</button>
							</form>
						</div>
					</div>
				</div>
			</div>			
		</div>
	</body>	
</html>


