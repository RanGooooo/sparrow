package com.sparrow.system.management.organization.role.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;



@Entity
@Table(name = "role_db")
@Alias(value = "TSRole")
public class TSRole {
/**角色code*/
private String code;
/**主键*/
private String id;
/**角色名称*/
private String name;
@Column(name ="code")
public String getCode() {
return code;
}
public void setCode(String code) {
this.code = code;
}
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
@Column(name ="name")
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}

}
