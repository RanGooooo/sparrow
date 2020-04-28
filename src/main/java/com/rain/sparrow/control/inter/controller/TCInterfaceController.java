package com.rain.sparrow.control.inter.controller;


import com.rain.sparrow.common.annotation.mvc.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(name = "接口管理")
@RequestMapping("TCInterfaceController")
public class TCInterfaceController {

    private static final String TCInterface_PATH = "control/inter/";

    @Api(name = "跳转接口管理")
    @RequestMapping("forwordManagementInterface")
    public String forwordManagementInterface(){
        return TCInterface_PATH + "management-interface";
    }


}
