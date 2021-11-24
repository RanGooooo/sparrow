package com.xin.api.sys.user.dao;

import com.xin.api.sys.user.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TSRoleRepository extends JpaRepository<SysUserRole,String>,CrudRepository<SysUserRole,String> {

    SysUserRole findTSRoleById(String id);

}
