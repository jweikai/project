package com.filter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.Const;
import com.commons.FileUtils;

public class File404Filter extends HttpServlet implements Filter{
	private static String ROOTPATH; 
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ROOTPATH = filterConfig.getServletContext().getRealPath("/");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String servletPath = request.getServletPath();	
		if ( servletPath.startsWith("/extends/ueditor") ) {
			chain.doFilter(request, response);
			return ;
		}
		if ( servletPath.endsWith(".jsp") ) {	//不允许直接访问jsp
			response.sendRedirect(request.getContextPath() + "/error/404.html");
		}
		
		String realPath = ServletActionContext.getServletContext().getRealPath(servletPath);
		File file = new File(realPath);			
		if ( !file.exists() ) {
			File pFile = file.getParentFile();
			File imgDefault = getDefaultImg(pFile);
			BufferedInputStream bufr = new BufferedInputStream(new FileInputStream(imgDefault));
			byte[] buf = new byte[2048];
			int len = 0;
			OutputStream out = response.getOutputStream();
			while ( (len = bufr.read(buf)) > 0 ) {
				out.write(buf, 0, len);
				out.flush();
			}
			bufr.close();
			out.close();
			return ;
		}
		chain.doFilter(request, response);
	}

	private File getDefaultImg(File parentFile) {
		String[] temp = {".jpg", ".png"};
		File imgDefault = null;
		for (String ext : temp ) {
			 imgDefault = new File(parentFile, Const.IMG_DEFAULT_NAME + ext);
			 if ( imgDefault.exists() ) return imgDefault;
		}
		imgDefault = new File(ROOTPATH, Const.SYS_DEFAULT_IMG);
		return imgDefault;
	}

}
