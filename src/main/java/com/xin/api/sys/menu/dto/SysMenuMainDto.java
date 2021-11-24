package com.xin.api.sys.menu.dto;

import com.xin.api.sys.menu.entity.SysMenuMain;

public class SysMenuMainDto extends SysMenuMain {

    /**父应用id*/
    private String parentMenuName;


    public String getParentMenuName() {
        return parentMenuName;
    }

    public void setParentMenuName(String parentMenuName) {
        this.parentMenuName = parentMenuName;
    }
}
