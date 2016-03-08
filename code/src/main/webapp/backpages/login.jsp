<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <%@include file="public/head.jspf" %>
    <title>Code后台管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/extends/css/animate.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/backpages/css/login.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/backpages/js/global.js" ></script>    
</head>
<body>
<div class="admin_login_wrap">
    <h1>Code后台管理</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="${visitUrl==null ? 'index' : visitUrl }" id="loginForm" method="post">
                <ul class="admin_items">
                    <li> 
                        <label for="user" class="js-user-label" style="position: relative;">用户名：</label>
                        <input type="text" name="name" value="jwk" id="user" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwd">密码：</label>
                        <input type="password" name="password" value="admin" id="pwd" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="提交" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <p class="admin_copyright"><a href="${pageContext.request.contextPath }/index" tabindex="5" href="index">返回前台主页</a> &copy; 2015</a></p>
    <script type="text/javascript">
    $(function() {
    	$("#loginForm").submit(function() {
    		$('.js-user-label').text('用户名：');
    		var $loadDia = $('<span class="fadeInDown animated r color-primary"><i class="fa fa-spinner fa-pulse"></i>&nbsp;Loading...</span>');
    		var $retDia = $('<span class="fadeInLeft animated r color-danger"><i class="fa fa-close"></i>&nbsp;登陆失败</span>');    					
    		$('.js-user-label').append($loadDia);
    		var BASE_URL = '/code';
    		var _$this = $(this);
    		$.ajax({
    			url: BASE_URL + '/admin/login',
    			type:'post',
    			data: $(this).serialize(),
    			dataType: 'json',
    			success: function(resp) {
    				if ( !resp.success )  {
    					$retDia.html('<i class="fa fa-close"></i>&nbsp;'+resp.msg);
    					$loadDia.removeClass('fadeInUp').addClass('fadeOutRight');
    					$('.js-user-label').append($retDia);    					
    				}else {
    					$retDia.removeClass('color-danger').addClass('color-success').html('<i class="fa fa-check"></i>&nbsp;登陆成功');
    					$loadDia.removeClass('fadeInUp').addClass('fadeOutRight');
    					$('.js-user-label').append($retDia);
    					var url = _$this.attr('action');
    					if ( url == 'index' ) {
    						window.location.href = url;
    					}else {
    						window.location.reload();
    					}
    				}
    			},
    			error: function() {
    				$retDia.html('<i class="fa fa-close"></i>&nbsp;登陆失败');
    				$('.js-user-label').append($retDia);
    			}
    		});
    		return false;
    	});
    });
    </script>
</div>
</body>
</html>