package com.xin.sparrow.system.bpmn.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
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


}
