package com.xin.sparrow.system.main.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("TSMainController")
public class TSMainController {




    @RequestMapping("index")
    public String index(){
        return "system/main/index";
    }

    @RequestMapping("main")
    public String main(){
        return "system/main/main";
    }


}
