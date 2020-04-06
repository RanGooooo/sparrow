package com.rain.sparrow.system.conf.application.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.rain.sparrow.common.annotation.check.CheckData;
import com.rain.sparrow.common.constant.status.RunningStateConstant;
import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.common.dto.TreeDto;
import com.rain.sparrow.system.conf.application.dao.TSApplicationDao;
import com.rain.sparrow.system.conf.application.dao.TSApplicationRepository;
import com.rain.sparrow.system.conf.application.dto.TSApplicationDto;
import com.rain.sparrow.system.conf.application.entity.TSApplication;
import com.rain.sparrow.system.conf.application.service.TSApplicationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TSApplicationServiceImpl implements TSApplicationService {

    @Autowired
    private TSApplicationDao applicationDao;

    @Autowired
    private TSApplicationRepository applicationRepository;

    @Override
    public RestResult searchMyTSApplicationList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        TSApplicationDto dto = new TSApplicationDto();
        List<TSApplication> list = applicationDao.searchTSApplicationList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public RestResult searchTSApplicationList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        String parentApplicationId = request.getParameter("parentApplicationId");
        String applicationName = request.getParameter("applicationName");
        TSApplicationDto dto = new TSApplicationDto();
        dto.setParentApplicationId(parentApplicationId);
        dto.setApplicationName(applicationName);
        List<TSApplication> list = applicationDao.searchTSApplicationList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordTSApplicationSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(!StringUtils.isEmpty(id)){
            TSApplication entity = applicationRepository.findTSApplicationById(id);
            TSApplicationDto dto = new TSApplicationDto();
            BeanUtils.copyProperties(entity,dto);
            String parentApplicationId = entity.getParentApplicationId();
            TSApplication parentTSApplication = applicationRepository.findTSApplicationById(parentApplicationId);
            if(!StringUtils.isEmpty(parentTSApplication)){
                dto.setParentApplicationName(parentTSApplication.getApplicationName());
            }
            request.setAttribute("TSApplication", JSONObject.toJSONString(dto));
        }
    }

    @Override
    public void applicationSave(@CheckData TSApplicationDto dto) throws Exception{
        String id = dto.getId();
        TSApplication entity = new TSApplication();
        if(!StringUtils.isEmpty(id)){
            entity  = applicationRepository.findTSApplicationById(id);
        }else{
            dto.setRunningState(RunningStateConstant.RUNNING_STATE_00);
        }
        BeanUtils.copyProperties(dto,entity);
        applicationRepository.save(entity);
    }

    @Override
    public void applicationDelete(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new Exception("删除TSApplication_ZH失败，主键为空");
        }
        applicationRepository.deleteById(id);
    }

    @Override
    public RestResult searchTSApplicationTree(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        TSApplicationDto dto = new TSApplicationDto();
        List<TSApplication> list = applicationDao.searchTSApplicationList(dto);
        List<TreeDto> treeList = new ArrayList<>();
        for (TSApplication application:list){
            TreeDto treeDto = new TreeDto();
            treeList.add(treeDto);
            treeDto.setId(application.getId());
            treeDto.setName(application.getApplicationName());
            treeDto.setpId(application.getParentApplicationId());
        }
        result.setObject(treeList);
        return result;
    }
}
