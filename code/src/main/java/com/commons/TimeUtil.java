package com.commons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
	private static String[] timeDec = {"年","个月","天","小时","分钟","秒"};
	private static int[] timeNum = {1, 12, 1, 24, 60, 60};	
	private static int[][] months = {
		{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
		{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
	};
	public static String transTime(Date time) {		
		Calendar c = Calendar.getInstance();
		c.setTime(time);
		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH);
		int isRun = 0;
		if ( y%400 == 0 || (y%4 == 0 && y%100 != 0) ) {
			isRun = 1;
		}
		timeNum[2] = months[isRun][m];
		
		String prev = "前";
		String next = "后";
		boolean isPrev = true;
		long ctime = System.currentTimeMillis();
		if ( time.getTime() > ctime ) {
			isPrev = false;
		}
		long dtime = (Math.abs(time.getTime()-ctime) + 500)/1000;
		int idx = 5;
		while ( idx > 0 && dtime >= timeNum[idx] ) {
			dtime /= timeNum[idx];
			idx --;			
		}		
		if ( idx <= 0 ) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			return df.format(time);
		}
		if ( dtime == 1 ) {
			if ( isPrev )	return "昨天";
			else return "明天";
		}
		return dtime + timeDec[idx] + (isPrev ? prev : next);
	}
}
