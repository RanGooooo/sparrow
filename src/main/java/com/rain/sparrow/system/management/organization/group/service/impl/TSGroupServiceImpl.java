package com.rain.sparrow.system.management.organization.group.service.impl;

import com.rain.sparrow.common.annotation.check.CheckData;
import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.management.organization.group.dao.TSGroupDao;
import com.rain.sparrow.system.management.organization.group.dao.TSGroupRepository;
import com.rain.sparrow.system.management.organization.group.dto.TSGroupDto;
import com.rain.sparrow.system.management.organization.group.entity.TSGroup;
import com.rain.sparrow.system.management.organization.group.service.TSGroupService;
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
public class TSGroupServiceImpl implements TSGroupService {

    @Autowired
    private TSGroupDao groupDao;

    @Autowired
    private TSGroupRepository groupRepository;

    @Override
    public RestResult searchTSGroupList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        TSGroupDto dto = new TSGroupDto();
        List<TSGroup> list = groupDao.searchTSGroupList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordTSGroupSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        TSGroup entity = groupRepository.findTSGroupById(id);
        request.setAttribute("group",entity);
    }

    @Override
    public RestResult groupSave(@CheckData TSGroupDto dto) throws Exception{
        RestResult result = new RestResult();
        String id = dto.getId();
        TSGroup entity = new TSGroup();
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
        TSGroupDto dto = new TSGroupDto();
        List<TSGroupDto> list = groupDao.searchTSGroupTree(dto);
        for (TSGroupDto groupDto : list) {
            
        }


        result.setObject(list);
        return result;
    }


}
