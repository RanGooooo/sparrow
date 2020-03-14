package com.rain.sparrow.system.configure.controller;


import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.configure.dto.TSConfigureDto;
import com.rain.sparrow.system.configure.service.TSConfigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("TSConfigureController")
public class TSConfigureController {

    private static final String configurePath = "system/configure/";

    @Autowired
    private TSConfigureService configureService;

    @RequestMapping("forwordTSConfigureList")
    public String forwordTSConfigureList(){
        return configurePath + "configure-list";
    }

    @RequestMapping("searchTSConfigureList")
    @ResponseBody
    public RestResult searchTSConfigureList(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = configureService.searchTSConfigureList(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("forwordTSConfigureSave")
    public String forwordTSConfigureSave(HttpServletRequest request){
        try {
            configureService.forwordTSConfigureSave(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return configurePath + "configure-save";
    }

    @RequestMapping("configureSave")
    @ResponseBody
    public RestResult configureSave(TSConfigureDto dto) {
        RestResult result = new RestResult();
        try {
            configureService.configureSave(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("configureDelete")
    @ResponseBody
    public RestResult configureDelete(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            configureService.configureDelete(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
