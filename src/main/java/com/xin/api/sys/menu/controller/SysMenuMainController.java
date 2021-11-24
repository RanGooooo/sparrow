package com.xin.api.sys.menu.controller;


import com.xin.api.sys.menu.entity.SysMenuMain;
import com.xin.sparrow.common.dto.DxResult;
import com.xin.sparrow.common.dto.RestResult;
import com.xin.sparrow.control.inter.annotation.Api;
import com.xin.sparrow.control.inter.annotation.ApiGroup;
import com.xin.api.sys.menu.dto.TSApplicationDto;
import com.xin.api.sys.menu.service.TSApplicationService;
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

    private static final String applicationPath = "system/management/menu/";

    @Autowired
    private TSApplicationService applicationService;

    @Api(description  = "搜索应用列表")
    @RequestMapping(value = "searchTSApplicationList",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public RestResult searchTSApplicationList(@RequestBody TSApplicationDto dto) {
        RestResult result = new RestResult();
        try {
            result = applicationService.searchTSApplicationList(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @Api(description  = "搜索我的列表")
    @RequestMapping("searchMyTSApplicationList")
    @ResponseBody
    public DxResult<List<SysMenuMain>> searchMyTSApplicationList() {
        try {
            return applicationService.searchMyTSApplicationList(null);
        } catch (Exception e) {
            e.printStackTrace();
            return DxResult.warning(e);
        }
    }
    @Api(description  = "跳转保存页面")
    @RequestMapping("forwordTSApplicationSave")
    public String forwordTSApplicationSave(HttpServletRequest request){
        try {
            applicationService.forwordTSApplicationSave(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return applicationPath + "menu-save";
    }
    @Api(description  = "应用保存")
    @RequestMapping("applicationSave")
    @ResponseBody
    public RestResult applicationSave(@RequestBody TSApplicationDto dto) {
        RestResult result = new RestResult();
        try {
            result= applicationService.applicationSave(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    @Api(description  = "应用删除")
    @RequestMapping("applicationDelete")
    @ResponseBody
    public RestResult applicationDelete(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            applicationService.applicationDelete(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    @Api(description  = "搜索应用树")
    @RequestMapping("searchTSApplicationTree")
    @ResponseBody
    public RestResult searchTSApplicationTree(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = applicationService.searchTSApplicationTree(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
