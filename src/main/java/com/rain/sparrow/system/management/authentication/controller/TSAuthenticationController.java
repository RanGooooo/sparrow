package com.rain.sparrow.system.management.authentication.controller;


import com.rain.sparrow.control.inter.annotation.Api;
import com.rain.sparrow.control.inter.annotation.ApiGroup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@ApiGroup(description  = "权限管理")
@RequestMapping("TSAuthenticationController")
public class TSAuthenticationController {

    private static final String authenticationPath = "system/management/authentication/";


    @Api(description  = "跳转保存页面")
    @RequestMapping("forwordTSAuthenticationSave")
    public String forwordTSAuthenticationSave(HttpServletRequest request){
        return authenticationPath + "authentication-save";
    }

}
