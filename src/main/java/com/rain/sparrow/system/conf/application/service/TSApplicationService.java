package com.rain.sparrow.system.conf.application.service;

import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.conf.application.dto.TSApplicationDto;

import javax.servlet.http.HttpServletRequest;

public interface TSApplicationService {

    RestResult searchTSApplicationList(TSApplicationDto dto) throws Exception;

    void forwordTSApplicationSave(HttpServletRequest request) throws Exception;

    RestResult applicationSave(TSApplicationDto dto) throws Exception;

    void applicationDelete(HttpServletRequest request) throws Exception;

    RestResult searchMyTSApplicationList(HttpServletRequest request) throws Exception;

    RestResult searchTSApplicationTree(HttpServletRequest request) throws Exception;
}
