package com.rain.sparrow.system.group.dao;

import com.rain.sparrow.system.group.dto.TSGroupDto;
import com.rain.sparrow.system.group.entity.TSGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSGroupDao {


    List<TSGroup> searchTSGroupList(TSGroupDto dto);


}
