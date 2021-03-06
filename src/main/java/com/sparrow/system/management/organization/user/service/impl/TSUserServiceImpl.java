package com.sparrow.system.management.organization.user.service.impl;

import com.sparrow.common.annotation.check.CheckData;
import com.sparrow.common.dto.RestResult;
import com.sparrow.system.management.organization.user.constant.TSUserConstant;
import com.sparrow.system.management.organization.user.dao.TSUserDao;
import com.sparrow.system.management.organization.user.dao.TSUserRepository;
import com.sparrow.system.management.organization.user.dto.TSUserDto;
import com.sparrow.system.management.organization.user.entity.TSUser;
import com.sparrow.system.management.organization.user.service.TSUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional
public class TSUserServiceImpl implements TSUserService {

    @Autowired
    private TSUserDao userDao;

    @Autowired
    private TSUserRepository userRepository;

    @Override
    public RestResult searchTSUserList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        TSUserDto dto = new TSUserDto();
        List<TSUser> list = userDao.searchTSUserList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordTSUserSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        TSUser entity = userRepository.findTSUserById(id);
        request.setAttribute("user",entity);
    }

    @Override
    public void userSave(@CheckData  TSUserDto dto) throws Exception{
        String id = dto.getId();
        TSUser entity = new TSUser();
        if(!StringUtils.isEmpty(id)){
            entity  = userRepository.findTSUserById(id);
        }
        BeanUtils.copyProperties(dto,entity);
        entity.setAccountState(TSUserConstant.ACCOUNT_STATE_01);
        userRepository.save(entity);
    }

    @Override
    public void userDelete(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new Exception("删除TSUser_ZH失败，主键为空");
        }
        userRepository.deleteById(id);
    }






}
