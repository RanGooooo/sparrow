package com.xin.api.bus.fund.controller;


import com.xin.api.bus.fund.dto.BusSearchFundNetWorthReportDto;
import com.xin.api.bus.fund.dto.BusSearchFundNetWorthReportVo;
import com.xin.api.bus.fund.dto.PullFundNetWorthRecordDto;
import com.xin.api.bus.fund.service.BusFundNetWorthService;
import com.xin.sparrow.common.dto.DxResult;
import com.xin.sparrow.common.dto.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("busFundNetWorthController")
public class BusFundNetWorthController {

    private static final String fundPath = "business/fund/";

    @Autowired
    private BusFundNetWorthService tbFundNetWorthRecordService;


    @ResponseBody
    @RequestMapping("pullFundNetWorthRecord")
    public RestResult pullFundNetWorthRecord(PullFundNetWorthRecordDto dto) {
        RestResult result = new RestResult();
        try {
            result = tbFundNetWorthRecordService.pullFundNetWorthRecord(dto.getFundCode());
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    /**
    * 作者:  zhaohongyu
    * 创建时间:  2021-11-19 14:30
    */
    @ResponseBody
    @RequestMapping("searchFundNetWorthReport")
    public DxResult<BusSearchFundNetWorthReportVo> searchFundNetWorthReport(@RequestBody BusSearchFundNetWorthReportDto dto) {
        try {
            return tbFundNetWorthRecordService.searchFundNetWorthReport(dto.getFundCode());
        } catch (Exception e) {
            return DxResult.warning(e);
        }
    }



}
