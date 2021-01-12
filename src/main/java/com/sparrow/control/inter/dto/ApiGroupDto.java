package com.sparrow.control.inter.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author RanGooooo
 * @date 2020.04.29 21:23
 */
public class ApiGroupDto {
    private String description;

    private String mapping;

    private List<ApiDto> apiList = new ArrayList<>();

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

    public List<ApiDto> getApiList() {
        return apiList;
    }

    public void setApiList(List<ApiDto> apiList) {
        this.apiList = apiList;
    }

    public void addApi(ApiDto api){
        apiList.add(api);
    }
}
