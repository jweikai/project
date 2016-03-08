package com.commons;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class MyFileDownUtils {

	public static String[] onLineExt={"txt","pdf","png","jpg","gif"};
	  /**
		 * 获取文件后缀 不包括.
		 * @param fileName
		 * @return
		 */
	    public static String getFileExt(String fileName){
	    	if (fileName == null) return "";
	    	String ext = "";
			int lastIndex = fileName.lastIndexOf(".");
			if (lastIndex >= 0) {
				ext = fileName.substring(lastIndex + 1).toLowerCase();
			}
			return ext;
	    }
	    
	    /**
		 * 获取文件名
		 * 
		 * @return
		 */
	    public static String getFileNameExt(String fileName){
	    	if (fileName == null) return "";
	    	String ext = "";
			int lastIndex = fileName.lastIndexOf("/");
			if (lastIndex >= 0) {
				ext = fileName.substring(lastIndex + 1).toLowerCase();
			}
			return ext;
	    }
	   public static String down(String savePath,String name,HttpServletRequest request,HttpServletResponse response){  
	    	OutputStream toClient=null;
	    	PrintWriter out = null;
	    	try{
	    		String path=savePath;
	    		String realpath=ServletActionContext.getServletContext().getRealPath(path);
		        File file = new File(realpath);  
		        if(!file.exists()){
		        	//不存在
		        	System.out.println("文件不存在");
		        	return "error";
		        	/*out = ServletActionContext.getResponse().getWriter();
		        	out.print("<script type='text/javascript'>alert('文件不存在');location.href='./'</script>");*/
		        }
		        response.setContentType("application/octet-stream"); 
		        // 根据不同浏览器 设置response的Header
		        String userAgent = request.getHeader("User-Agent").toLowerCase();
		        
		        if(userAgent.indexOf("msie")!=-1){
		        	//ie浏览器
		        	//System.out.println("ie浏览器");
		        	response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(name,"utf-8")); 
		        	
		        }else{
		        	response.addHeader("Content-Disposition", "attachment;filename=" + new String(name.getBytes("utf-8"),"ISO8859-1"));  
		        }
		        
		        response.addHeader("Content-Length", ""+file.length());   
		        //以流的形式下载文件  
		        InputStream fis = new BufferedInputStream(new FileInputStream(realpath));  
		        byte[] buffer = new byte[fis.available()];  
		        fis.read(buffer);  
		        fis.close();  
		        toClient = new BufferedOutputStream(response.getOutputStream());  
		        toClient.write(buffer);  
		        toClient.flush(); 
		        return null;
		      }catch (Exception e) {
		    	  e.printStackTrace();
		    	  response.reset(); 
		    	  return null;
		      }finally{
					if(toClient!=null){
			           	 try {
			           		toClient.close();
						  } catch (IOException e) {
								e.printStackTrace();
							}
			            }
					}
	    } 
	  
	   
	   
	   public static String online(String savePath,String name,String ext,HttpServletRequest request,HttpServletResponse response){  
	    	OutputStream toClient=null;
	    	PrintWriter out = null;
			
	    	try{
	    		String path=savePath;
	    		String realpath=ServletActionContext.getServletContext().getRealPath(path);
		        File file = new File(realpath);  
		        if(!file.exists()){
		        	System.out.println("文件不存在");
		        	out = ServletActionContext.getResponse().getWriter();
		        	out.print("<script type='text/javascript'>alert('文件不存在');</script>");
		        }
		        if(!inOnLineExt(ext)){
		        	 response.setContentType("application/octet-stream"); 
		        }
		        // 根据不同浏览器 设置response的Header
		        String userAgent = request.getHeader("User-Agent").toLowerCase();
		        
		        if(userAgent.indexOf("msie")!=-1){
		        	//ie浏览器
		        	//System.out.println("ie浏览器");
		        	response.addHeader("Content-Disposition", "inline;filename=" + URLEncoder.encode(name,"utf-8")); 
		        	
		        }else{
		        	response.addHeader("Content-Disposition", "inline;filename=" + new String(name.getBytes("utf-8"),"ISO8859-1"));  
		        }


				 if("DOC" .equals(ext)){response.setHeader("Content-type", "application/msword");}
				 else if("DOCX" .equals(ext)){response.setHeader("Content-type","application/vnd.openxmlformats-officedocument.wordprocessingml.document");}
				 else if("PDF" .equals(ext)){response.setHeader("Content-type","application/pdf");}
				 else if("TXT" .equals(ext)){response.setHeader("Content-type","text/html");}
				 else if("XLS" .equals(ext)){response.setHeader("Content-type","application/vnd.ms-excel");}
				 else if("XLSX" .equals(ext)){response.setHeader("Content-type","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");}
				 else if("PPT" .equals(ext)){response.setHeader("Content-type","application/vnd.ms-powerpoint");}
				 else if("PPTX" .equals(ext)){response.setHeader("Content-type","application/vnd.openxmlformats-officedocument.presentationml.presentation");}
				 else if("BMP" .equals(ext)){response.setHeader("Content-type","image/bmp");}
				 else if("GIF" .equals(ext)){response.setHeader("Content-type","image/gif");}
				 else if("IEF" .equals(ext)){response.setHeader("Content-type","image/ief");}
				 else if("JPEG" .equals(ext)){response.setHeader("Content-type","image/jpeg");}
				 else if("JPG" .equals(ext)){response.setHeader("Content-type","image/jpeg");}
				 else if("PNG" .equals(ext)){response.setHeader("Content-type","image/png");}
				 else if("TIFF" .equals(ext)){response.setHeader("Content-type","image/tiff");}
				 else if("TIF" .equals(ext)){response.setHeader("Content-type","image/tif");}

		        
		        response.addHeader("Content-Length", ""+file.length());   
		        //以流的形式下载文件  
		        InputStream fis = new BufferedInputStream(new FileInputStream(realpath));  
		        byte[] buffer = new byte[fis.available()];  
		        fis.read(buffer);  
		        fis.close();  
		        toClient = new BufferedOutputStream(response.getOutputStream());  
		        toClient.write(buffer);  
		        toClient.flush(); 
		        return null;
		      }catch (Exception e) {
		    	  e.printStackTrace();
		    	  response.reset(); 
		    	  return null;
		      }finally{
					if(toClient!=null){
			           	 try {
			           		toClient.close();
						  } catch (IOException e) {
								e.printStackTrace();
							}
			            }
					}
	    }  
	   
	   private static boolean inOnLineExt(String ext){
	    	
	    	for(String s:onLineExt){
	    		if(s.equalsIgnoreCase(ext)){
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	   
}
