package com.xin.api.bus.fund.service;

import com.xin.api.bus.fund.dto.BusSearchFundNetWorthReportVo;
import com.xin.sparrow.common.dto.DxResult;
import com.xin.sparrow.common.dto.RestResult;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.10.27 16:06
 */
public interface BusFundNetWorthService {


    RestResult pullFundNetWorthRecord(String fundCode);

    DxResult<BusSearchFundNetWorthReportVo> searchFundNetWorthReport(String fundCode) throws Exception;
}
