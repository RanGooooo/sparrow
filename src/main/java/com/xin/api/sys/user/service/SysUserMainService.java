package com.xin.api.sys.user.service;

import com.xin.sparrow.common.dto.RestResult;
import com.xin.api.sys.user.dto.SysUserMainDto;

import javax.servlet.http.HttpServletRequest;

public interface SysUserMainService {

    RestResult searchTSUserList(HttpServletRequest request) throws Exception;

    void forwordTSUserSave(HttpServletRequest request) throws Exception;

    void userSave(SysUserMainDto dto) throws Exception;

    void userDelete(HttpServletRequest request) throws Exception;

}
