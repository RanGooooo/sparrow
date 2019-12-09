package com.rain.sparrow.system.menu.dao;


import com.rain.sparrow.module.step.bean.StepBean;
import com.rain.sparrow.module.step.dto.StepDto;
import com.rain.sparrow.system.menu.bean.TSMenu;
import com.rain.sparrow.system.menu.dto.TSMenuDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSMenuDao{


    List<TSMenu> menuList();




}
