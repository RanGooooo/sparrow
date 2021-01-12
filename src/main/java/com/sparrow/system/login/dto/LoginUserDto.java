package com.sparrow.system.login.dto;

import com.sparrow.common.annotation.check.NotNull;

/**
 * @Description 用户登录信息封装
 * @Author RanGooooo
 * @date 2020.03.14 19:10
 */
public class LoginUserDto {

    @NotNull
    private String username;

    @NotNull
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
