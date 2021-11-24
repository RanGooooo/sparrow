package com.xin.api.sys.user.service;

import com.xin.sparrow.common.dto.RestResult;
import com.xin.api.sys.user.dto.SysUserRoleDto;

import javax.servlet.http.HttpServletRequest;

public interface SysUserRoleService {

    RestResult searchTSRoleList(HttpServletRequest request) throws Exception;

    void forwordTSRoleSave(HttpServletRequest request) throws Exception;

    void roleSave(SysUserRoleDto dto) throws Exception;

    void roleDelete(HttpServletRequest request) throws Exception;

}
