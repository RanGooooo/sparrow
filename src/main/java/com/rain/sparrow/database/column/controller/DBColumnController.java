package com.rain.sparrow.database.column.controller;


import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.database.column.service.DBColumnService;
import com.rain.sparrow.database.table.service.DBTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("DBColumnController")
public class DBColumnController {


    @Autowired
    private DBColumnService dbColumnService;


    @RequestMapping("searchColumnList")
    @ResponseBody
    public RestResult searchColumnList(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = dbColumnService.searchTableList(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }




}
