package com.rain.sparrow.system.menu.controller;


import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.menu.service.TSMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("TSMenuController")
public class TSMenuController {

    @Autowired
    private TSMenuService tsMenuService;

    @RequestMapping("forwordMenuList")
    public String forwordMenuList(){
        return "system/menu/menu-list";
    }

    @RequestMapping("forwordMenuAdd")
    public String forwordMenuAdd(){
        return "system/menu/menu-add";
    }

    @RequestMapping("menuAdd")
    @ResponseBody
    public RestResult menuAdd(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            tsMenuService.menuAdd(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }





}
