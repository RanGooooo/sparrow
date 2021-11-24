package com.xin.api.bus.fund.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("bus_fund_main")
public class BusFundMain {

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
     * 基金金额
     */
    private BigDecimal fundAmountMoney;

    /**
     * 基金收益
     */
    private BigDecimal fundIncome;

    /**
     * 基金净值
     */
    private BigDecimal fundNetWorth;

    /**
     * 持有份额
     */
    private BigDecimal fundShare;

}
