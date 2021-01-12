package com.sparrow.system.management.organization.user.dao;

import com.sparrow.system.management.organization.user.entity.TSUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TSUserRepository extends JpaRepository<TSUser,String>,CrudRepository<TSUser,String> {

    TSUser findTSUserById(String id);

}
