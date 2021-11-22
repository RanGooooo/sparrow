package com.xin.sparrow.system.bpmn.service;

import com.xin.sparrow.common.dto.RestResult;
import com.xin.sparrow.system.bpmn.dto.TSBpmnDto;

import javax.servlet.http.HttpServletRequest;

public interface TSBpmnService {


    RestResult searchBpmnList(HttpServletRequest request);

    void bpmnSave(TSBpmnDto dto) throws Exception;
}
