package com.xin.api.bus.fund.dto;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.11.22 11:40
 */
public class BusSearchFundNetWorthListDto {

    private String fundCode;

    private String fundNetWorthTimeBegin;

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundNetWorthTimeBegin() {
        return fundNetWorthTimeBegin;
    }

    public void setFundNetWorthTimeBegin(String fundNetWorthTimeBegin) {
        this.fundNetWorthTimeBegin = fundNetWorthTimeBegin;
    }
}
