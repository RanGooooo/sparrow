package com.rain.sparrow.module.step.service.impl;

import com.rain.sparrow.module.step.bean.StepBean;
import com.rain.sparrow.module.step.dao.StepDao;
import com.rain.sparrow.module.step.dto.StepDto;
import com.rain.sparrow.module.step.service.StepService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StepServiceImpl implements StepService {

    @Autowired
    private StepDao stepDao;

    @Override
    public List<StepDto> searchListData() {
        List<StepDto> result = new ArrayList<>();
        List<StepBean> list = stepDao.searchListData(new StepDto());
        for (StepBean bean : list){
            StepDto dto = new StepDto();
            BeanUtils.copyProperties(bean,dto);
            result.add(dto);
        }
        return result;
    }
}
