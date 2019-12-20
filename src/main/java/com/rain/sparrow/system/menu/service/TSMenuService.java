package com.rain.sparrow.system.menu.service;

import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.menu.dto.TSMenuDto;

import javax.servlet.http.HttpServletRequest;

public interface TSMenuService {
    void menuSave(TSMenuDto dto) throws Exception;

    RestResult searchMenuList(HttpServletRequest request) throws Exception;

    RestResult searchMenuTree(HttpServletRequest request) throws Exception;

    void forwordMenuSave(HttpServletRequest request) throws Exception;

    void menuDelete(HttpServletRequest request) throws Exception;
}
