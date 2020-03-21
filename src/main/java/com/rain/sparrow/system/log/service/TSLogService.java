package com.rain.sparrow.system.log.service;

import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.log.dto.TSLogDto;

import javax.servlet.http.HttpServletRequest;

public interface TSLogService {

    RestResult searchTSLogList(HttpServletRequest request) throws Exception;

    void forwordTSLogSave(HttpServletRequest request) throws Exception;

    void logSave(TSLogDto dto) throws Exception;

    void logDelete(HttpServletRequest request) throws Exception;

}
