package com.xin.sparrow.control.code.controller;


import com.xin.sparrow.common.dto.RestResult;
import com.xin.sparrow.control.code.dto.THCodeDto;
import com.xin.sparrow.control.code.service.THCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("THCodeController")
public class THCodeController {

    private static final String menuPath = "control/code/";

    @Autowired
    private THCodeService codeService;

    @RequestMapping("forwordCodeSave")
    public String forwordCodeSave(HttpServletRequest request){
        return menuPath + "code-save";
    }

    @RequestMapping("codeSave")
    @ResponseBody
    public RestResult codeSave(THCodeDto dto) {
        RestResult result = new RestResult();
        try {
            codeService.codeSave(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }


    @RequestMapping("searchColumnList")
    @ResponseBody
    public RestResult searchColumnList(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = codeService.searchColumnList(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("searchTableList")
    @ResponseBody
    public RestResult searchTableList(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = codeService.searchTableList(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }





}
