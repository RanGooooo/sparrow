package com.rain.sparrow.control.inter.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author RanGooooo
 * @date 2020.04.29 21:23
 */
public class ApiDto {

    private String description;/*api描述*/

    private String mapping;/*路径映射*/

    private List<ApiRequestMethodDto> requestMethodList = new ArrayList<>();/*请求方式*/

    private List<ApiParameterDto> parameterList = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public List<ApiRequestMethodDto> getRequestMethodList() {
        return requestMethodList;
    }

    public void setRequestMethodList(List<ApiRequestMethodDto> requestMethodList) {
        this.requestMethodList = requestMethodList;
    }

    public List<ApiParameterDto> getParameterList() {
        return parameterList;
    }

    public void setParameterList(List<ApiParameterDto> parameterList) {
        this.parameterList = parameterList;
    }

    public void addRequestMethod(ApiRequestMethodDto requestMethod){
        requestMethodList.add(requestMethod);
    }

    public void addParameter(ApiParameterDto parameter){
        parameterList.add(parameter);
    }
}
