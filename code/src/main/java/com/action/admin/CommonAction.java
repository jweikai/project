package com.action.admin;

import java.util.HashSet;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.Const;
import com.action.base.BaseAction;
import com.alibaba.fastjson.JSON;
import com.annotation.Admin;
import com.annotation.Common;
import com.commons.MD5;
import com.commons.MyBeanUtils;
import com.model.po.Authority;
import com.model.po.Role;
import com.model.po.User;
import com.model.vo.Json;
import com.model.vo.RoleVO;
import com.model.vo.UserVO;
import com.opensymphony.xwork2.ActionSupport;
import com.service.AuthorityService;
import com.service.UserService;

@Controller
@Scope("prototype")
public class CommonAction extends BaseAction<User>{
	@Resource
	private UserService userService;
	@Resource
	private AuthorityService authorityService;
	
	@Common
	public String loginUI() {
		return "loginUI";
	}
	
	@Common
	public void login() {
		Json json = new Json();
		if ( getCurrentUser() != null ) {
			json.setSuccess(true);
		}else {
			User user = userService.login(model.getName(), MD5.MD5Encode(model.getPassword()));
			if ( user != null ) {
				json.setSuccess(true);
				UserVO userVO = new UserVO();
				for (Role r : user.getRoles()) {
					r.setAuthorities(authorityService.findByRole(r));
				}
				MyBeanUtils.copy(userVO, user, 2);
				getSession().setAttribute(Const.LOGIN_USER_SESSION_KEY, userVO);
			}else {
				json.setSuccess(false);
				json.setMsg("帐号或密码错误");
			}
		}
		writeJson(json);
	}	
	public String logout() {
		getSession().removeAttribute(Const.LOGIN_USER_SESSION_KEY);
		return "logout";
	}
}
