package com.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.annotation.Admin;
import com.model.vo.AuthorityVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("unchecked")
public class InjectAdminDataInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String actionName = invocation.getProxy().getActionName();
		Class actionClass = invocation.getAction().getClass();
		Admin admin = (Admin) actionClass.getAnnotation(Admin.class);
		
		Map<String, AuthorityVO> map = (Map<String, AuthorityVO>) ActionContext.getContext().getApplication().get("authoritiesMap");
		if ( admin != null ) {			
			if ( actionName.endsWith("UI") ) {
				actionName = actionName.substring(0, actionName.length()-2);
			}
			AuthorityVO authority = map.get(actionName);
			if ( authority == null ) {
				authority = new AuthorityVO();
				authority.setName("首页");
				authority.setIcon("home");
				authority.setUrl(request.getContextPath() + "/index");
			}
			ActionContext.getContext().put("cAuth", authority);
		}
		return invocation.invoke();
	}

}
