package com.xin.api.bus.fund.dto;/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.11.19 17:25
 */

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.11.19 17:25
 */
public class BusSearchFundNetWorthReportVoData {

    /**
     * 最大净值
     */
    private String maxFundNetWorth;
    /**
     * 最大净值日期
     */
    private String maxFundNetWorthTime;
    /**
     * 最新净值
     */
    private String newFundNetWorth;
    /**
     * 最新净值日期
     */
    private String newFundNetWorthTime;
    /**
     * 净值浮动
     */
    private String fundNetWorthFloat;
    /**
     * 最新净值率
     */
    private String fundNetWorthFloatRate;
    /**
     * 估值净值时间
     */
    private String estimateFundNetWorthTime;
    /**
     * 预估净值
     */
    private String estimateFundNetWorth;
    /**
     * 预估净值浮动率
     */
    private String estimateFundNetWorthFloatRate;


    public String getMaxFundNetWorth() {
        return maxFundNetWorth;
    }

    public void setMaxFundNetWorth(String maxFundNetWorth) {
        this.maxFundNetWorth = maxFundNetWorth;
    }

    public String getMaxFundNetWorthTime() {
        return maxFundNetWorthTime;
    }

    public void setMaxFundNetWorthTime(String maxFundNetWorthTime) {
        this.maxFundNetWorthTime = maxFundNetWorthTime;
    }

    public String getNewFundNetWorth() {
        return newFundNetWorth;
    }

    public void setNewFundNetWorth(String newFundNetWorth) {
        this.newFundNetWorth = newFundNetWorth;
    }

    public String getNewFundNetWorthTime() {
        return newFundNetWorthTime;
    }

    public void setNewFundNetWorthTime(String newFundNetWorthTime) {
        this.newFundNetWorthTime = newFundNetWorthTime;
    }

    public String getFundNetWorthFloat() {
        return fundNetWorthFloat;
    }

    public void setFundNetWorthFloat(String fundNetWorthFloat) {
        this.fundNetWorthFloat = fundNetWorthFloat;
    }

    public String getFundNetWorthFloatRate() {
        return fundNetWorthFloatRate;
    }

    public void setFundNetWorthFloatRate(String fundNetWorthFloatRate) {
        this.fundNetWorthFloatRate = fundNetWorthFloatRate;
    }

    public String getEstimateFundNetWorthTime() {
        return estimateFundNetWorthTime;
    }

    public void setEstimateFundNetWorthTime(String estimateFundNetWorthTime) {
        this.estimateFundNetWorthTime = estimateFundNetWorthTime;
    }

    public String getEstimateFundNetWorth() {
        return estimateFundNetWorth;
    }

    public void setEstimateFundNetWorth(String estimateFundNetWorth) {
        this.estimateFundNetWorth = estimateFundNetWorth;
    }

    public String getEstimateFundNetWorthFloatRate() {
        return estimateFundNetWorthFloatRate;
    }

    public void setEstimateFundNetWorthFloatRate(String estimateFundNetWorthFloatRate) {
        this.estimateFundNetWorthFloatRate = estimateFundNetWorthFloatRate;
    }
}
