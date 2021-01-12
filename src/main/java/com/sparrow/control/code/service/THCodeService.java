package com.sparrow.control.code.service;

import com.sparrow.common.dto.RestResult;
import com.sparrow.control.code.dto.THCodeDto;

import javax.servlet.http.HttpServletRequest;

public interface THCodeService {

    void codeSave(THCodeDto dto) throws Exception;

    RestResult searchColumnList(HttpServletRequest request) throws Exception;

    RestResult searchTableList(HttpServletRequest request);

}
