package com.xin.sparrow.control.inter.dto;

/**
 * @Description
 * @Author RanGooooo
 * @date 2020.05.01 00:56
 */
public class ApiParameterDto {

    private String key;

    private String value;

    private String description;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
