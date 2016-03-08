package com.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ActionSupport;



/**
 * 验证码
 * @author J.L.Zhou
 *
 */
@Namespace("/")
public final class CheckAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8880402636646846741L;
	private final static String SESSION_CHECK_NAME = "SESSION_CHECK_NAME8880402636646846741L";

	public final static boolean check(String input){
		String s = (String) ServletActionContext.getRequest().getSession().getAttribute(SESSION_CHECK_NAME);
		if(s==null||"".equals(s)){
			return false;
		}
		if(s.equals(input)){
			return true;
		}
		return false;
	}
	@Override
	public String execute(){
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires",Integer.MIN_VALUE);

		return "stream";
	}
	public InputStream getInputStream(){

		int width = 80;
        int height = 26;
        BufferedImage image = new BufferedImage(width, height, 1);
        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Arial Narrow", 1, 24));
        for(int i = 0; i < 30; i++)
        {
            g.setColor(getRandColor(160, 250));
            int x = 0;
            int y = random.nextInt(height);
            
            g.drawLine(x, y, width, random.nextInt(height));
        }

        String sRand = "";
        for(int i = 0; i < 4; i++)
        {
            String rand = String.valueOf(random.nextInt(10));
            sRand = sRand + rand;
            Graphics2D g2d = (Graphics2D)g;
            int tempjiaodu = random.nextInt(50) - 25;
            g2d.rotate(Math.toRadians(tempjiaodu));
            g2d.setColor(new Color(random.nextInt(150), random.nextInt(150), random.nextInt(150)));
            g2d.drawString(rand, 9, 22);
            g2d.rotate(Math.toRadians(-tempjiaodu));
            g2d.translate(14, 0);
        }

        ServletActionContext.getRequest().getSession().setAttribute(SESSION_CHECK_NAME, sRand);
        g.dispose();
       

      	
	    try {
	    	ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(image, "JPEG", out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getContentType(){
		return "image/jpeg";
	}
	
	public Color getRandColor(int fc, int bc)
    {
        Random random = new Random();
        if(fc > 255)
            fc = 255;
        if(bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);        
        return new Color(r, g, b);
    }
}
