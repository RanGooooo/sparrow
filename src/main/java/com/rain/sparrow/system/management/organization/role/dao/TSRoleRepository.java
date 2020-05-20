package com.rain.sparrow.system.management.organization.role.dao;

import com.rain.sparrow.system.management.organization.role.entity.TSRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TSRoleRepository extends JpaRepository<TSRole,String>,CrudRepository<TSRole,String> {

    TSRole findTSRoleById(String id);

}
