package com.xin.sparrow.system.management.organization.role.dao;

import com.xin.sparrow.system.management.organization.role.dto.TSRoleDto;
import com.xin.api.sys.user.entity.TSRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSRoleDao {


    List<TSRole> searchTSRoleList(TSRoleDto dto);


}
