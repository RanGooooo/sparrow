package com.xin.api.sys.user.service.impl;

import com.xin.sparrow.common.annotation.check.CheckData;
import com.xin.sparrow.common.dto.RestResult;
import com.xin.api.sys.user.constant.TSUserConstant;
import com.xin.api.sys.user.dao.SysUserMainMapper;
import com.xin.api.sys.user.dao.TSUserRepository;
import com.xin.api.sys.user.dto.TSUserDto;
import com.xin.api.sys.user.entity.SysUserMain;
import com.xin.api.sys.user.service.SysUserMainService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional
public class SysUserMainServiceImpl implements SysUserMainService {

    @Autowired
    private SysUserMainMapper userDao;

    @Autowired
    private TSUserRepository userRepository;

    @Override
    public RestResult searchTSUserList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        TSUserDto dto = new TSUserDto();
        List<SysUserMain> list = userDao.searchTSUserList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordTSUserSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        SysUserMain entity = userRepository.findTSUserById(id);
        request.setAttribute("user",entity);
    }

    @Override
    public void userSave(@CheckData  TSUserDto dto) throws Exception{
        String id = dto.getId();
        SysUserMain entity = new SysUserMain();
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
