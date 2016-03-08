package com.commons;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.model.vo.CMDResult;

public class CMDUtils {
	private static final Logger logger = Logger.getLogger(CMDUtils.class);
	/**
	 * single cmd 只判断程序是否出错，不返回错误信息
	 * @param cmd cmd命令
	 * @return
	 */
	public static CMDResult singleCMD(String cmd){
        Process p = null;
        CMDResult result = new CMDResult();
        try {
            p = runCommand(cmd);
            if ( isError(p) ) {
            	logger.error("命令行出错");
            	result.setSuccess(false);
            }else {
            	result.setSuccess(true);
            }                    
            p.getErrorStream().close();
            p.getOutputStream().close();                       
        } catch (Exception e) {
            logger.error("程序出现异常出错！");
            e.printStackTrace();
        }
        return result;
    }
	private static Process runCommand(String cmd) throws IOException {
		cmd = "cmd /c " + cmd;
		logger.info("执行cmd命令: " + cmd);
		return Runtime.getRuntime().exec(cmd);
	}
	public static CMDResult infoCMD(String cmd){
		 Process p = null;
		 CMDResult result = new CMDResult();
	     try {
	    	 p = runCommand(cmd);
	    	 if ( !isError(p) ) { 
	    		 result.setInfo(getInfo(p.getInputStream()));
	    		 result.setSuccess(true);
	    	 }else {
	    		 result.setInfo(getInfo(p.getErrorStream()));
	    		 result.setSuccess(false);
	    	 }
	    	 p.getOutputStream().close();
	     }catch (IOException e) {
	    	 logger.error("程序出现异常出错！");
	         e.printStackTrace();
	     }
	     return result;
	}
	
	public static CMDResult runCMD(String cmd, boolean showInfo, String ...args){
		return showInfo ? infoCMD(String.format(cmd, args)) : singleCMD(String.format(cmd, args));		
    }
	private static boolean isError(Process p) {
		InputStream is = null;		
		int len = -1;
		try {
			is = p.getErrorStream();			
			byte[] buf = new byte[1];
			len = is.read(buf);			
		}catch (IOException e ) {
			logger.error("程序出现异常出错！");
			e.printStackTrace();
		}
		return len == -1 ? false : true;
	}
	
	private static String getInfo(InputStream ins) {
    	BufferedReader reader = null;
    	StringBuffer sb = new StringBuffer("");
    	try {
	        try {                  	
	            reader = new BufferedReader(new InputStreamReader(ins));
	            String line = null;
	            while ((line=reader.readLine())!=null) {   
	                sb.append(line);        
	            }
	        }finally {
	        	if ( ins != null ) {
	        		ins.close();
	        	}
	        	if ( reader != null ) {
					reader.close();
	        	}
	        }
    	}catch (IOException e ) {
    		e.printStackTrace();
    	}
        return sb.toString();
    }
}
