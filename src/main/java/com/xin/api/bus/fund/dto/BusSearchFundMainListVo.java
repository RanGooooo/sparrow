package com.xin.api.bus.fund.dto;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.11.22 14:06
 */
public class BusSearchFundMainListVo {

    /**
     * 主键
     */
    private String id;
    /**
     * 基金编码
     */
    private String fundCode;
    /**
     * 基金名称
     */
    private String fundName;

    /**
     * 净值
     */
    private String fundNetWorth;

    /**
     * 净值日期
     */
    private String fundNetWorthTime;

    /**
     * 净值估算时间
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


    private String fundShare;

    public String getEstimateFundNetWorth() {
        return estimateFundNetWorth;
    }

    public void setEstimateFundNetWorth(String estimateFundNetWorth) {
        this.estimateFundNetWorth = estimateFundNetWorth;
    }

    public String getEstimateFundNetWorthTime() {
        return estimateFundNetWorthTime;
    }

    public void setEstimateFundNetWorthTime(String estimateFundNetWorthTime) {
        this.estimateFundNetWorthTime = estimateFundNetWorthTime;
    }

    public String getEstimateFundNetWorthFloatRate() {
        return estimateFundNetWorthFloatRate;
    }

    public void setEstimateFundNetWorthFloatRate(String estimateFundNetWorthFloatRate) {
        this.estimateFundNetWorthFloatRate = estimateFundNetWorthFloatRate;
    }

    public String getFundNetWorthTime() {
        return fundNetWorthTime;
    }

    public void setFundNetWorthTime(String fundNetWorthTime) {
        this.fundNetWorthTime = fundNetWorthTime;
    }

    public String getFundNetWorth() {
        return fundNetWorth;
    }

    public void setFundNetWorth(String fundNetWorth) {
        this.fundNetWorth = fundNetWorth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundShare() {
        return fundShare;
    }

    public void setFundShare(String fundShare) {
        this.fundShare = fundShare;
    }

}
