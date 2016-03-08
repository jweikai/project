<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<%@include file="public/head.jspf" %>
	    <script type="text/javascript" src="${pageContext.request.contextPath }/extends/js/highcharts.js" ></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath }/backpages/js/global.js" ></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath }/backpages/js/index.js" ></script>
	</head>
	<body>		
		<%@include file="public/nav.jspf" %>
		<div class="container" id="main">
			<div class="row">
				<%@include file="public/left.jspf" %>
				<div id="content" class="col-lg-10 col-md-10">
					<!-- nav breadcrumb start -->
					<%@include file="public/breadcrumb.jspf" %>
					<!-- nav breadcrumb end -->
					<div class="admin-info row">
						<div class="col-md-3 col-xs-12">
							<div class="panel panel-default">
								<div class="panel-body text-center">
									<img src="${pageContext.request.contextPath }/backpages/images/face.jpg" width="120" class="img-circle img-responsive" style="display: inline;" />
								</div>
								<div class="panel-footer">
									您好，admin，这是您第8次登录，上次登录为&nbsp;<time>2014-10-1</time>。
								</div>
							</div>
						</div>
						<div class="col-md-9 col-xs-12">
							<div class="alert alert-warning">
								<span class="fa fa-close pull-right trans"></span>
								<strong>注意：</strong>您有5条未读信息，<a class="alert-link" href="#">点击查看</a>。
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">Code网站介绍</div>
								<div class="panel-body">
									<div class="col-md-6">
										<p style="margin-bottom: 8px;">如果你对网站使用不太熟悉,请看帮助</p>
										<a class="btn btn-success-outline"><span class="fa fa-file"></span>&nbsp;查看使用文档</a>
									</div>
									<div class="col-md-6">
										<p style="margin-bottom: 8px;">下面按钮可以更改你系统的配置</p>
										<a class="btn btn-warning"><span class="fa fa-cogs"></span>&nbsp;系统设置</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="hcharts">
						<div class="col-md-6" id="hc-userFlow"></div>
						<div class="col-md-6" id="hc-problemCount"></div>
					</div>
					
					<div id="cnter">
						<div class="col-md-3 col-xs-12">
							<div class="panel panel-default">
								<div class="panel-heading">站点统计</div>
								<div class="panel-body">
									<ul class="list-group">
					                	<li class="list-group-item"><span class="pull-right badge progress-bar-danger">88</span><span class="fa fa-user"></span> 用户</li>
					                    <li class="list-group-item"><span class="pull-right badge btn-white">828</span><span class="fa fa-file"></span> 题目</li>
					                    <li class="list-group-item"><span class="pull-right badge btn-white">828</span><span class="fa fa-shopping-cart"></span> 竞赛</li>
					                    <li class="list-group-item"><span class="pull-right badge btn-white">828</span><span class="fa fa-file-text"></span> 消息</li>
					                    <li class="list-group-item"><span class="pull-right badge btn-white">828</span><span class="fa fa-database"></span> 公告</li>
					                </ul>
								</div>
							</div>
						</div>
						<div class="col-md-9 col-xs-12">
							<div class="panel panel-default">
								<div class="panel-heading">系统信息</div>
								<div class="panel-body">
									<ul class="list-group">
										<table class="table">
											<tbody>
												<tr><th colspan="2">服务器信息</th><th colspan="2">系统信息</th></tr>
							                    <tr><td width="110" align="right">操作系统：</td><td>Windows 2008</td><td width="90" align="right">系统开发：</td><td><a href="#" target="_blank">多梦网站</a></td></tr>
							                    <tr><td align="right">Web服务器：</td><td>Apache</td><td align="right">主页：</td><td><a href="index.html" target="_blank">点击这里</a></td></tr>
							                    <tr><td align="right">程序语言：</td><td>PHP</td><td align="right">邮箱：</td><td><a href="#" target="_blank">jweikai@163.com</a></td></tr>
							                    <tr><td align="right">数据库：</td><td>MySQL</td><td align="right">qq：</td><td><a href="#" target="_blank">380560757</a> (点击加入)</td></tr>
							                </tbody>
										</table>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>			
		</div>
	</body>	
</html>

