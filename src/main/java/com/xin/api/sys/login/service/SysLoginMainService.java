package com.xin.api.sys.login.service;

import com.xin.api.sys.login.dto.LoginUserDto;

/**
 * @Description
 * @Author RanGooooo
 * @date 2020.03.14 19:18
 */
public interface SysLoginMainService {


    void validate(LoginUserDto userDto) throws Exception;

}
