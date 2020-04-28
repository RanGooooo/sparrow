package com.rain.sparrow.system.management.application.entity;

import com.rain.sparrow.common.annotation.check.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;



@Entity
@Table(name = "t_s_application")
@Alias(value = "TSApplication")
public class TSApplication {
    /**主键*/
    private String id;
    /**应用名称*/
    @NotNull
    private String applicationName;
    /**应用地址*/
    @NotNull
    private String applicationUrl;
    /**应用等级*/
    @NotNull
    private String applicationLevel;
    /**应用排序*/
    @NotNull
    private String applicationOrder;
    /**应用图标*/
    @NotNull
    private String applicationIcon;
    /**父应用id*/
    private String parentApplicationId;
    /**[true 树枝]，[false 叶子]*/
    private String position;
    /*RunningStateConstant*/
    private String runningState;
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
    @Column(name ="application_name")
    public String getApplicationName() {
    return applicationName;
    }
    public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
    }
    @Column(name ="application_url")
    public String getApplicationUrl() {
    return applicationUrl;
    }
    public void setApplicationUrl(String applicationUrl) {
    this.applicationUrl = applicationUrl;
    }
    @Column(name ="application_level")
    public String getApplicationLevel() {
    return applicationLevel;
    }
    public void setApplicationLevel(String applicationLevel) {
    this.applicationLevel = applicationLevel;
    }
    @Column(name ="application_order")
    public String getApplicationOrder() {
    return applicationOrder;
    }
    public void setApplicationOrder(String applicationOrder) {
    this.applicationOrder = applicationOrder;
    }
    @Column(name ="application_icon")
    public String getApplicationIcon() {
    return applicationIcon;
    }
    public void setApplicationIcon(String applicationIcon) {
    this.applicationIcon = applicationIcon;
    }
    @Column(name ="parent_application_id")
    public String getParentApplicationId() {
    return parentApplicationId;
    }
    public void setParentApplicationId(String parentApplicationId) {
    this.parentApplicationId = parentApplicationId;
    }
    @Column(name ="position")
    public String getPosition() {
    return position;
    }
    public void setPosition(String position) {
    this.position = position;
    }

    @Column(name ="running_state")
    public String getRunningState() {
        return runningState;
    }

    public void setRunningState(String runningState) {
        this.runningState = runningState;
    }
}
