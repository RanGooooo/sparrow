package com.rain.sparrow.database.table.controller;


import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.database.table.service.DBTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("DBTableController")
public class DBTableController {


    @Autowired
    private DBTableService dbTableService;


    @RequestMapping("searchTableList")
    @ResponseBody
    public RestResult searchTableList(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = dbTableService.searchTableList(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }




}
