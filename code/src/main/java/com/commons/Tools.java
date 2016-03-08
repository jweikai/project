package com.commons;


import java.io.UnsupportedEncodingException;


import java.text.Format;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;




/**
 * 基本工具的函数
 * 
 * @author jlzhou
 * 
 */
public class Tools {



	/**
	 * md5加密码算法 zy
	 * 
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		return MD5.MD5Encode(str);
	}

	/**
	 * 获取列表
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static List<Integer> getList(int a, int b) {
		if (b > a) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			while (b > a) {
				++a;
				temp.add(a);
			}
			return temp;
		} else {
			return null;
		}
	}

	/**
	 * 获取IP的LONG表达
	 * 
	 * @param ip
	 * @return
	 */
	public static long ipLongValue(String ip) {

		try {
			String[] ips = ip.split("\\.");
			return Long.parseLong(ips[0]) * 256 * 256 * 256
					+ Long.parseLong(ips[1]) * 256 * 256
					+ Long.parseLong(ips[2]) * 256 + Long.parseLong(ips[3]);
		} catch (Exception ex) {
			return 0;
		}
	}

	/**
	 * 获取IP的String表达
	 * 
	 * @param ip
	 * @return
	 */
	public static String ipString(long ip) {
		try {
			StringBuffer s = new StringBuffer();
			s.append(ip / (256 * 256 * 256));
			s.append(".");
			ip = ip % (256 * 256 * 256);
			s.append(ip / (256 * 256));
			s.append(".");
			ip = ip % (256 * 256);
			s.append(ip / (256));
			s.append(".");
			s.append(ip % 256);

			return s.toString();
		} catch (Exception ex) {
			return "0.0.0.0";
		}
	}

	/**
	 * URL编码
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String URLEncode(String key) throws Exception {
		return URLEncode(key, "UTF-8");
	}

	/**
	 * URL编码
	 * 
	 * @param key
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public static String URLEncode(String key, String code) throws Exception {
		return java.net.URLEncoder.encode(key, code).replaceAll("%5C", "/")
				.replaceAll("%2F", "/");
	}

	/**
	 * URL解码
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String URLDecoder(String key) throws Exception {
		return URLDecoder(key, "UTF-8");
	}

	/**
	 * URL解码
	 * 
	 * @param key
	 * @param code
	 * @return
	 */
	public static String URLDecoder(String key, String code) {
		try {
			return java.net.URLDecoder.decode(key, code);
		} catch (UnsupportedEncodingException e) {
			return key;
		}
	}

	/**
	 * 对象是否为空(包含obj==null list.size==0 String=="")
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static boolean isNull(Object obj) throws Exception {
		if (obj == null) {
			return true;
		}
		if (obj instanceof List) {
			if (((List<?>) obj).size() > 0) {
				return false;
			} else {
				return true;
			}
		}
		if (obj instanceof String) {
			if (((String) obj).equals("")) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static java.util.Date getDate() {
		return new java.util.Date();
	}

	public static java.util.Date getDate(long d) {
		return new java.util.Date(d);
	}

	public static String formatDate(Date date) {
		return formatDate(date, "yyyy-MM-dd");
	}

	
	public static String formatDate(Date date, String formatString) {
		if (date == null)
			return "";
		try {
			Format format = new SimpleDateFormat(formatString);
			return format.format(date);
		} catch (Exception ex) {
			return date.toString();
		}
	}
	
	public static String date(Date date){
		return formatDate(date);
	}
	public static String time(Date date){
		return formatDate(date,"yyyy-MM-dd HH:mm");
	}
	
	

	public static String formatLong(Number num) {
		return formatLong(num, "%1$d");
	}

	public static String  format(String formatString,Object...objects){
		return String.format(formatString, objects);
	}
	
	public static String formatLong(Number num, String formatString) {
		if (num == null)
			return "";
		return String.format(formatString, num.longValue());
	}

	public static String formatFloat(Number num) {
		return formatFloat(num, "%1$.2f");
	}

	public static String formatFloat(Number num, String formatString) {
		if (num == null)
			return "";
		return String.format(formatString, num.doubleValue());
	}

	/**
	 * 字符串替换
	 * 
	 * @param oldStr
	 * @param fromStr
	 * @param toStr
	 * @return
	 */
	public static StringBuffer replace(StringBuffer oldStr, String fromStr,
			String toStr) {
		StringBuffer tempStr = oldStr;
		try {
			int chlen = 0;
			int len = fromStr.length();
			int tolen = toStr.length();
			int i = tempStr.indexOf(fromStr);
			while (i >= 0) {
				tempStr = tempStr.replace(i, i + len, toStr);
				chlen = i + tolen;
				i = tempStr.indexOf(fromStr, chlen);
			}
		} catch (Exception e) {
			;
		}
		return tempStr;
	}

