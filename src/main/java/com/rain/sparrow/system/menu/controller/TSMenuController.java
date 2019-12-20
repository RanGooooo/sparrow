package com.rain.sparrow.system.menu.controller;


import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.menu.dto.TSMenuDto;
import com.rain.sparrow.system.menu.service.TSMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("TSMenuController")
public class TSMenuController {

    private static final String menuPath = "system/menu/";

    @Autowired
    private TSMenuService tsMenuService;


    @RequestMapping("forwordMenuList")
    public String forwordMenuList(){
        return menuPath + "menu-list";
    }

    @RequestMapping("searchMenuList")
    @ResponseBody
    public RestResult searchMenuList(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = tsMenuService.searchMenuList(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }


    @RequestMapping("forwordMenuSave")
    public String forwordMenuAdd(HttpServletRequest request){
        try {
            tsMenuService.forwordMenuSave(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "system/menu/menu-save";
    }


    @RequestMapping("menuSave")
    @ResponseBody
    public RestResult menuSave(TSMenuDto dto) {
        RestResult result = new RestResult();
        try {
            tsMenuService.menuSave(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }


    @RequestMapping("forwordMenuTree")
    public String forwordMenuTree(){
        return "system/menu/menu-tree";
    }

    @RequestMapping("searchMenuTree")
    @ResponseBody
    public RestResult searchMenuTree(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = tsMenuService.searchMenuTree(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("menuDelete")
    @ResponseBody
    public RestResult menuDelete(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            tsMenuService.menuDelete(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }





}
