package com.xin.api.sys.user.service.impl;

import com.xin.api.sys.user.entity.SysUserRole;
import com.xin.sparrow.common.dto.RestResult;
import com.xin.api.sys.user.dao.SysUserRoleMapper;
import com.xin.api.sys.user.dto.SysUserRoleDto;
import com.xin.api.sys.user.service.SysUserRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;


    @Override
    public RestResult searchTSRoleList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        SysUserRoleDto dto = new SysUserRoleDto();
        List<SysUserRole> list = sysUserRoleMapper.searchTSRoleList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordTSRoleSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        SysUserRole entity = sysUserRoleMapper.selectById(id);
        request.setAttribute("role",entity);
    }

    @Override
    public void roleSave(SysUserRoleDto dto) throws Exception{
        //TODO 判空代码 稍后添加
        String id = dto.getId();
        SysUserRole entity = new SysUserRole();
        if(!StringUtils.isEmpty(id)){
            entity  = sysUserRoleMapper.selectById(id);
        }
        BeanUtils.copyProperties(dto,entity);
        sysUserRoleMapper.insert(entity);
    }

    @Override
    public void roleDelete(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new Exception("删除TSRole_ZH失败，主键为空");
        }
        sysUserRoleMapper.deleteById(id);
    }






}
