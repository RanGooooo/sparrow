package com.rain.sparrow.system.menu.service;

import com.rain.sparrow.common.dto.RestResult;

import javax.servlet.http.HttpServletRequest;

public interface TSMenuService {
    void editMenu(HttpServletRequest request) throws Exception;

    RestResult searchMenuList(HttpServletRequest request) throws Exception;

    RestResult searchMenuTree(HttpServletRequest request) throws Exception;

    void forwordMenuAdd(HttpServletRequest request) throws Exception;

    void deleteMenu(HttpServletRequest request) throws Exception;
}
