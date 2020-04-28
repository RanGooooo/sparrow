package com.rain.sparrow.system.management.application.controller;


import com.rain.sparrow.common.annotation.mvc.Api;
import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.management.application.dto.TSApplicationDto;
import com.rain.sparrow.system.management.application.service.TSApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@Api(name = "应用管理")
@RequestMapping("TSApplicationController")
public class TSApplicationController {

    private static final String applicationPath = "system/management/application/";

    @Autowired
    private TSApplicationService applicationService;

    @Api(name = "跳转应用列表")
    @RequestMapping("forwordTSApplicationList")
    public String forwordTSApplicationList(){
        return applicationPath + "application-list";
    }

    @Api(name = "搜索应用列表")
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
    @Api(name = "搜索我的列表")
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
    @Api(name = "跳转保存页面")
    @RequestMapping("forwordTSApplicationSave")
    public String forwordTSApplicationSave(HttpServletRequest request){
        try {
            applicationService.forwordTSApplicationSave(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return applicationPath + "application-save";
    }
    @Api(name = "应用保存")
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
    @Api(name = "应用删除")
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
    @Api(name = "搜索应用树")
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
