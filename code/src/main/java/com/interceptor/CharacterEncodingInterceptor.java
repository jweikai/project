package com.interceptor;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CharacterEncodingInterceptor implements Interceptor {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8431706291345444120L;
	private static final String n = Long.toString(serialVersionUID, 16);
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = (HttpServletRequest)invocation.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		if ( request.getAttribute(n) == null ) {
			request.setAttribute(n, true);
			request.setCharacterEncoding("utf-8");
			HttpServletResponse response = (HttpServletResponse) invocation.getInvocationContext().get(StrutsStatics.HTTP_RESPONSE);
			response.setCharacterEncoding("utf-8");
			
			if ( "GET".equals(request.getMethod().toUpperCase()) ) {
				Iterator<String[]> iter = request.getParameterMap().values().iterator();
				while ( iter.hasNext() ) {
					String[] params = iter.next();
					for (int i = 0; i < params.length; i ++) {
						try {
							params[i] = new String(params[i].getBytes("iso8859-1"), "utf-8");
						}catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return invocation.invoke();
	}

}
