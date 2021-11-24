package com.xin.api.sys.user.dao;

import com.xin.api.sys.user.entity.SysUserOrg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TSGroupRepository extends JpaRepository<SysUserOrg,String>,CrudRepository<SysUserOrg,String> {

    SysUserOrg findTSGroupById(String id);

}
