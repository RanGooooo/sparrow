package com.sparrow.system.management.organization.role.dao;

import com.sparrow.system.management.organization.role.dto.TSRoleDto;
import com.sparrow.system.management.organization.role.entity.TSRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSRoleDao {


    List<TSRole> searchTSRoleList(TSRoleDto dto);


}
