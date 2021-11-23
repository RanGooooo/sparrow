package com.xin.util;

import java.util.Calendar;
import java.util.Date;

/**
* 作者:  zhaohongyu
* 创建时间:  2021-11-23 11:09
*/
public class DxTimeUtil {

	/**
	* 作者:  zhaohongyu
	* 创建时间:  2021-11-23 11:09
	*/
	public static String subtractAppointDate(Integer dayNumber) throws Exception{
	    if(dayNumber==null){
	        return null;
        }
	    Date nowDate = new Date();
		Calendar calendar = Calendar.getInstance();  //得到日历
		calendar.setTime(nowDate);//把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, - dayNumber);  //设置为7天前
		Date newDate = calendar.getTime();   //得到7天前的时间
        return DxTimeThreadLocalUtil.formatDate(newDate);
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(subtractAppointDate(365));
	}
	
}
