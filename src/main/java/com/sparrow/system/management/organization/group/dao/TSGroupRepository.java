package com.sparrow.system.management.organization.group.dao;

import com.sparrow.system.management.organization.group.entity.TSGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TSGroupRepository extends JpaRepository<TSGroup,String>,CrudRepository<TSGroup,String> {

    TSGroup findTSGroupById(String id);

}
