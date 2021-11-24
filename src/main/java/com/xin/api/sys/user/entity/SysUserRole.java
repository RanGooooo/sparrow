package com.xin.api.sys.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
* 作者:  zhaohongyu
* 创建时间:  2021-11-24 14:25
*/
@Data
@TableName("sys_user_role")
public class SysUserRole {

    /**
     * 角色code
     */
    private String code;
    /**
     * 主键
     */
    private String id;
    /**
     * 角色名称
     */
    private String name;

}
