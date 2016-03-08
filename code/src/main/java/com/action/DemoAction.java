package com.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.Const;
import com.action.base.BaseAction;
import com.annotation.Common;
import com.annotation.Log;
import com.commons.MyBeanUtils;
import com.model.po.User;
import com.model.vo.UserVO;
import com.service.LogsService;
import com.service.UserService;

@Controller
@Scope("prototype")
public class DemoAction extends BaseAction<User>{
	@Resource
	private LogsService logsService;	
	@Resource
	private UserService userService;
	
	@Log(value = "demo首页")
//	@Common 
	public String index() {
//		System.out.println("id=" + model.getId());
//		System.out.println(model.getName() + "111");
		System.out.println(33); 
		return "index";
	}	
	@Common
	public String head() {
		return "head";
	}
	@Common
	public void login() {
		getSession().setAttribute(Const.LOGIN_USER_SESSION_KEY, getUser());
	}
	private UserVO getUser() {
		UserVO vo = new UserVO();
		User user = userService.getById(Const.TEST_USER_ID);
		MyBeanUtils.copy(vo, user);
		return vo;
	}
	
	public void logout() {
		removeCurrentUser();		
	}
	
}
