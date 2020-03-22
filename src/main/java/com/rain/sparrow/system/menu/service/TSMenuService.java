package com.rain.sparrow.system.menu.service;

import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.menu.dto.TSMenuDto;

import javax.servlet.http.HttpServletRequest;

public interface TSMenuService {
    void menuSave(TSMenuDto dto) throws Exception;

    RestResult searchTSMenuList(HttpServletRequest request) throws Exception;

    RestResult searchTSMenuTree(HttpServletRequest request) throws Exception;

    void forwordTSMenuSave(HttpServletRequest request) throws Exception;

    void menuDelete(HttpServletRequest request) throws Exception;
}
