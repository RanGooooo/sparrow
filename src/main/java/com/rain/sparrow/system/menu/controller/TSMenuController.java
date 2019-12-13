package com.rain.sparrow.system.menu.controller;


import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.menu.service.TSMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("TSMenuController")
public class TSMenuController {

    @Autowired
    private TSMenuService tsMenuService;

    @RequestMapping("forwordMenuList")
    public String forwordMenuList(){
        return "system/menu/menu-list";
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


    @RequestMapping("forwordMenuEdit")
    public String forwordMenuAdd(HttpServletRequest request){
        try {
            tsMenuService.forwordMenuAdd(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "system/menu/menu-edit";
    }

    @RequestMapping("editMenu")
    @ResponseBody
    public RestResult editMenu(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            tsMenuService.editMenu(request);
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

    @RequestMapping("deleteMenu")
    @ResponseBody
    public RestResult deleteMenu(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            tsMenuService.deleteMenu(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }





}
