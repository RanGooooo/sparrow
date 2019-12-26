package com.rain.sparrow.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	
	static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
	
	static SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String formatDate(Date date){
		if(date==null) {
			return "";
		}
		return formatDate.format(date);
	}
	
	public static String formatTime(Date date){
		if(date==null) {
			return "";
		}
		return formatTime.format(date);
	}
}
