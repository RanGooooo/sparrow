package com.rain.sparrow.system.login;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("loginController")
public class LoginController {

    @RequestMapping("login")
    public String login(){
        return "system/login";
    }


}
