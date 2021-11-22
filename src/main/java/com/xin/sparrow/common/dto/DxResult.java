package com.xin.sparrow.common.dto;

import com.xin.sparrow.common.exception.ExceptionMessageException;
import com.xin.sparrow.common.util.DxErrorMessageUtil;

public class DxResult<T> {

    public static final String MESSAGE_SUCCESS = "操作成功";

    public static final String MESSAGE_WARNING = "操作失败";

    public static final String MESSAGE_ERROR = "系统异常";

    public static final String MESSAGE_TYPE_SUCCESS = "success";

    public static final String MESSAGE_TYPE_WARNING = "warning";

    public static final String MESSAGE_TYPE_ERROR = "error";

    private String type = MESSAGE_TYPE_SUCCESS;

    private String message = MESSAGE_SUCCESS;

    private T data;



    public static <T> DxResult<T> success(T t) {
        return success(MESSAGE_SUCCESS,t);
    }

    public static <T> DxResult<T> success(String message,T t) {
        return new DxResult(DxResult.MESSAGE_TYPE_SUCCESS,message,t);
    }

    public static <T> DxResult<T> warning(Exception e) {
        return warning(MESSAGE_WARNING,e);
    }

    public static <T> DxResult<T> warning(String message,Exception e) {
        e.printStackTrace();
        if (e instanceof ExceptionMessageException) {
            return new DxResult(DxResult.MESSAGE_TYPE_WARNING,e.getMessage());
        }
        return new DxResult(DxResult.MESSAGE_TYPE_WARNING,DxErrorMessageUtil.getErrorMessage(message, e));
    }


    public DxResult() {
    }

    public DxResult(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public DxResult(T data) {
        this.data = data;
    }

    public DxResult(String type, String message, T data) {
        this.type = type;
        this.message = message;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
