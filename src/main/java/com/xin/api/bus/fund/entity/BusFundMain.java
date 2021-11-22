package com.xin.api.bus.fund.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "bus_fund_main")
@Alias(value = "BusFundMain")
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

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name = "ID", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "fund_code")
    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    @Column(name = "fund_name")
    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    @Column(name = "fund_amount_money")
    public BigDecimal getFundAmountMoney() {
        return fundAmountMoney;
    }

    public void setFundAmountMoney(BigDecimal fundAmountMoney) {
        this.fundAmountMoney = fundAmountMoney;
    }

    @Column(name = "fund_income")
    public BigDecimal getFundIncome() {
        return fundIncome;
    }

    public void setFundIncome(BigDecimal fundIncome) {
        this.fundIncome = fundIncome;
    }

    @Column(name = "fund_net_worth")
    public BigDecimal getFundNetWorth() {
        return fundNetWorth;
    }

    public void setFundNetWorth(BigDecimal fundNetWorth) {
        this.fundNetWorth = fundNetWorth;
    }

    @Column(name = "fund_share")
    public BigDecimal getFundShare() {
        return fundShare;
    }

    public void setFundShare(BigDecimal fundShare) {
        this.fundShare = fundShare;
    }
}
