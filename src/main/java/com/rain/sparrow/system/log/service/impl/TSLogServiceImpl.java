package com.rain.sparrow.system.log.service.impl;

import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.log.dao.TSLogDao;
import com.rain.sparrow.system.log.dao.TSLogRepository;
import com.rain.sparrow.system.log.dto.TSLogDto;
import com.rain.sparrow.system.log.entity.TSLog;
import com.rain.sparrow.system.log.service.TSLogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional
public class TSLogServiceImpl implements TSLogService {

    @Autowired
    private TSLogDao logDao;

    @Autowired
    private TSLogRepository logRepository;

    @Override
    public RestResult searchTSLogList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        TSLogDto dto = new TSLogDto();
        List<TSLog> list = logDao.searchTSLogList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordTSLogSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        TSLog entity = logRepository.findTSLogById(id);
        request.setAttribute("log",entity);
    }

    @Override
    public void logSave(TSLogDto dto) throws Exception{
        //TODO 判空代码 稍后添加
        String id = dto.getId();
        TSLog entity = new TSLog();
        if(!StringUtils.isEmpty(id)){
            entity  = logRepository.findTSLogById(id);
        }
        BeanUtils.copyProperties(dto,entity);
        logRepository.save(entity);
    }

    @Override
    public void logDelete(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new Exception("删除TSLog_ZH失败，主键为空");
        }
        logRepository.deleteById(id);
    }






}
