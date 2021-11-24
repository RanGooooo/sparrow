package com.xin.api.sys.menu.service;

import com.xin.sparrow.common.dto.DxResult;
import com.xin.sparrow.common.dto.RestResult;
import com.xin.api.sys.menu.dto.SysMenuMainDto;
import com.xin.api.sys.menu.entity.SysMenuMain;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SysMenuMainService {

    RestResult searchTSMenuNameList(SysMenuMainDto dto) throws Exception;

    void forwordTSMenuNameSave(HttpServletRequest request) throws Exception;

    RestResult menuSave(SysMenuMainDto dto) throws Exception;

    void menuDelete(HttpServletRequest request) throws Exception;

    DxResult<List<SysMenuMain>> searchMyTSMenuNameList(SysMenuMainDto dto) throws Exception;

    RestResult searchTSMenuNameTree(HttpServletRequest request) throws Exception;
}
