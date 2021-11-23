package com.xin.api.sys.menu.dto;

import com.xin.api.sys.menu.entity.SysMenuMain;

public class TSApplicationDto extends SysMenuMain {

    /**父应用id*/
    private String parentApplicationName;


    public String getParentApplicationName() {
        return parentApplicationName;
    }

    public void setParentApplicationName(String parentApplicationName) {
        this.parentApplicationName = parentApplicationName;
    }
}
