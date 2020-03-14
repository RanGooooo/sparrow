package com.rain.sparrow.system.configure.service.impl;

import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.configure.dao.TSConfigureDao;
import com.rain.sparrow.system.configure.dao.TSConfigureRepository;
import com.rain.sparrow.system.configure.dto.TSConfigureDto;
import com.rain.sparrow.system.configure.entity.TSConfigure;
import com.rain.sparrow.system.configure.service.TSConfigureService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional
public class TSConfigureServiceImpl implements TSConfigureService {

    @Autowired
    private TSConfigureDao configureDao;

    @Autowired
    private TSConfigureRepository configureRepository;

    @Override
    public RestResult searchTSConfigureList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        TSConfigureDto dto = new TSConfigureDto();
        List<TSConfigure> list = configureDao.searchTSConfigureList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordTSConfigureSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        TSConfigure entity = configureRepository.findTSConfigureById(id);
        request.setAttribute("configure",entity);
    }

    @Override
    public void configureSave(TSConfigureDto dto) throws Exception{
        //TODO 判空代码 稍后添加
        String id = dto.getId();
        TSConfigure entity = new TSConfigure();
        if(!StringUtils.isEmpty(id)){
            entity  = configureRepository.findTSConfigureById(id);
        }
        BeanUtils.copyProperties(dto,entity);
        configureRepository.save(entity);
    }

    @Override
    public void configureDelete(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new Exception("删除TSConfigure_ZH失败，主键为空");
        }
        configureRepository.deleteById(id);
    }






}
