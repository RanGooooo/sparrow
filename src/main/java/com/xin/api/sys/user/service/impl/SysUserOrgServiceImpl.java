package com.xin.api.sys.user.service.impl;

import com.xin.api.sys.user.entity.SysUserOrg;
import com.xin.sparrow.common.annotation.check.CheckData;
import com.xin.sparrow.common.dto.RestResult;
import com.xin.api.sys.user.dao.SysUserOrgMapper;
import com.xin.api.sys.user.dao.TSGroupRepository;
import com.xin.sparrow.system.management.organization.group.dto.TSGroupDto;
import com.xin.api.sys.user.service.SysUserOrgService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 六一儿童节快乐
* @Author:  zhaohongyu
* @CreateDate:  2020-6-1 22:36
*/
@Service
@Transactional
public class SysUserOrgServiceImpl implements SysUserOrgService {

    @Autowired
    private SysUserOrgMapper groupDao;

    @Autowired
    private TSGroupRepository groupRepository;

    @Override
    public RestResult searchTSGroupList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        TSGroupDto dto = new TSGroupDto();
        List<SysUserOrg> list = groupDao.searchTSGroupList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordTSGroupSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        SysUserOrg entity = groupRepository.findTSGroupById(id);
        request.setAttribute("group",entity);
    }

    @Override
    public RestResult groupSave(@CheckData TSGroupDto dto) throws Exception{
        RestResult result = new RestResult();
        String id = dto.getId();
        SysUserOrg entity = new SysUserOrg();
        if(!StringUtils.isEmpty(id)){
            entity  = groupRepository.findTSGroupById(id);
        }
        BeanUtils.copyProperties(dto,entity);
        groupRepository.save(entity);
        result.setObject(entity);
        return result;
    }

    @Override
    public void groupDelete(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new Exception("删除TSGroup_ZH失败，主键为空");
        }
        groupRepository.deleteById(id);
    }
    
    @Override
    public RestResult searchTSGroupTree(HttpServletRequest request) {
        RestResult result = new RestResult();
        String parentGroupId = request.getParameter("parentGroupId");
        TSGroupDto dto = new TSGroupDto();
        dto.setParentGroupId(parentGroupId);
        List<TSGroupDto> list = groupDao.searchTSGroupTree(dto);
        result.setObject(list);
        return result;
    }


}
