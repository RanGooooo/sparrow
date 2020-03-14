package com.rain.sparrow.system.group.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;



@Entity
@Table(name = "t_s_group")
@Alias(value = "TSGroup")
public class TSGroup {
/**主键*/
private String id;
/**组名*/
private String groupName;
/**表名称*/
private String table;
/**表主键*/
private String tableId;
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
@Column(name ="group_name")
public String getGroupName() {
return groupName;
}
public void setGroupName(String groupName) {
this.groupName = groupName;
}
@Column(name ="table")
public String getTable() {
return table;
}
public void setTable(String table) {
this.table = table;
}
@Column(name ="table_id")
public String getTableId() {
return tableId;
}
public void setTableId(String tableId) {
this.tableId = tableId;
}

}
