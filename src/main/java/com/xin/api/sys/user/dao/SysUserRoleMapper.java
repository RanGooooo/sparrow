package com.xin.api.sys.user.dao;

import com.xin.api.sys.user.entity.SysUserRole;
import com.xin.sparrow.system.management.organization.role.dto.TSRoleDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRoleMapper {


    List<SysUserRole> searchTSRoleList(TSRoleDto dto);


}
