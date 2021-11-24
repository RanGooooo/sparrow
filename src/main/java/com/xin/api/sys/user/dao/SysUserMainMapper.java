package com.xin.api.sys.user.dao;

import com.xin.api.sys.user.dto.TSUserDto;
import com.xin.api.sys.user.entity.SysUserMain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMainMapper {


    List<SysUserMain> searchTSUserList(TSUserDto dto);


}
