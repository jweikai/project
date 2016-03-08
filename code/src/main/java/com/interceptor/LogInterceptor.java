package com.interceptor;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Const;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.annotation.Log;
import com.commons.IpUtil;
import com.model.po.Logs;
import com.model.vo.UserVO;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.service.LogsService;

public class LogInterceptor implements Interceptor {
	@Resource
	private LogsService logsService;
	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String methodName = invocation.getProxy().getMethod();
		Log log = invocation.getAction().getClass().getMethod(methodName).getAnnotation(Log.class);
		if ( log != null ) {			
			String ret = null;
			Exception ex = null;
			HttpServletRequest request = ServletActionContext.getRequest();
			Logs logs = new Logs();
			logs.setDoing(log.value());
			logs.setIp(IpUtil.getIpAddr(request));
			logs.setTime(Const.getCurrentTimestamp());
			logs.setIsSuccess(true);
			if ( !log.excludeAll() ) {
				Map<String, String[]> pm = new HashMap<String, String[]>();
				Set<String> es = new HashSet<String>();
				Collections.addAll(es, log.exclude());
				for (Object k : request.getParameterMap().keySet()) {
					String key = (String) k;
					if ( !es.contains(key) ) {
						pm.put(key, request.getParameterValues(key));
					}
				}
				String ps = JSON.toJSONString(pm);
				if ( ps.length() > 2 ) { //{}
					logs.setParams(ps);
				}
			}
			logs.setUrl(request.getRequestURI().substring(request.getContextPath().length()));
			if ( request.getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY) == null ) {
				logs.setUserRealName("游客");
			}else {
				UserVO userVO = (UserVO) request.getSession().getAttribute(Const.LOGIN_USER_SESSION_KEY);
				logs.setUserId(userVO.getId());
				logs.setUserRealName(userVO.getName());				
			}
			try {
				ret = invocation.invoke();				
			}catch ( Exception e ) {
				ex = e;
				StringWriter out = new StringWriter();
				PrintWriter pw = new PrintWriter(out);
				e.printStackTrace(pw);
				logs.setIsSuccess(false);
				logs.setMsg(out.toString());
			}			
			logsService.save(logs);
			if ( ex == null ) {
				return ret;
			}else {
				throw ex;
			}
		}
		return invocation.invoke();
	}
	
}
