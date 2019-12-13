package com.rain.sparrow.system.bpmn;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("BPMNController")
public class BPMNController {

    @RequestMapping("index")
    public String index(){
        return "system/bpmn/add";
    }


}
