package com.rain.sparrow.system.management.organization.group.service;

import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.management.organization.group.dto.TSGroupDto;

import javax.servlet.http.HttpServletRequest;

public interface TSGroupService {

    RestResult searchTSGroupList(HttpServletRequest request) throws Exception;

    void forwordTSGroupSave(HttpServletRequest request) throws Exception;

    void groupSave(TSGroupDto dto) throws Exception;

    void groupDelete(HttpServletRequest request) throws Exception;

}
