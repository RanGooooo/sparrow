package com.rain.sparrow.system.configure.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;



@Entity
@Table(name = "t_s_configure")
@Alias(value = "TSConfigure")
public class TSConfigure {
/**主键*/
private String id;
/**配置key*/
private String configureKey;
/**配置值*/
private String configureValue;
/**状态 DOTO*/
private String state;
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
@Column(name ="configure_key")
public String getConfigureKey() {
return configureKey;
}
public void setConfigureKey(String configureKey) {
this.configureKey = configureKey;
}
@Column(name ="configure_value")
public String getConfigureValue() {
return configureValue;
}
public void setConfigureValue(String configureValue) {
this.configureValue = configureValue;
}
@Column(name ="state")
public String getState() {
return state;
}
public void setState(String state) {
this.state = state;
}

}
