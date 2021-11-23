package com.xin.api.sys.inter.mail.service.impl;

import com.xin.api.sys.inter.mail.service.SysMailMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
* 作者:  zhaohongyu
* 创建时间:  2021-11-23 17:21
*/
@Service
public class SysMailMainServiceImpl implements SysMailMainService {

    @Value("${spring.mail.username}")
    private String from;


    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleMail(String to,String title,String content){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(content);
        simpleMailMessage.setFrom(from);
        javaMailSender.send(simpleMailMessage);
    }

}
