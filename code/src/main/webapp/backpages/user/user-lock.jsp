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
							<form class="form-horizontal" action="lock" method="post">
								<s:hidden name="id" value="%{id }"></s:hidden>
								<div class="form-group">
									<div class="col-sm-3">
										<div class="checkbox pull-right">
											<label>
												<s:checkbox name="isLock"></s:checkbox> 是否锁定用户
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">									
									<label for="lock-content" class="col-sm-2 control-label">锁定原因</label>
								    <div class="col-sm-10">
								    	<s:textarea name="lockReason" cssClass="form-control" rows="5"></s:textarea>								      
								    </div>
								</div>
								<div class="form-group text-center">
									<button type="submit" class="btn btn-success-outline">提交</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>			
		</div>
	</body>	
</html>
