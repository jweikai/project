package com.interceptor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Const;
import com.alibaba.fastjson.JSON;
import com.annotation.Admin;
import com.annotation.Common;
import com.model.vo.Json;
import com.model.vo.RoleVO;
import com.model.vo.UserVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.service.AuthorityService;

/**
 * 前端是否登陆
 * @author hadoop
 *
 */
@SuppressWarnings("unchecked")
public class SessionInterceptor extends AbstractInterceptor{
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String methodName = invocation.getProxy().getMethod();
		Class actionClass = invocation.getAction().getClass();
		Common common = actionClass.getMethod(methodName).getAnnotation(Common.class);		
		Admin admin = (Admin) actionClass.getAnnotation(Admin.class);
		
		UserVO user = (UserVO) request.getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY);
		String actionName = invocation.getProxy().getActionName();
		if ( admin != null ) {	//后台		
			if ( user == null ) {
				request.setAttribute("visitUrl", actionName);
				return "adminLogin";
			}
			Json json = hasAuthorityUrl(user, actionName);
			if ( json.isSuccess() ) {
				return invocation.invoke();
			}else {
				ActionContext.getContext().getValueStack().push(json);
				return "errorInfo";
			}
		}
		if ( common == null ) {	//不是公共页面
			if ( user == null ) {
				request.setAttribute("visitUrl", actionName);
				return "commonLogin";
			}
		}
		return invocation.invoke();
	}
	private Json hasAuthorityUrl(UserVO user, String url) {
		Json json = new Json();
		json.setSuccess(user.hasAuthorityByUrl(url));
		if ( !json.isSuccess() ) {
			json.setMsg("你无权访问该页面");
		}
		return json;
	}

}
