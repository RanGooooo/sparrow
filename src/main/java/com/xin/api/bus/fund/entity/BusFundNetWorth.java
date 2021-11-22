package com.xin.api.bus.fund.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.10.27 14:50
 */
@TableName("bus_fund_net_worth")
public class BusFundNetWorth {

    /**
     * 主键
     */
    private String id;
    /**
     * 基金id
     */
    private String fundId;
    /**
     * 基金编码
     */
    private String fundCode;
    /**
     * 基金名称
     */
    private String fundName;
    /**
     * 基金净值
     */
    private BigDecimal fundNetWorth;
    /**
     * 基金净值
     */
    private Date fundNetWorthTime;

    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
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

    public BigDecimal getFundNetWorth() {
        return fundNetWorth;
    }

    public void setFundNetWorth(BigDecimal fundNetWorth) {
        this.fundNetWorth = fundNetWorth;
    }

    public Date getFundNetWorthTime() {
        return fundNetWorthTime;
    }

    public void setFundNetWorthTime(Date fundNetWorthTime) {
        this.fundNetWorthTime = fundNetWorthTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
