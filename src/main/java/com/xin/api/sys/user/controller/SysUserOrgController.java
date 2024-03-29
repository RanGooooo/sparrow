package com.xin.api.sys.user.controller;


import com.xin.sparrow.common.dto.RestResult;
import com.xin.api.sys.user.dto.SysUserOrgDto;
import com.xin.api.sys.user.service.SysUserOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("TSGroupController")
public class SysUserOrgController {

    private static final String groupPath = "system/group/";

    @Autowired
    private SysUserOrgService groupService;

    @RequestMapping("forwordTSGroupList")
    public String forwordTSGroupList(){
        return groupPath + "group-list";
    }

    @RequestMapping("searchTSGroupList")
    @ResponseBody
    public RestResult searchTSGroupList(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = groupService.searchTSGroupList(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("searchTSGroupTree")
    @ResponseBody
    public RestResult searchTSGroupTree(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = groupService.searchTSGroupTree(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }




    @RequestMapping("forwordTSGroupSave")
    public String forwordTSGroupSave(HttpServletRequest request){
        try {
            groupService.forwordTSGroupSave(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groupPath + "group-save";
    }

    @RequestMapping("groupSave")
    @ResponseBody
    public RestResult groupSave(SysUserOrgDto dto) {
        RestResult result = new RestResult();
        try {
            result = groupService.groupSave(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("groupDelete")
    @ResponseBody
    public RestResult groupDelete(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            groupService.groupDelete(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
