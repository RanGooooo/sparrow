package com.xin.api.bus.fund.controller;


import com.xin.api.bus.fund.dto.BusSearchFundNetWorthReportDto;
import com.xin.api.bus.fund.dto.BusSearchFundNetWorthReportVo;
import com.xin.api.bus.fund.service.BusFundNetWorthService;
import com.xin.sparrow.common.dto.DxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 作者:  zhaohongyu
* 创建时间:  2021-11-22 13:54
*/
@RestController
@RequestMapping("busFundNetWorthController")
public class BusFundNetWorthController {


    @Autowired
    private BusFundNetWorthService tbFundNetWorthRecordService;

    /**
    * 作者:  zhaohongyu
    * 创建时间:  2021-11-19 14:30
    */
    @RequestMapping("searchFundNetWorthReport")
    public DxResult<BusSearchFundNetWorthReportVo> searchFundNetWorthReport(@RequestBody BusSearchFundNetWorthReportDto dto) {
        try {
            return tbFundNetWorthRecordService.searchFundNetWorthReport(dto.getFundCode());
        } catch (Exception e) {
            return DxResult.warning(e);
        }
    }



}
