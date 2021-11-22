package com.xin.sparrow.system.bpmn.controller;


import com.xin.sparrow.common.dto.RestResult;
import com.xin.sparrow.system.bpmn.dto.TSBpmnDto;
import com.xin.sparrow.system.bpmn.service.TSBpmnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("TSBpmnController")
public class TSBpmnController {

    private static final String bpmnPath = "system/bpmn/";

    @Autowired
    private TSBpmnService tsBpmnService;

    @RequestMapping("forwordBpmnList")
    public String forwordBpmnList(){
        try {
            // tsMenuService.forwordMenuAdd(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bpmnPath + "bpmn-list";
    }

    @RequestMapping("searchBpmnList")
    @ResponseBody
    public RestResult searchBpmnList(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = tsBpmnService.searchBpmnList(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }


    @RequestMapping("forwordBpmnSave")
    public String forwordBpmnEdit(){
        try {
           // tsMenuService.forwordMenuAdd(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bpmnPath + "bpmn-edit";
    }

    @RequestMapping("bpmnSave")
    @ResponseBody
    public RestResult bpmnSave(TSBpmnDto dto) {
        RestResult result = new RestResult();
        try {
            tsBpmnService.bpmnSave(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }


}
