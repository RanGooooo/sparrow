package com.rain.sparrow.develop.code.controller;


import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.develop.code.dto.THCodeDto;
import com.rain.sparrow.develop.code.service.THCodeService;
import com.rain.sparrow.system.menu.dto.TSMenuDto;
import com.rain.sparrow.system.menu.service.TSMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("THCodeController")
public class THCodeController {

    private static final String menuPath = "develop/code/";

    @Autowired
    private THCodeService codeService;

    @RequestMapping("forwordCodeSave")
    public String forwordCodeSave(HttpServletRequest request){
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }





}
