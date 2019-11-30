package com.rain.sparrow.system.menu.controller;


import com.rain.sparrow.system.menu.service.TSMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("TSMenuController")
public class TSMenuController {


    @Autowired
    private TSMenuService tsMenuService;


    @RequestMapping("forwordMenuList")
    public String list(){
        return "system/menu/menu-list";
    }



}
