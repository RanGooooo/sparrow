package com.rain.sparrow.module.step.dao;

import com.rain.sparrow.module.step.bean.StepBean;
import com.rain.sparrow.module.step.dto.StepDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StepDao {


    List<StepBean> searchListData(StepDto dto);



}