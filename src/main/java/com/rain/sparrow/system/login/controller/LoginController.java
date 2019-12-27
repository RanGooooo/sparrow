package com.rain.sparrow.system.login.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("LoginController")
public class LoginController {

    private static final String loginPath = "system/login/";

    @RequestMapping("login")
    public String login(){
        return loginPath + "login";
    }


}
