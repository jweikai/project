<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<%@include file="../public/head.jspf" %>
	    <link rel="stylesheet" href="${pageContext.request.contextPath }/backpages/css/role/role-authority.css" />
	    <script type="text/javascript" src="${pageContext.request.contextPath }/backpages/js/role/role-authority.js" ></script>
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
							<form action="set">
								<s:hidden name="id"></s:hidden>
								<s:iterator value="#authorityTop">	
								<div class="bs-callout bs-callout-<s:property value="colorCls()" /> js-user-authority">
									<h4 class="js-authority-parent">
										<div class="checkbox">
										    <label>
										      	<input name="authorityIds" value="${id }" <s:property value="%{id in authorityIds ? 'checked' : ''}"/> type="checkbox"> ${name }
										    </label>
									  	</div>
									</h4>
									<s:iterator value="authorities">
									<div class="bs-callout js-user-authority">	
										<h5 class="bs-callout-info js-authority-parent">
										<div class="checkbox">
										    <label>
										      <input name="authorityIds" value="${id }" <s:property value="%{id in authorityIds ? 'checked' : ''}"/> type="checkbox"> ${name }
										    </label>
									  	</div>
									  	</h5>		
									  	<s:if test="authorities.size != 0">
									  	<div class="bs-callout-list">
										  	<s:iterator value="authorities">
									  		<div class="checkbox">
											    <label>
											      <input name="authorityIds" value="${id }" <s:property value="%{id in authorityIds ? 'checked' : ''}"/> type="checkbox"> ${name }
											    </label>
										  	</div>										  	
										  	</s:iterator>
									  	</div>
									  	</s:if>
								  	</div>
									</s:iterator>
								</div>
								</s:iterator>
								<button class="btn btn-success-outline pull-right" type="submit">确认更改</button>
							</form>
						</div>
					</div>
				</div>
			</div>			
		</div>
	</body>	
</html>
