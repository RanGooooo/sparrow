package com.rain.sparrow.system.conf.application.controller;


import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.conf.application.dto.TSApplicationDto;
import com.rain.sparrow.system.conf.application.service.TSApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("TSApplicationController")
public class TSApplicationController {

    private static final String applicationPath = "system/conf/application/";

    @Autowired
    private TSApplicationService applicationService;

    @RequestMapping("forwordTSApplicationList")
    public String forwordTSApplicationList(){
        return applicationPath + "application-list";
    }

    @RequestMapping("searchTSApplicationList")
    @ResponseBody
    public RestResult searchTSApplicationList(TSApplicationDto dto) {
        RestResult result = new RestResult();
        try {
            result = applicationService.searchTSApplicationList(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("searchMyTSApplicationList")
    @ResponseBody
    public RestResult searchMyTSApplicationList(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = applicationService.searchMyTSApplicationList(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("forwordTSApplicationSave")
    public String forwordTSApplicationSave(HttpServletRequest request){
        try {
            applicationService.forwordTSApplicationSave(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return applicationPath + "application-save";
    }

    @RequestMapping("applicationSave")
    @ResponseBody
    public RestResult applicationSave(TSApplicationDto dto) {
        RestResult result = new RestResult();
        try {
            result= applicationService.applicationSave(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("applicationDelete")
    @ResponseBody
    public RestResult applicationDelete(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            applicationService.applicationDelete(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("searchTSApplicationTree")
    @ResponseBody
    public RestResult searchTSApplicationTree(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = applicationService.searchTSApplicationTree(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
