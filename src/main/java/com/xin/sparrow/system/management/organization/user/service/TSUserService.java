package com.xin.sparrow.system.management.organization.user.service;

import com.xin.sparrow.common.dto.RestResult;
import com.xin.sparrow.system.management.organization.user.dto.TSUserDto;

import javax.servlet.http.HttpServletRequest;

public interface TSUserService {

    RestResult searchTSUserList(HttpServletRequest request) throws Exception;

    void forwordTSUserSave(HttpServletRequest request) throws Exception;

    void userSave(TSUserDto dto) throws Exception;

    void userDelete(HttpServletRequest request) throws Exception;

}
