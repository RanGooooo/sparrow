package com.rain.sparrow.system.menu.dao;


import com.rain.sparrow.system.menu.dto.TSMenuDto;
import com.rain.sparrow.system.menu.entity.TSMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSMenuDao{


    List<TSMenu> searchMenuList(TSMenuDto dto);


}
