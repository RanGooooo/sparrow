package com.xin.api.bus.fund.dto;

import com.xin.api.bus.fund.dto.echarts.Option;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.10.27 16:20
 */
public class BusSearchFundNetWorthReportVo {

    private Option option;

    private BusSearchFundNetWorthReportVoData data;

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public BusSearchFundNetWorthReportVoData getData() {
        return data;
    }

    public void setData(BusSearchFundNetWorthReportVoData data) {
        this.data = data;
    }
}
