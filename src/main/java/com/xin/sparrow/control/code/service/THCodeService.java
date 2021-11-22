package com.xin.sparrow.control.code.service;

import com.xin.sparrow.common.dto.RestResult;
import com.xin.sparrow.control.code.dto.THCodeDto;

import javax.servlet.http.HttpServletRequest;

public interface THCodeService {

    void codeSave(THCodeDto dto) throws Exception;

    RestResult searchColumnList(HttpServletRequest request) throws Exception;

    RestResult searchTableList(HttpServletRequest request);

}
