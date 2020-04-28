package com.rain.sparrow.system.bpmn.service.impl;

import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.system.bpmn.dao.TSBpmnDao;
import com.rain.sparrow.system.bpmn.dao.TSBpmnRepository;
import com.rain.sparrow.system.bpmn.dto.TSBpmnDto;
import com.rain.sparrow.system.bpmn.entity.TSBpmn;
import com.rain.sparrow.system.bpmn.service.TSBpmnService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional
public class TSBpmnServiceImpl implements TSBpmnService {

    @Autowired
    private TSBpmnDao tsBpmnDao;

    @Autowired
    private TSBpmnRepository tsBpmnRepository;

    @Override
    public RestResult searchBpmnList(HttpServletRequest request) {
        RestResult result = new RestResult();
        List<TSBpmn> list = tsBpmnRepository.findAll();
        result.setObject(list);
        return result;
    }

    @Override
    public void bpmnSave(TSBpmnDto dto) throws Exception {
        TSBpmn bpmn = new TSBpmn();
        BeanUtils.copyProperties(dto,bpmn);
        tsBpmnRepository.saveAndFlush(bpmn);
    }
}
