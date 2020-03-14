package com.rain.sparrow.system.configure.service;

import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.configure.dto.TSConfigureDto;

import javax.servlet.http.HttpServletRequest;

public interface TSConfigureService {

    RestResult searchTSConfigureList(HttpServletRequest request) throws Exception;

    void forwordTSConfigureSave(HttpServletRequest request) throws Exception;

    void configureSave(TSConfigureDto dto) throws Exception;

    void configureDelete(HttpServletRequest request) throws Exception;

}
