package com.sparrow.common.util;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.07.13 16:20
 */
public class StringUtil {


    public static final <T> T JSONPtoJSON(String value,Class<T> clazz) {
        if(StringUtils.isEmpty(value)){
            return null;
        }
        int start = value.indexOf("(");
        int end = value.lastIndexOf(")");
        String substring = value.substring(start+1, end);
        return JSON.parseObject(substring, clazz);
    }

}
