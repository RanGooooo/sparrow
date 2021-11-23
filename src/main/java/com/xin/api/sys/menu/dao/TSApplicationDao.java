package com.xin.api.sys.menu.dao;

import com.xin.api.sys.menu.dto.TSApplicationDto;
import com.xin.api.sys.menu.entity.SysMenuMain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSApplicationDao {


    List<SysMenuMain> searchTSApplicationList(TSApplicationDto dto);


}
