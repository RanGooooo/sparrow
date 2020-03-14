package com.rain.sparrow.system.configure.dao;

import com.rain.sparrow.system.configure.entity.TSConfigure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TSConfigureRepository extends JpaRepository<TSConfigure,String>,CrudRepository<TSConfigure,String> {

    TSConfigure findTSConfigureById(String id);

}
