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


    @RequestMapping("forwordTSMenuList")
    public String forwordTSMenuList(){
        return menuPath + "menu-list";
    }

    @RequestMapping("searchTSMenuList")
    @ResponseBody
    public RestResult searchTSMenuList(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = tsMenuService.searchTSMenuList(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("searchMyTSMenuList")
    @ResponseBody
    public RestResult searchMyTSMenuList(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = tsMenuService.searchMyTSMenuList(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }


    @RequestMapping("forwordTSMenuSave")
    public String forwordTSMenuSave(HttpServletRequest request){
        try {
            tsMenuService.forwordTSMenuSave(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuPath + "menu-save";
    }


    @RequestMapping("menuSave")
    @ResponseBody
    public RestResult menuSave(TSMenuDto dto) {
        RestResult result = new RestResult();
        try {
            tsMenuService.menuSave(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }


    @RequestMapping("forwordTSMenuTree")
    public String forwordMenuTree(){
        return "system/menu/menu-tree";
    }

    @RequestMapping("searchTSMenuTree")
    @ResponseBody
    public RestResult searchMenuTree(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = tsMenuService.searchTSMenuTree(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
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
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }


}
