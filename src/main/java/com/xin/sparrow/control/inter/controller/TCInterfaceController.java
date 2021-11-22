package com.xin.sparrow.control.inter.controller;


import com.xin.sparrow.control.inter.annotation.Api;
import com.xin.sparrow.control.inter.annotation.ApiGroup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ApiGroup(description  = "接口管理")
@RequestMapping("TCInterfaceController")
public class TCInterfaceController {

    private static final String TCInterface_PATH = "control/inter/";

    @Api(description  = "跳转接口管理")
    @RequestMapping(value = "forwordManagementInterface",method = RequestMethod.GET)
    public String forwordManagementInterface(){
        return TCInterface_PATH + "management-interface";
    }


}
