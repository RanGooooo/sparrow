package com.rain.sparrow.system.management.organization.role.service.impl;

import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.management.organization.role.dao.TSRoleDao;
import com.rain.sparrow.system.management.organization.role.dao.TSRoleRepository;
import com.rain.sparrow.system.management.organization.role.dto.TSRoleDto;
import com.rain.sparrow.system.management.organization.role.entity.TSRole;
import com.rain.sparrow.system.management.organization.role.service.TSRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional
public class TSRoleServiceImpl implements TSRoleService {

    @Autowired
    private TSRoleDao roleDao;

    @Autowired
    private TSRoleRepository roleRepository;

    @Override
    public RestResult searchTSRoleList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        TSRoleDto dto = new TSRoleDto();
        List<TSRole> list = roleDao.searchTSRoleList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordTSRoleSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        TSRole entity = roleRepository.findTSRoleById(id);
        request.setAttribute("role",entity);
    }

    @Override
    public void roleSave(TSRoleDto dto) throws Exception{
        //TODO 判空代码 稍后添加
        String id = dto.getId();
        TSRole entity = new TSRole();
        if(!StringUtils.isEmpty(id)){
            entity  = roleRepository.findTSRoleById(id);
        }
        BeanUtils.copyProperties(dto,entity);
        roleRepository.save(entity);
    }

    @Override
    public void roleDelete(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new Exception("删除TSRole_ZH失败，主键为空");
        }
        roleRepository.deleteById(id);
    }






}
