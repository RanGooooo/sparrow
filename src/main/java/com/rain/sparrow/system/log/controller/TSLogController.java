package com.rain.sparrow.system.log.controller;


import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.log.dto.TSLogDto;
import com.rain.sparrow.system.log.service.TSLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("TSLogController")
public class TSLogController {

    private static final String logPath = "system/log/";

    @Autowired
    private TSLogService logService;

    @RequestMapping("forwordTSLogList")
    public String forwordTSLogList(){
        return logPath + "log-list";
    }

    @RequestMapping("searchTSLogList")
    @ResponseBody
    public RestResult searchTSLogList(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = logService.searchTSLogList(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("forwordTSLogSave")
    public String forwordTSLogSave(HttpServletRequest request){
        try {
            logService.forwordTSLogSave(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logPath + "log-save";
    }

    @RequestMapping("logSave")
    @ResponseBody
    public RestResult logSave(TSLogDto dto) {
        RestResult result = new RestResult();
        try {
            logService.logSave(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("logDelete")
    @ResponseBody
    public RestResult logDelete(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            logService.logDelete(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
