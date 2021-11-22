package com.xin.sparrow.common.util;

import org.springframework.beans.factory.annotation.Value;

/**
 * ---------------------------
 * 系统开关
 * ---------------------------
 * 开发人员: zhaohongyu
 * 时间: 2020年10月23日 下午7:12:02
 * 版本: v1.0
 * ---------------------------
 */
public class DxSwitchUtil {
	
	public final static String OPEN = "01";


    @Value("${sparrow.switch.EXCEPTION_MESSAGE_SWITCH_KEY}")
    private static String EXCEPTION_MESSAGE_SWITCH_KEY;

    /**
     * ---------------------
     * 异常信息是否发送前端 true 发送
     * ---------------------
     * @return boolean
     * ---------------------------
     * 开发人员: zhaohongyu
     * 时间: 2020年9月26日 上午11:09:28
     * 版本: v1.0
     * ---------------------------
     */
    public static boolean exceptionMessageSwitch(){
        if(OPEN.equals(EXCEPTION_MESSAGE_SWITCH_KEY)){
            return true;
        }
        return false;
    }

	
	
}
