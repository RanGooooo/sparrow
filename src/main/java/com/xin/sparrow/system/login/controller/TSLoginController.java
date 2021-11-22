package com.xin.sparrow.system.login.controller;


import com.xin.sparrow.common.dto.RestResult;
import com.xin.sparrow.system.login.dto.LoginUserDto;
import com.xin.sparrow.system.login.service.TSLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("TSLoginController")
public class TSLoginController {

    private static final String loginPath = "system/login/";

    @Autowired
    private TSLoginService tsLoginService;

    @RequestMapping("login")
    public String login(){

        return loginPath + "login";
    }

    @RequestMapping(value="validate")
    @ResponseBody
    public RestResult validate(LoginUserDto userDto, RedirectAttributes attr){
        RestResult result = new RestResult();
        try {
            tsLoginService.validate(userDto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }


}
