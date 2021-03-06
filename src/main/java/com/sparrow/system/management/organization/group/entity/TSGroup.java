package com.sparrow.system.management.organization.group.entity;

import com.sparrow.common.annotation.check.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;



@Entity
@Table(name = "t_s_group")
@Alias(value = "TSGroup")
public class TSGroup {
/**组名*/
@NotNull
private String groupName;
/**主键*/
private String id;
/**父id*/
private String parentGroupId;
@Column(name ="group_name")
public String getGroupName() {
return groupName;
}
public void setGroupName(String groupName) {
this.groupName = groupName;
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
@Column(name ="parent_group_id")
public String getParentGroupId() {
return parentGroupId;
}
public void setParentGroupId(String parentGroupId) {
this.parentGroupId = parentGroupId;
}


}
