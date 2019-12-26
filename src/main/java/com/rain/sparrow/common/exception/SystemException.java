package com.rain.sparrow.common.exception;

import com.rain.sparrow.common.util.DateFormatUtil;

import java.util.Date;

/**
 * 111111111111111111111111▄11
 * 111111111▐█11111111111▄▀0▌1
 * 11111111▐▀0█11111111▄▀000▐
 * 1111111▐▄▀00▀▀▀▀▄▄▄▀00000▐
 * 11111▄▄▀01000000000█00▄█0▐
 * 111▄▀000111000111000▀██▀0▌
 * 11▐000▄▄00001110000000▀▄00
 * 11▌11▌█▀00000▄▀█▄0000000█0▐
 * 1▐11100000000▌██▀00111000▀▄
 * 1▌10▄██▄0000000001111110000
 * ▀0▀▐▄█▄█▌▄1▀001111111111000
 *
 * @author 赵宏宇
 */
public class SystemException extends Exception{

    /**错误代码*/
    private int code;
    /**前端展示信息*/
    private String viewMessage;
    /**日志打印信息*/
    private String loggerMessage;

    public SystemException(int code,String viewMessage,String loggerMessage) {
        super(viewMessage);
        this.code = code;
        this.viewMessage = viewMessage;
        this.loggerMessage = "["+DateFormatUtil.formatTime(new Date())+"]" + loggerMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getViewMessage() {
        return viewMessage;
    }

    public void setViewMessage(String viewMessage) {
        this.viewMessage = viewMessage;
    }

    public String getLoggerMessage() {
        return loggerMessage;
    }

    public void setLoggerMessage(String loggerMessage) {
        this.loggerMessage = loggerMessage;
    }
}
