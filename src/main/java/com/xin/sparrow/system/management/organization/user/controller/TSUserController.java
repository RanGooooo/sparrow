package com.xin.sparrow.system.management.organization.user.controller;


import com.xin.sparrow.common.dto.RestResult;
import com.xin.sparrow.system.management.organization.user.dto.TSUserDto;
import com.xin.sparrow.system.management.organization.user.service.TSUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("TSUserController")
public class TSUserController {

    private static final String userPath = "system/management/organization/user/";

    @Autowired
    private TSUserService userService;

    @RequestMapping("forwordTSUserList")
    public String forwordTSUserList(){
        return userPath + "user-list";
    }


    @RequestMapping("searchTSUserList")
    @ResponseBody
    public RestResult searchTSUserList(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = userService.searchTSUserList(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("forwordTSUserSave")
    public String forwordTSUserSave(HttpServletRequest request){
        try {
            userService.forwordTSUserSave(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userPath + "user-save";
    }

    @RequestMapping("userSave")
    @ResponseBody
    public RestResult userSave(TSUserDto dto) {
        RestResult result = new RestResult();
        try {
            userService.userSave(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("userDelete")
    @ResponseBody
    public RestResult userDelete(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            userService.userDelete(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
