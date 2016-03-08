package com.interceptor;


import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.Const;
import com.commons.MyBeanUtils;
import com.model.po.User;
import com.model.vo.UserVO;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.service.UserService;

/**
 * 开发时，根据自己的需求自动添加登陆用户
 * @author J.L.Zhou
 *
 */
@SuppressWarnings("serial")
public class TestUserInterceptor implements Interceptor {

	@Resource
	private UserService userService;	
	
	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {

		UserVO user = (UserVO) ServletActionContext.getRequest()
				.getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY);
		if(user==null){
			User u = userService.getById(Const.TEST_USER_ID);
			user = new UserVO();
			MyBeanUtils.copy(user, u);
			ServletActionContext.getRequest()
				.getSession().setAttribute(Const.LOGIN_USER_SESSION_KEY, user);
		}
		
		return arg0.invoke();
	}


}
