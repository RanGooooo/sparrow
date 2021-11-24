package com.xin.api.sys.user.dao;

import com.xin.api.sys.user.entity.SysUserMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TSUserRepository extends JpaRepository<SysUserMain,String>,CrudRepository<SysUserMain,String> {

    SysUserMain findTSUserById(String id);

}
