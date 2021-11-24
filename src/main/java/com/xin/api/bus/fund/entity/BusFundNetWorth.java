package com.xin.api.bus.fund.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.10.27 14:50
 */
@Data
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
    /**
     * 创建时间
     */
    private Date createTime;

}
