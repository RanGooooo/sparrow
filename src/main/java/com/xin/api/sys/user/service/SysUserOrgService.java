package com.xin.api.sys.user.service;

import com.xin.sparrow.common.dto.RestResult;
import com.xin.api.sys.user.dto.SysUserOrgDto;

import javax.servlet.http.HttpServletRequest;

public interface SysUserOrgService {

    RestResult searchTSGroupList(HttpServletRequest request) throws Exception;

    void forwordTSGroupSave(HttpServletRequest request) throws Exception;

    RestResult groupSave(SysUserOrgDto dto) throws Exception;

    void groupDelete(HttpServletRequest request) throws Exception;

    RestResult searchTSGroupTree(HttpServletRequest request);
}
