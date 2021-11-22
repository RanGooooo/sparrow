package com.xin.api.bus.fund.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.11.22 11:41
 */
public class BusSearchFundNetWorthListVo {

    /**
     * 基金净值
     */
    private BigDecimal fundNetWorth;
    /**
     * 基金净值
     */
    private Date fundNetWorthTime;


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
}
