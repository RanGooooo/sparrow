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
    private String menuName;
    /**应用地址*/
    @NotNull
    private String menuUrl;
    /**应用等级*/
    @NotNull
    private Integer menuLevel;
    /**应用排序*/
    @NotNull
    private Integer menuOrder;
    /**应用图标*/
    @NotNull
    private String menuIcon;
    /**父应用id*/
    private String parentMenuId;
    /**[true 树枝]，[false 叶子]*/
    private String position;
    /*RunningStateConstant*/
    private String runningState;

}
