package com.xin.api.sys.inter.mail.service;

import org.springframework.stereotype.Service;

/**
* 作者:  zhaohongyu
* 创建时间:  2021-11-23 17:20
*/
public interface SysMailMainService {

    void sendSimpleMail(String to,String title,String content);

}
