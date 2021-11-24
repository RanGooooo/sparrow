package com.xin.api.sys.user.dao;

import com.xin.api.sys.user.entity.SysUserOrg;
import com.xin.sparrow.system.management.organization.group.dto.TSGroupDto;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SysUserOrgMapper {


    List<SysUserOrg> searchTSGroupList(TSGroupDto dto);


    List<TSGroupDto> searchTSGroupTree(TSGroupDto dto);
}
