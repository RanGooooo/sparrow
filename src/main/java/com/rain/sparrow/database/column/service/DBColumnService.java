package com.rain.sparrow.database.column.service;

import com.rain.sparrow.common.dto.RestResult;

import javax.servlet.http.HttpServletRequest;

public interface DBColumnService {


    RestResult searchTableList(HttpServletRequest request) throws Exception;


}
