package com.xin.api.sys.login.service.impl;

import com.xin.sparrow.common.annotation.check.CheckData;
import com.xin.sparrow.common.constant.AuthenticationConstant;
import com.xin.api.sys.login.dto.LoginUserDto;
import com.xin.api.sys.login.service.SysLoginMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author RanGooooo
 * @date 2020.03.14 19:19
 */
@Service
@Transactional
public class SysLoginMainServiceImpl implements SysLoginMainService {

    @Autowired
    private HttpSession session;


    @Override
    public void validate(@CheckData LoginUserDto userDto) throws Exception {
        String username = userDto.getUsername();
        String password = userDto.getPassword();
        if (!"admin".equals(username) || !"e10adc3949ba59abbe56e057f20f883e".equals(password)) {
            throw new Exception("用户名 或 密码 错误");
        }
        session.setAttribute(AuthenticationConstant.USER_INFO, userDto);

    }
}
