package com.sparrow.business.fund.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Description
 * @Author 赵宏宇
 * @date 2021.07.15 09:00
 */
@Entity
@Table(name = "t_b_fund_user")
@Alias(value = "TBFundUser")
public class TBFundUser {

    private String id;

    private String fundId;

    private String userId;

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

    @Column(name = "fund_id")
    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
