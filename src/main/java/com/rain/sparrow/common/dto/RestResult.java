package com.rain.sparrow.common.dto;

import java.util.Map;

public class RestResult {

    public static final String errorMessage = "系统异常";

    public static final String errorCode = "500";

    private String message = "操作成功";

    private boolean success = true;

    private Map<Object,Object> map;

    private Object object;

    public RestResult() {
    }

    public RestResult(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<Object, Object> getMap() {
        return map;
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }
}
