package com.rain.sparrow.system.menu.service;

import com.rain.sparrow.common.dto.RestResult;

import javax.servlet.http.HttpServletRequest;

public interface TSMenuService {
    void menuAdd(HttpServletRequest request) throws Exception;

    RestResult searchMenuList(HttpServletRequest request) throws Exception;

    RestResult searchMenuTree(HttpServletRequest request) throws Exception;
}
