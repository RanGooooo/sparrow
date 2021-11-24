package com.xin.api.sys.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xin.sparrow.common.annotation.check.NotNull;
import lombok.Data;

/**
* 作者:  zhaohongyu
* 创建时间:  2021-11-24 14:24
*/
@Data
@TableName("sys_user_main")
public class SysUserMain {

    /**
     * 主键
     */
    private String id;
    /**
     * 帐户状态[01正常使用]
     */
    private String accountState;
    /**
     * 手机号
     */
    @NotNull
    private String mobilePhone;
    /**
     * 密码
     */
    @NotNull
    private String password;
    /**
     * 真实姓名
     */
    @NotNull
    private String realName;
    /**
     * 用户名
     */
    @NotNull
    private String userName;
    /**
     * 电子邮箱
     */
    @NotNull
    private String email;

}
