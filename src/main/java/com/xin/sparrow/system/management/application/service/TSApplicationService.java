package com.xin.sparrow.system.management.application.service;

import com.xin.sparrow.common.dto.DxResult;
import com.xin.sparrow.common.dto.RestResult;
import com.xin.sparrow.system.management.application.dto.TSApplicationDto;
import com.xin.sparrow.system.management.application.entity.TSApplication;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TSApplicationService {

    RestResult searchTSApplicationList(TSApplicationDto dto) throws Exception;

    void forwordTSApplicationSave(HttpServletRequest request) throws Exception;

    RestResult applicationSave(TSApplicationDto dto) throws Exception;

    void applicationDelete(HttpServletRequest request) throws Exception;

    DxResult<List<TSApplication>> searchMyTSApplicationList(TSApplicationDto dto) throws Exception;

    RestResult searchTSApplicationTree(HttpServletRequest request) throws Exception;
}
