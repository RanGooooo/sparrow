package com.xin.api.sys.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xin.sparrow.common.annotation.check.NotNull;
import lombok.Data;

/**
* 作者:  zhaohongyu
* 创建时间:  2021-11-24 14:24
*/
@Data
@TableName("sys_user_org")
public class SysUserOrg {

    /**
     * 组名
     */
    @NotNull
    private String groupName;
    /**
     * 主键
     */
    private String id;
    /**
     * 父id
     */
    private String parentGroupId;

}
