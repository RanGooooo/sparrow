package com.rain.sparrow.system.bpmn.service;

import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.bpmn.dto.TSBpmnDto;

import javax.servlet.http.HttpServletRequest;

public interface TSBpmnService {


    RestResult searchBpmnList(HttpServletRequest request);

    void bpmnSave(TSBpmnDto dto) throws Exception;
}
