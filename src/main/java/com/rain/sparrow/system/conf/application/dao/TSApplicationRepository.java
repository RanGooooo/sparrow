package com.rain.sparrow.system.conf.application.dao;

import com.rain.sparrow.system.conf.application.entity.TSApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TSApplicationRepository extends JpaRepository<TSApplication,String>,CrudRepository<TSApplication,String> {

    TSApplication findTSApplicationById(String id);

}
