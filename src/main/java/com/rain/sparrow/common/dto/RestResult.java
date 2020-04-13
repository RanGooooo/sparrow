package com.rain.sparrow.common.dto;

import java.util.Map;

public class RestResult {

    public static final String MESSAGE_TYPE_SUCCESS = "success";

    public static final String MESSAGE_TYPE_WARNING = "warning";

    public static final String MESSAGE_TYPE_ERROR = "error";

    private String type = MESSAGE_TYPE_SUCCESS;

    private String message = "操作成功";

    private Map<Object,Object> map;

    private Object object;

    public RestResult() {
    }

    public RestResult(String type,String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<Object, Object> getMap() {
        return map;
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
