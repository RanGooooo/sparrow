package com.xin.sparrow.common.util;

import com.xin.sparrow.common.dto.RestResult;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.10.27 16:18
 */
public class RestResultUtil {


    public static RestResult error(String message){
        return new RestResult(RestResult.MESSAGE_TYPE_ERROR,message);
    }






}
