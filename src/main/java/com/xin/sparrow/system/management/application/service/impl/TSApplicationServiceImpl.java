package com.xin.sparrow.system.management.application.service.impl;

import com.alibaba.fastjson.JSON;
import com.xin.sparrow.common.annotation.check.CheckData;
import com.xin.sparrow.common.constant.status.RunningStateConstant;
import com.xin.sparrow.common.dto.DxResult;
import com.xin.sparrow.common.dto.RestResult;
import com.xin.sparrow.common.dto.TreeDto;
import com.xin.sparrow.system.management.application.constant.TSApplicationConstant;
import com.xin.sparrow.system.management.application.dao.TSApplicationDao;
import com.xin.sparrow.system.management.application.dao.TSApplicationRepository;
import com.xin.sparrow.system.management.application.dto.TSApplicationDto;
import com.xin.sparrow.system.management.application.entity.TSApplication;
import com.xin.sparrow.system.management.application.service.TSApplicationService;
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
    public DxResult<List<TSApplication>> searchMyTSApplicationList(TSApplicationDto dto) throws Exception {
        return DxResult.success(applicationDao.searchTSApplicationList(dto));
    }

    @Override
    public RestResult searchTSApplicationList(TSApplicationDto dto) throws Exception {
        RestResult result = new RestResult();
        String parentApplicationId = dto.getParentApplicationId();
        String runningState = dto.getRunningState();
        String applicationName = dto.getApplicationName();
        if(StringUtils.isEmpty(parentApplicationId)&&
            StringUtils.isEmpty(runningState)&&
            StringUtils.isEmpty(applicationName)){
            dto.setParentApplicationId(TSApplicationConstant.PARENT_APPLICATION_ID_TOP);
        }
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
            request.setAttribute("TSApplication", JSON.toJSONString(dto));
        }
    }

    @Override
    public RestResult applicationSave(@CheckData TSApplicationDto dto) throws Exception{
        RestResult result = new RestResult();
        String id = dto.getId();
        TSApplication entity = new TSApplication();
        String parentApplicationId = dto.getParentApplicationId();
        if(StringUtils.isEmpty(parentApplicationId)){
            dto.setParentApplicationId(TSApplicationConstant.PARENT_APPLICATION_ID_TOP);
        }else{
            TSApplication parentApplication = applicationRepository.findTSApplicationById(parentApplicationId);
            if(parentApplication!=null){
                parentApplication.setPosition(TSApplicationConstant.POSITION_TRUE);
                applicationRepository.save(parentApplication);
            }
        }
        if(!StringUtils.isEmpty(id)){
            entity  = applicationRepository.findTSApplicationById(id);
        }else{
            dto.setRunningState(RunningStateConstant.RUNNING_STATE_00);
        }
        BeanUtils.copyProperties(dto,entity);
        applicationRepository.save(entity);
        dto.setId(entity.getId());
        result.setObject(dto);
        return result;
    }

    @Override
    public void applicationDelete(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new Exception("删除失败，主键为空");
        }
        TSApplication entity = applicationRepository.findTSApplicationById(id);
        List<TSApplication> applicationList1 = applicationRepository.findTSApplicationByParentApplicationId(id);
        if(applicationList1.size()>0){
            throw new Exception("存在子应用");
        }
        String parentApplicationId = entity.getParentApplicationId();
        List<TSApplication> applicationList = applicationRepository.findTSApplicationByParentApplicationId(parentApplicationId);
        if(applicationList.size()==1){
            TSApplication parent = applicationRepository.findTSApplicationById(parentApplicationId);
            parent.setPosition(TSApplicationConstant.POSITION_FALSE);
            applicationRepository.save(parent);
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
