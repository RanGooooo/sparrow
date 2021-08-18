package com.sparrow.business.fund.controller;


import com.sparrow.business.fund.dto.TBFundDto;
import com.sparrow.business.fund.service.TBFundService;
import com.sparrow.common.dto.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("TBFundController")
public class TBFundController {

    private static final String fundPath = "business/fund/";

    @Autowired
    private TBFundService fundService;

    @RequestMapping("forwordTBFundList")
    public String forwordTBFundList(){
        return fundPath + "fund_list";
    }

    @RequestMapping("searchTBFundList")
    @ResponseBody
    public RestResult searchTBFundList(TBFundDto dto) {
        RestResult result = new RestResult();
        try {
            result = fundService.searchTBFundList(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("forwordTBFundSave")
    public String forwordTBFundSave(HttpServletRequest request){
        try {
            fundService.forwordTBFundSave(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fundPath + "fund_save";
    }

    @RequestMapping("fundSave")
    @ResponseBody
    public RestResult fundSave(TBFundDto dto) {
        RestResult result = new RestResult();
        try {
            result = fundService.fundSave(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("fundDelete")
    @ResponseBody
    public RestResult fundDelete(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            fundService.fundDelete(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
