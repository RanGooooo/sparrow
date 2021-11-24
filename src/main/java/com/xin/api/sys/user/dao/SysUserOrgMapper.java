package com.xin.api.sys.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xin.api.sys.user.entity.SysUserOrg;
import com.xin.api.sys.user.dto.SysUserOrgDto;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SysUserOrgMapper extends BaseMapper<SysUserOrg> {


    List<SysUserOrg> searchTSGroupList(SysUserOrgDto dto);


    List<SysUserOrgDto> searchTSGroupTree(SysUserOrgDto dto);
}
