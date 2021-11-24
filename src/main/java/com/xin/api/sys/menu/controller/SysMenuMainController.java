package com.xin.api.sys.menu.controller;


import com.xin.api.sys.menu.entity.SysMenuMain;
import com.xin.sparrow.common.dto.DxResult;
import com.xin.sparrow.common.dto.RestResult;
import com.xin.sparrow.control.inter.annotation.Api;
import com.xin.sparrow.control.inter.annotation.ApiGroup;
import com.xin.api.sys.menu.dto.SysMenuMainDto;
import com.xin.api.sys.menu.service.SysMenuMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@ApiGroup(description  = "应用管理")
@RequestMapping("sysMenuMainController")
public class SysMenuMainController {

    private static final String menuPath = "system/management/menu/";

    @Autowired
    private SysMenuMainService menuService;

    @Api(description  = "搜索应用列表")
    @RequestMapping(value = "searchTSMenuNameList",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public RestResult searchTSMenuNameList(@RequestBody SysMenuMainDto dto) {
        RestResult result = new RestResult();
        try {
            result = menuService.searchTSMenuNameList(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @Api(description  = "搜索我的列表")
    @RequestMapping("searchMyTSMenuNameList")
    @ResponseBody
    public DxResult<List<SysMenuMain>> searchMyTSMenuNameList() {
        try {
            return menuService.searchMyTSMenuNameList(null);
        } catch (Exception e) {
            e.printStackTrace();
            return DxResult.warning(e);
        }
    }
    @Api(description  = "跳转保存页面")
    @RequestMapping("forwordTSMenuNameSave")
    public String forwordTSMenuNameSave(HttpServletRequest request){
        try {
            menuService.forwordTSMenuNameSave(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuPath + "menu-save";
    }
    @Api(description  = "应用保存")
    @RequestMapping("menuSave")
    @ResponseBody
    public RestResult menuSave(@RequestBody SysMenuMainDto dto) {
        RestResult result = new RestResult();
        try {
            result= menuService.menuSave(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    @Api(description  = "应用删除")
    @RequestMapping("menuDelete")
    @ResponseBody
    public RestResult menuDelete(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            menuService.menuDelete(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    @Api(description  = "搜索应用树")
    @RequestMapping("searchTSMenuNameTree")
    @ResponseBody
    public RestResult searchTSMenuNameTree(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = menuService.searchTSMenuNameTree(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
