package com.rain.sparrow.database.table.service;

import com.rain.sparrow.common.dto.RestResult;

import javax.servlet.http.HttpServletRequest;

public interface DBTableService {


    RestResult searchTableList(HttpServletRequest request);


}
