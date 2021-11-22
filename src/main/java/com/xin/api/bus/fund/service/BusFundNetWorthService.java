package com.xin.api.bus.fund.service;

import com.xin.api.bus.fund.dto.BusSearchFundNetWorthReportVo;
import com.xin.sparrow.common.dto.DxResult;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.10.27 16:06
 */
public interface BusFundNetWorthService {

    /**
    * 作者:  zhaohongyu
    * 创建时间:  2021-11-22 13:56
    */
    DxResult<BusSearchFundNetWorthReportVo> searchFundNetWorthReport(String fundCode) throws Exception;
}
