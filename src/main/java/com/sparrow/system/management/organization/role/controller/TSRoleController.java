package com.sparrow.system.management.organization.role.controller;


import com.sparrow.common.dto.RestResult;
import com.sparrow.system.management.organization.role.dto.TSRoleDto;
import com.sparrow.system.management.organization.role.service.TSRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("TSRoleController")
public class TSRoleController {

    private static final String rolePath = "system/role/";

    @Autowired
    private TSRoleService roleService;

    @RequestMapping("forwordTSRoleList")
    public String forwordTSRoleList(){
        return rolePath + "role-list";
    }

    @RequestMapping("searchTSRoleList")
    @ResponseBody
    public RestResult searchTSRoleList(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = roleService.searchTSRoleList(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("forwordTSRoleSave")
    public String forwordTSRoleSave(HttpServletRequest request){
        try {
            roleService.forwordTSRoleSave(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rolePath + "role-save";
    }

    @RequestMapping("roleSave")
    @ResponseBody
    public RestResult roleSave(TSRoleDto dto) {
        RestResult result = new RestResult();
        try {
            roleService.roleSave(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("roleDelete")
    @ResponseBody
    public RestResult roleDelete(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            roleService.roleDelete(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
