package com.xin.api.sys.user.service.impl;

import com.xin.api.sys.user.dao.SysUserMainMapper;
import com.xin.api.sys.user.dto.SysUserMainDto;
import com.xin.api.sys.user.entity.SysUserMain;
import com.xin.api.sys.user.service.SysUserMainService;
import com.xin.common.model.enums.SysUserMainAccountStateEnum;
import com.xin.sparrow.common.annotation.check.CheckData;
import com.xin.sparrow.common.dto.RestResult;
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
    private SysUserMainMapper sysUserMainMapper;

    @Override
    public RestResult searchTSUserList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        SysUserMainDto dto = new SysUserMainDto();
        List<SysUserMain> list = sysUserMainMapper.searchTSUserList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordTSUserSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        SysUserMain entity = sysUserMainMapper.selectById(id);
        request.setAttribute("user",entity);
    }

    @Override
    public void userSave(@CheckData SysUserMainDto dto) throws Exception{
        String id = dto.getId();
        SysUserMain entity = new SysUserMain();
        if(!StringUtils.isEmpty(id)){
            entity  = sysUserMainMapper.selectById(id);
        }
        BeanUtils.copyProperties(dto,entity);
        entity.setAccountState(SysUserMainAccountStateEnum.NORMAL.systemcode);
        sysUserMainMapper.insert(entity);
    }

    @Override
    public void userDelete(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new Exception("删除TSUser_ZH失败，主键为空");
        }
        sysUserMainMapper.deleteById(id);
    }






}
