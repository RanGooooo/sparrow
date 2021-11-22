package com.xin.sparrow.common.util;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.07.13 16:20
 */
public class DxStringUtil {


    public static final <T> T JSONPtoJSON(String value,Class<T> clazz) {
        if(StringUtils.isEmpty(value)){
            return null;
        }
        String substring = getJson(value);
        return JSON.parseObject(substring, clazz);
    }

    public static String getJson(String value){
        int start = value.indexOf("(");
        int end = value.lastIndexOf(")");
        return value.substring(start+1, end);
    }

}
