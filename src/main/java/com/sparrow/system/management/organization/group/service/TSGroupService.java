package com.sparrow.system.management.organization.group.service;

import com.sparrow.common.dto.RestResult;
import com.sparrow.system.management.organization.group.dto.TSGroupDto;

import javax.servlet.http.HttpServletRequest;

public interface TSGroupService {

    RestResult searchTSGroupList(HttpServletRequest request) throws Exception;

    void forwordTSGroupSave(HttpServletRequest request) throws Exception;

    RestResult groupSave(TSGroupDto dto) throws Exception;

    void groupDelete(HttpServletRequest request) throws Exception;

    RestResult searchTSGroupTree(HttpServletRequest request);
}
