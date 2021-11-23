package com.xin.api.sys.menu.service;

import com.xin.sparrow.common.dto.DxResult;
import com.xin.sparrow.common.dto.RestResult;
import com.xin.api.sys.menu.dto.TSApplicationDto;
import com.xin.api.sys.menu.entity.SysMenuMain;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TSApplicationService {

    RestResult searchTSApplicationList(TSApplicationDto dto) throws Exception;

    void forwordTSApplicationSave(HttpServletRequest request) throws Exception;

    RestResult applicationSave(TSApplicationDto dto) throws Exception;

    void applicationDelete(HttpServletRequest request) throws Exception;

    DxResult<List<SysMenuMain>> searchMyTSApplicationList(TSApplicationDto dto) throws Exception;

    RestResult searchTSApplicationTree(HttpServletRequest request) throws Exception;
}
