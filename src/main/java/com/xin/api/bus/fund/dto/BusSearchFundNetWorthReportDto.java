package com.xin.api.bus.fund.dto;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.10.27 16:20
 */
public class BusSearchFundNetWorthReportDto {

    private String fundCode;

    private Integer dayNumber;

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(Integer dayNumber) {
        this.dayNumber = dayNumber;
    }
}
