package com.rain.sparrow.system.conf.application.service;

import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.conf.application.dto.TSApplicationDto;

import javax.servlet.http.HttpServletRequest;

public interface TSApplicationService {

    RestResult searchTSApplicationList(HttpServletRequest request) throws Exception;

    void forwordTSApplicationSave(HttpServletRequest request) throws Exception;

    void applicationSave(TSApplicationDto dto) throws Exception;

    void applicationDelete(HttpServletRequest request) throws Exception;

}