package com.xin.api.bus.fund.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.07.15 09:00
 */
@Data
@TableName("bus_fund_user")
public class BusFundUser {

    private String id;

    private String fundId;

    private String userId;


}
