package com.action.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.Const;
import com.annotation.Admin;
import com.model.po.Authority;
import com.model.vo.AuthorityVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.AuthorityService;

@Admin
@Controller
@Scope("prototype")
public class AdminIndexAction extends ActionSupport{
	
	public String index() { 
		return "index";
	}
}
