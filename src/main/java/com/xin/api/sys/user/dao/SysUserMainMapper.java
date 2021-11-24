package com.xin.api.sys.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xin.api.sys.user.dto.SysUserMainDto;
import com.xin.api.sys.user.entity.SysUserMain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMainMapper extends BaseMapper<SysUserMain> {


    List<SysUserMain> searchTSUserList(SysUserMainDto dto);


}
