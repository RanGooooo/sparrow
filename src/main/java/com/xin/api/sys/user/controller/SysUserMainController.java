package com.xin.api.sys.user.controller;


import com.xin.sparrow.common.dto.RestResult;
import com.xin.api.sys.user.dto.SysUserMainDto;
import com.xin.api.sys.user.service.SysUserMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("TSUserController")
public class SysUserMainController {


    @Autowired
    private SysUserMainService userService;

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
        return  "user-save";
    }

    @RequestMapping("userSave")
    @ResponseBody
    public RestResult userSave(SysUserMainDto dto) {
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
