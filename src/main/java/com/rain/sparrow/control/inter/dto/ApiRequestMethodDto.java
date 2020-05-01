package com.rain.sparrow.control.inter.dto;

import com.rain.sparrow.control.inter.constant.RequestMethodEnum;

/**
 * @Description
 * @Author RanGooooo
 * @date 2020.05.01 14:27
 */
public class ApiRequestMethodDto {

    private String name;

    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        type = RequestMethodEnum.getEnumByKey(name).getName();
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
