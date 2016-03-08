package com;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.ehcache.CacheManager;

import com.commons.MD5;

public class Const {
	public final static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}
	
	public final static Date getCurrentDate() {
		return new Date();
	}
	public static String getCurrentLocalData() {
		return getLocalData(getCurrentDate());
	}
	
	public static String getLocalData(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		return df.format(date);
	}
	
	/**
	 * 登陆用户的SESSION KEY
	 */
	public final static String LOGIN_USER_SESSION_KEY="LOGIN_USER_SESSION_KEY";
	
	/**
	 * 测试时，默认登陆的账户账户
	 */
	public final static Long TEST_USER_ID = 1L;
	
	/**
	 * super admin
	 */
	public final static Long SUPER_USER_ID = 2L;
	/**
	 * 默认图片名字
	 */
	public final static String IMG_DEFAULT_NAME = "default";
	
	/**
	 * sys默认图片, 请放在根目录
	 */
	public final static String SYS_DEFAULT_IMG = "default.png"; 
	
	private static int[] colorIndexs = new int[28];
	static {
		colorIndexs[0] = 0;
		for (int i = 1; i <= 10; i ++) colorIndexs[i] = 1;
		int m = 2;
		for (int i = 11; i <= 27; i ++) {
			colorIndexs[i] = m;
			if ( i % 2 == 0 ) m ++;
		}
	}
	public static int colorLevel(int rating) {
		rating /= 100;
		if ( rating > 27 )	return 9;
		return colorIndexs[rating];
	}
	private static String[] colorList = {"info", "success", "primary", "warning", "danger"};
	public static String randomC(String name) {
		return colorList[name.codePointAt(0) % colorList.length];
	}
	/**
	 * 判断用户是否是超级管理员
	 * @return
	 */
	public static boolean isAdmin(String name) {
		return "0b28a5799a32c687dad2c5183718ceac".equals(MD5.MD5Encode(name));
	}
	
	/**
	 * superAdminId
	 */
	public final static Long ADMIN_ID = 13L; 
	
	/**
	 * 最大备份数
	 */
	public final static int LIMIT_DATA_BACK_LENGTH = 10;
	
	/**
	 * 不显示的Mune Ids
	 */
	public final static Long[] DO_NOT_SHOW_MENU_IDS = {42L};
}
