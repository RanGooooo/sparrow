package com.rain.sparrow.control.inter.constant;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @Author RanGooooo
 * @date 2020.05.01 15:14
 */
public enum RequestMethodEnum {


    SEX_0(RequestMethod.GET.name(),"success"),
    SEX_1(RequestMethod.POST.name(),"info");

    //防止字段值被修改，增加的字段也统一final表示常量
    private final String code;
    private final String name;

    public static RequestMethodEnum getEnumByKey(String key){
        if(null == key){
            return null;
        }
        for(RequestMethodEnum temp:RequestMethodEnum.values()){
            if(temp.getCode().equals(key)){
                return temp;
            }
        }
        return null;
    }

    private RequestMethodEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
