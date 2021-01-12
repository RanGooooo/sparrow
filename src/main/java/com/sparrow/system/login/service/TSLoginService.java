package com.sparrow.system.login.service;

import com.sparrow.system.login.dto.LoginUserDto;

/**
 * @Description
 * @Author RanGooooo
 * @date 2020.03.14 19:18
 */
public interface TSLoginService {


    void validate(LoginUserDto userDto) throws Exception;

}
