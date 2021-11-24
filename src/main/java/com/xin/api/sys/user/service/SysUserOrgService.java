package com.xin.api.sys.user.service;

import com.xin.sparrow.common.dto.RestResult;
import com.xin.sparrow.system.management.organization.group.dto.TSGroupDto;

import javax.servlet.http.HttpServletRequest;

public interface SysUserOrgService {

    RestResult searchTSGroupList(HttpServletRequest request) throws Exception;

    void forwordTSGroupSave(HttpServletRequest request) throws Exception;

    RestResult groupSave(TSGroupDto dto) throws Exception;

    void groupDelete(HttpServletRequest request) throws Exception;

    RestResult searchTSGroupTree(HttpServletRequest request);
}
