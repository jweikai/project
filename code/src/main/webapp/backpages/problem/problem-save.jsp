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
					<div class="panel panel-default">
						<%@include file="../public/content-head.jspf" %>
						<div class="panel-body">
							<form action="${id == null ? 'add' : 'update' }" class="form-horizontal" method="post">
								<s:hidden name="id"></s:hidden>
								<div class="form-group">
									<label for="inputName" class="col-md-2 control-label">题目名</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="inputName" name="title" placeholder="请输入题目名称" />
									</div>
								</div>
								<div class="form-group">
									<label for="inputLimitTime" class="col-md-2 control-label">时间限制</label>
									<div class="col-md-4">
										<div class="input-group">
											<input type="text" class="form-control" value="1000" id="inputLimitTime" name="timeLimit" placeholder="Time Limit" />
											<span class="input-group-addon">ms</span>
										</div> 
									</div>									
								</div>
								<div class="form-group">
									<label for="inputMemoryLimit" class="col-md-2 control-label">内存限制</label>
									<div class="col-md-4">
										<div class="input-group">
											<input type="text" class="form-control" value="128" id="inputMemoryLimit" name="memoryLimit" placeholder="Memory Limit" />
											<span class="input-group-addon">MByte</span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="inputType" class="col-md-2 control-label">题目类型</label>
									<div class="col-md-3">
										<select id="inputType" name="type" class="form-control">
										  <option>选择题目类型</option>
										  <option>Algorithm</option>
										  <option>DataBase</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="inputDifficulty" class="col-md-2 control-label">题目难度</label>
									<div class="col-md-3">
										<select id="inputDifficulty" name="difficulty" class="form-control">
											<option>请选择题目难度</option>
											<option>Level Ⅰ</option>
											<option>Level Ⅱ</option>
											<option>Level Ⅲ</option>
											<option>Level Ⅳ</option>
											<option>Level Ⅴ</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="container" class="col-md-2 control-label">题目描述</label>
									<div class="col-md-10">
										<!-- 加载编辑器的容器 -->								 
									    <script id="container" name="description" type="text/plain">
									    </script>
									    <!-- 配置文件 -->
									    <script type="text/javascript" src="${pageContext.request.contextPath }/extends/ueditor/ueditor.config.js"></script>
									    <!-- 编辑器源码文件 -->
									    <script type="text/javascript" src="${pageContext.request.contextPath }/extends/ueditor/ueditor.all.min.js"></script>
									    <!-- 实例化编辑器 -->
									    <script type="text/javascript">
									        var ue = g.createUE('container');
									    </script>
									    <!-- 提交comment -->
									</div>
								</div>
								<div class="form-group">
									<label for="inputContainer" class="col-md-2 control-label">输入描述</label>
									<div class="col-md-10">
										<script id="inputContainer" name="inputDesc" type="text/plain"></script>
										<script type="text/javascript">
											var iue = g.createUE('inputContainer');
										</script>
									</div>
								</div>
								<div class="form-group">
									<label for="outputContainer" class="col-md-2 control-label">输出描述</label>
									<div class="col-md-10">
										<script id="outputContainer" name="outputDesc" type="text/plain"></script>
										<script type="text/javascript">
											var oue = g.createUE('outputContainer');
										</script>
									</div>
								</div>
								<div class="form-group">
									<label for="testInput" class="col-md-2 control-label">测试输入数据</label>
									<div class="col-md-6">
										<textarea class="form-control" id="testInput" name="testInput" rows="5" style="resize: none;" placeholder="请输入输入数据"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="testOutput" class="col-md-2 control-label">测试输出数据</label>
									<div class="col-md-6">
										<textarea class="form-control" id="testOutput" name="testOutput" rows="5" style="resize: none;" placeholder="请输入输出数据"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="inputHint" class="col-md-2 control-label">提示</label>
									<div class="col-md-10">
										<script id="hintContainer" name="hint" type="text/plain"></script>
										<script type="text/javascript">
											var hue = g.createUE('hintContainer', {
												initialFrameHeight: 180
											});
										</script>
									</div>
								</div>
								<div class="form-group">
									<label for="inputSource" class="col-md-2 control-label">来源</label>
									<div class="col-md-6">
										<input type="text" class="form-control" id="inputSource" name="source" placeholder="输入题目来源"></textarea>
									</div>
								</div>
								
								<!--如果是从比赛/竞赛中添加过来的
								<div class="form-group">
									<label for="inputSource" class="col-md-2 control-label">比赛</label>
									<div class="col-md-3">
										<input type="text" class="form-control" value="#Div 1" readonly></textarea>
									</div>
								</div>
								-->
								<div class="form-group text-center">
									<button class="btn btn-success-outline" style="padding: 8px 60px;">提交</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>			
		</div>
	</body>	
</html>
