package com.xin.api.bus.fund.controller;


import com.xin.api.bus.fund.dto.BusFundMainDto;
import com.xin.api.bus.fund.service.BusFundMainService;
import com.xin.sparrow.common.dto.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("busFundMainController")
public class BusFundMainController {

    private static final String fundPath = "bus/fund/";

    @Autowired
    private BusFundMainService tbFundMainService;


    @RequestMapping("searchTBFundMainList")
    public RestResult searchTBFundMainList(BusFundMainDto dto) {
        RestResult result = new RestResult();
        try {
            result = tbFundMainService.searchTBFundMainList(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }


    @RequestMapping("saveTBFundMain")
    public RestResult saveTBFundMain(BusFundMainDto dto) {
        RestResult result = new RestResult();
        try {
            result = tbFundMainService.fundSave(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("deleteTBFundMain")
    public RestResult deleteTBFundMain(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            tbFundMainService.fundDelete(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
