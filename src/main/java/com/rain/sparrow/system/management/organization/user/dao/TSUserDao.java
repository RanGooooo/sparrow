package com.rain.sparrow.system.management.organization.user.dao;

import com.rain.sparrow.system.management.organization.user.dto.TSUserDto;
import com.rain.sparrow.system.management.organization.user.entity.TSUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSUserDao {


    List<TSUser> searchTSUserList(TSUserDto dto);


}
