package com.rain.sparrow.module.step.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("stepController")
public class StepController {


    @RequestMapping("list")
    public String list(){
        return "module/step/list";
    }
}
