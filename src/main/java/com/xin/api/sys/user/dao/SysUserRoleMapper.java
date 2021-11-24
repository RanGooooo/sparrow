package com.xin.api.sys.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xin.api.sys.user.entity.SysUserRole;
import com.xin.api.sys.user.dto.SysUserRoleDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {


    List<SysUserRole> searchTSRoleList(SysUserRoleDto dto);


}
