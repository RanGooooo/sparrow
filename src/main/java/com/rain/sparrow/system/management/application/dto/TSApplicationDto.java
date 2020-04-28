package com.rain.sparrow.system.management.application.dto;

import com.rain.sparrow.system.management.application.entity.TSApplication;

public class TSApplicationDto extends TSApplication{

    /**父应用id*/
    private String parentApplicationName;

    public String getParentApplicationName() {
        return parentApplicationName;
    }

    public void setParentApplicationName(String parentApplicationName) {
        this.parentApplicationName = parentApplicationName;
    }
}
