package com.rain.sparrow.module.step.controller;


import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.module.step.dto.StepDto;
import com.rain.sparrow.module.step.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("stepController")
public class StepController {

    @Autowired
    private StepService stepService;


    @RequestMapping("list")
    public String list(){
        return "common/demo_list";
    }



    @RequestMapping("searchListData")
    @ResponseBody
    public RestResult searchListData(){
        RestResult result = new RestResult();
        List<StepDto> list = stepService.searchListData();
        result.setObject(list);
        return result;
    }
}
