package com.xin.sparrow.common.util;

/**
 * ---------------------------
 * 
 * ---------------------------
 * 开发人员: zhaohongyu
 * 时间: 2021年6月22日 下午2:07:10
 * 版本: v1.0
 * ---------------------------
 */
public class DxErrorMessageUtil {

	/**
	 * ---------------------
	 * 
	 * ---------------------
	 * @param message
	 * @param e
	 * @return String
	 * ---------------------------
	 * 开发人员: zhaohongyu
	 * 时间: 2021年6月22日 下午2:07:05
	 * 版本: v1.0
	 * ---------------------------
	 */
	public static String getErrorMessage(String message, Exception e) {
		if (DxSwitchUtil.exceptionMessageSwitch()) {
			return getExceptionAllinformation(e);
		}
		return message;
	}
	

	/**
	 * ---------------------
	 * 
	 * ---------------------
	 * @param ex
	 * @return String
	 * ---------------------------
	 * 开发人员: zhaohongyu
	 * 时间: 2021年6月22日 下午2:06:52
	 * 版本: v1.0
	 * ---------------------------
	 */
	public static String getExceptionAllinformation(Exception ex){
        StringBuffer message = new StringBuffer();
        message.append(ex.toString()).append("\r\n");
        StackTraceElement[] trace = ex.getStackTrace();
        for (StackTraceElement s : trace) {
        	message.append("\tat ").append(s).append("\r\n");
        }
        return message.toString();
 }
	
}
