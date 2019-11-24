package com.rain.sparrow.system.index;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("indexController")
public class IndexController {

    @RequestMapping("index")
    public String index(){
        return "system/index";
    }


}
