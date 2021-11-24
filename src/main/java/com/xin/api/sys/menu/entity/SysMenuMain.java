package com.xin.api.sys.menu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xin.sparrow.common.annotation.check.NotNull;
import lombok.Data;


@Data
@TableName("sys_menu_main")
public class SysMenuMain {

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
    private Integer applicationLevel;
    /**应用排序*/
    @NotNull
    private Integer applicationOrder;
    /**应用图标*/
    @NotNull
    private String applicationIcon;
    /**父应用id*/
    private String parentApplicationId;
    /**[true 树枝]，[false 叶子]*/
    private String position;
    /*RunningStateConstant*/
    private String runningState;

}
