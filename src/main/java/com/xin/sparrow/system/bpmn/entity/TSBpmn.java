package com.xin.sparrow.system.bpmn.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@TableName("t_s_bpmn")
public class TSBpmn {

    /**主键*/
    private String id;
    /**模型KEY*/
    private String bpmnKey;
    /**模型名称*/
    private String bpmnName;
    /**模型图片*/
    private String bpmnImgae;
    /**模型XML*/
    private String bpmnXml;
    /**创建人*/
    private String createUser;
    /**创建时间*/
    private Date createDate;
    /**更新人*/
    private String updateUser;
    /**更新时间*/
    private Date updateDate;

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Column(name ="bpmn_key")
    public String getBpmnKey() {
        return bpmnKey;
    }
    public void setBpmnKey(String bpmnKey) {
        this.bpmnKey = bpmnKey;
    }
    @Column(name ="bpmn_name")
    public String getBpmnName() {
        return bpmnName;
    }
    public void setBpmnName(String bpmnName) {
        this.bpmnName = bpmnName;
    }
    @Column(name ="bpmn_imgae")
    public String getBpmnImgae() {
        return bpmnImgae;
    }
    public void setBpmnImgae(String bpmnImgae) {
        this.bpmnImgae = bpmnImgae;
    }
    @Column(name ="bpmn_xml")
    public String getBpmnXml() {
        return bpmnXml;
    }
    public void setBpmnXml(String bpmnXml) {
        this.bpmnXml = bpmnXml;
    }
    @Column(name ="create_user")
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    @Column(name ="create_date")
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    @Column(name ="update_user")
    public String getUpdateUser() {
        return updateUser;
    }
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    @Column(name ="update_date")
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
