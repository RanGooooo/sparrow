package com.rain.sparrow.system.conf.application.service.impl;

import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.conf.application.dao.TSApplicationDao;
import com.rain.sparrow.system.conf.application.dao.TSApplicationRepository;
import com.rain.sparrow.system.conf.application.dto.TSApplicationDto;
import com.rain.sparrow.system.conf.application.entity.TSApplication;
import com.rain.sparrow.system.conf.application.service.TSApplicationService;
import com.rain.sparrow.system.menu.dto.TSMenuDto;
import com.rain.sparrow.system.menu.entity.TSMenu;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional
public class TSApplicationServiceImpl implements TSApplicationService {

    @Autowired
    private TSApplicationDao applicationDao;

    @Autowired
    private TSApplicationRepository applicationRepository;

    @Override
    public RestResult searchTSApplicationList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        String parentApplicationId = request.getParameter("parentApplicationId");
        TSApplicationDto dto = new TSApplicationDto();
        if(StringUtils.isEmpty(parentApplicationId)){
            parentApplicationId = "TOP";
        }
        dto.setParentApplicationId(parentApplicationId);
        List<TSApplication> list = applicationDao.searchTSApplicationList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordTSApplicationSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        TSApplication entity = applicationRepository.findTSApplicationById(id);
        request.setAttribute("application",entity);
    }

    @Override
    public void applicationSave(TSApplicationDto dto) throws Exception{
        //TODO 判空代码 稍后添加
        String id = dto.getId();
        TSApplication entity = new TSApplication();
        if(!StringUtils.isEmpty(id)){
            entity  = applicationRepository.findTSApplicationById(id);
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






}