package com.rain.sparrow.system.management.organization.role.service;

import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.management.organization.role.dto.TSRoleDto;

import javax.servlet.http.HttpServletRequest;

public interface TSRoleService {

    RestResult searchTSRoleList(HttpServletRequest request) throws Exception;

    void forwordTSRoleSave(HttpServletRequest request) throws Exception;

    void roleSave(TSRoleDto dto) throws Exception;

    void roleDelete(HttpServletRequest request) throws Exception;

}