	/**
	 * 字符串替换
	 * 
	 * @param oldStr
	 * @param fromStr
	 * @param toStr
	 * @return
	 */
	public static String replace(String oldStr, String fromStr, String toStr) {

		StringBuffer tempStr = replace(new StringBuffer(oldStr), fromStr, toStr);
		return tempStr.toString();
	}

	/**
	 * HTML编码
	 * 
	 * @param Str
	 * @return
	 */
	public static String HTMLEncode(String Str) {
		if (Str == null) {
			return "";
		}
		StringBuffer tempStr = new StringBuffer(Str);
		tempStr = replace(tempStr, "&", "&amp;");
		tempStr = replace(tempStr, "$", "&#36;");
		tempStr = replace(tempStr, "@", "&#64;");
		tempStr = replace(tempStr, "<", "&lt;");
		tempStr = replace(tempStr, ">", "&gt;");
		tempStr = replace(tempStr, "\"", "&quot;");
		return tempStr.toString();
	}

	/**
	 * HTML解码
	 * 
	 * @param Str
	 * @return
	 */
	public static String unHTMLEncode(String Str) {
		StringBuffer tempStr = new StringBuffer(Str);
		tempStr = replace(tempStr, "&amp;", "&");
		tempStr = replace(tempStr, "&#36;", "$");
		tempStr = replace(tempStr, "&#64;", "@");
		tempStr = replace(tempStr, "&lt;", "<");
		tempStr = replace(tempStr, "&gt;", ">");
		tempStr = replace(tempStr, "&quot;", "\"");
		tempStr = replace(tempStr, "&nbsp;", " ");
		return tempStr.toString();
	}

	/**
	 * 获取A-Z字母 code[1..24]
	 * 
	 * @param code
	 * @return
	 */
	public static String getAZ(int code) {
		return getAZ(code, "");
	}

	public static String getAZ(int code, String defaultValue) {
		if (code > 0 && code < 25) {
			return "" + (char) (code + 64);
		} else {
			return defaultValue;
		}
	}

	/**
	 * 获取字符串
	 * 
	 * @param title
	 * @param len
	 * @param addString
	 *            切断时加的字符串
	 * @return
	 * @throws Exception
	 */
	public static String subString(String title, int len, String addString)
			throws Exception {
		try {
			if (addString.length() >= title.length()) {
				return title.substring(0, len);
			} else if (title.length() > len) {
				return title.substring(0, len - addString.length()) + addString;
			} else {
				return title;
			}
		} catch (Exception ex) {
			return title;
		}
	}

	/**
	 * 按中文发票标准输出金额表示
	 * 
	 * @param m
	 * @return
	 */
	public static String formatMoney(Number m) {
		double tempd = m.doubleValue() * 1000 + 5;
		Double tempD = new Double(tempd);
		if (tempD.longValue() < 10) {

			return "";
		} else {
			StringBuffer v = new StringBuffer();
			v.append(tempD.longValue());
			int len = v.length();
			String m1 = v.substring(0, len - 3) + "."
					+ v.substring(len - 3, len - 1);
			return MoneyUtil.toChinese(m1) + "整(￥" + m1 + ")";
		
		}

	}

	public static String removeHTML(String html) {
		return html.replaceAll("<.+?>", "");
	}
}
