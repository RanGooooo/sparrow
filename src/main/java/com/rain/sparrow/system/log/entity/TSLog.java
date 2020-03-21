package com.rain.sparrow.system.log.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "log_db")
@Alias(value = "TSLog")
public class TSLog {
/***/
private String id;
/**日志类型*/
private String logType;
/**日志内容*/
private String logContent;
/**创建时间*/
private Date createTime;
/**创建用户*/
private String createUser;
/**业务类型*/
private String businessType;
/**业务名称*/
private String businessName;
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
@Column(name ="log_type")
public String getLogType() {
return logType;
}
public void setLogType(String logType) {
this.logType = logType;
}
@Column(name ="log_content")
public String getLogContent() {
return logContent;
}
public void setLogContent(String logContent) {
this.logContent = logContent;
}
@Column(name ="create_time")
public Date getCreateTime() {
return createTime;
}
public void setCreateTime(Date createTime) {
this.createTime = createTime;
}
@Column(name ="create_user")
public String getCreateUser() {
return createUser;
}
public void setCreateUser(String createUser) {
this.createUser = createUser;
}
@Column(name ="business_type")
public String getBusinessType() {
return businessType;
}
public void setBusinessType(String businessType) {
this.businessType = businessType;
}
@Column(name ="business_name")
public String getBusinessName() {
return businessName;
}
public void setBusinessName(String businessName) {
this.businessName = businessName;
}

}
