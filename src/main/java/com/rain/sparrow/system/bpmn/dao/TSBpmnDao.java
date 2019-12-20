package com.rain.sparrow.system.bpmn.dao;


import com.rain.sparrow.system.menu.entity.TSMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSBpmnDao {


    List<TSMenu> menuList();




}
