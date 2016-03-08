package com.filter;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.context.ApplicationContext;

import com.Const;
import com.commons.MyBeanUtils;
import com.model.po.User;
import com.model.vo.UserVO;
import com.service.UserService;

public class MyStrutsFilter extends StrutsPrepareAndExecuteFilter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String url = request.getRequestURI();
		if (url.contains("/ueditor/jsp")) {	//解决ueditor问题
			chain.doFilter(req, resp);
		} else {
			super.doFilter(req, resp, chain);
		}
	}	
}

