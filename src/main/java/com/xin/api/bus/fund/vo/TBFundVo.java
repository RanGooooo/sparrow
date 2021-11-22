package com.xin.api.bus.fund.vo;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.07.13 17:06
 */
public class TBFundVo {

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
     * 预估净值
     */
    private String fundNetWorthTime;

    /**
     * 预估净值
     */
    private String estimateFundNetWorth;

    /**
     * 预估净值浮动百分比
     */
    private String estimateFundNetWorthFloatPercentage;

    /**
     * 估值时间
     */
    private String estimateTime;

    private String fundShare;

    public String getEstimateFundNetWorth() {
        return estimateFundNetWorth;
    }

    public void setEstimateFundNetWorth(String estimateFundNetWorth) {
        this.estimateFundNetWorth = estimateFundNetWorth;
    }

    public String getEstimateFundNetWorthFloatPercentage() {
        return estimateFundNetWorthFloatPercentage;
    }

    public void setEstimateFundNetWorthFloatPercentage(String estimateFundNetWorthFloatPercentage) {
        this.estimateFundNetWorthFloatPercentage = estimateFundNetWorthFloatPercentage;
    }

    public String getEstimateTime() {
        return estimateTime;
    }

    public void setEstimateTime(String estimateTime) {
        this.estimateTime = estimateTime;
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
