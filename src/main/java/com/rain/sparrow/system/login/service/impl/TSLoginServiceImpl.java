package com.rain.sparrow.system.login.service.impl;

import com.rain.sparrow.common.annotation.check.CheckData;
import com.rain.sparrow.common.constant.AuthenticationConstant;
import com.rain.sparrow.system.login.dao.TSLoginRepository;
import com.rain.sparrow.system.login.dto.LoginUserDto;
import com.rain.sparrow.system.login.service.TSLoginService;
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
public class TSLoginServiceImpl implements TSLoginService {

    @Autowired
    private HttpSession session;

    @Autowired
    private TSLoginRepository tsLoginRepository;


    @Override
    public void validate(@CheckData LoginUserDto userDto) throws Exception {
        String username = userDto.getUsername();
        String password = userDto.getPassword();
        if(!"admin".equals(username)||!"e10adc3949ba59abbe56e057f20f883e".equals(password)){
            throw new Exception("用户名 或 密码 错误");
        }
        session.setAttribute(AuthenticationConstant.USER_INFO, userDto);

    }
}
