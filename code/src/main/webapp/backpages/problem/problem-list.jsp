<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<%@include file="../public/head.jspf" %>		
	    <script type="text/javascript" src="${pageContext.request.contextPath }/backpages/js/global.js" ></script>
	    <style>	    	
	    	.js-status:hover {
	    		color:#8A6D3B;
	    	}
	    </style>
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
							<form class="form-inline" method="post">
								<input type="button" class="btn btn-secondary-outline checkall" name="checkall" id="checkall-btn" value="全选">
								<s:a action="problem_addUI" cssClass="btn btn-info-outline">新题目</s:a>
								<s:a action="problem_delete" cssClass="btn btn-danger-outline" id="delAllBtn">批量删除</s:a>							
								<div class="input-group pull-right">
								  <input type="text" class="form-control" placeholder="输入您要搜索的题目" aria-describedby="basic-addon1" name="key" />
								  <span class="input-group-btn">
								  	<button class="btn btn-secondary-outline" type="button" data-action="list" id='searchBtn'>Go</button>
								  </span>
								</div>
							</form>
							<table class="table table-hover">
					        	<thead>
					        		<tr>
					        			<th>选择</th>
					        			<th>编号</th>
					        			<th>题目</th>
					        			<th>创建时间</th>
					        			<th>测试数据</th>
					        			<th>是否公开</th>
					        			<th>操作</th>
					        		</tr>
					        	</thead>
					        	<tbody>
					        		<s:iterator value="recordList">
					        		<tr>
					        			<td><input type="checkbox" name="ids" value="${id }" /></td>
					        			 <td><strong>${id }</strong></td>
								         <td><a href="detail?id=${id }">${name }</a></td>
								         <td>${createTime }</td>
								         <td><a href="../testdata/list" class="color-primary">TestData</a></td>
								         <td><a class="js-status color-danger" href="lock?id=${id }">private</a></td>
								         <td>
								          	<div class="dropdown">
											  <button class="btn btn-warning-outline dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
											  	<span class="fa fa-cog"></span>
											    <span class="caret"></span>
										  	</button>
										  	<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
										    	<li role="presentation"><s:a role="menuitem" tabindex="-1" action="problem_updateUI?id=%{id }"> 修改</s:a></li>
										    	<li role="presentation"><s:a role="menuitem" cssClass="js-delete" tabindex="-1" action="user_delete?ids=%{id }"> 删除</s:a></li>
										  	</ul>
											</div>
							          	</td>
					        		</tr>
					        		</s:iterator>
					        	</tbody>
							</table>
							<!--page divide start-->
					        <%@include file="../public/pageView.jspf" %>
					        <!-- page divide end -->
						</div>
					</div>
				</div>
			</div>			
		</div>
	</body>	
</html>
