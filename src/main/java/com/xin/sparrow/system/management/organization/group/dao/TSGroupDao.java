package com.xin.sparrow.system.management.organization.group.dao;

import com.xin.sparrow.system.management.organization.group.dto.TSGroupDto;
import com.xin.sparrow.system.management.organization.group.entity.TSGroup;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TSGroupDao {


    List<TSGroup> searchTSGroupList(TSGroupDto dto);


    List<TSGroupDto> searchTSGroupTree(TSGroupDto dto);
}
