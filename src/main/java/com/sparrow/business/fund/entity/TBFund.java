package com.sparrow.business.fund.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;



@Entity
@Table(name = "t_b_fund")
@Alias(value = "TBFund")
public class TBFund {
/**主键*/
private String id;
/**基金编码*/
private String fundCode;
/**基金名称*/
private String fundName;
@Id
@GeneratedValue(generator = "paymentableGenerator")
@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
@Column(name ="ID",nullable=false,length=36)
public String getId() {
return id;
}
public void setId(String id) {
this.id = id;
}
@Column(name ="fund_code")
public String getFundCode() {
return fundCode;
}
public void setFundCode(String fundCode) {
this.fundCode = fundCode;
}
@Column(name ="fund_name")
public String getFundName() {
return fundName;
}
public void setFundName(String fundName) {
this.fundName = fundName;
}

}
