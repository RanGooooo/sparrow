package com.rain.sparrow.system.management.application.dao;

import com.rain.sparrow.system.management.application.entity.TSApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSApplicationRepository extends JpaRepository<TSApplication,String>,CrudRepository<TSApplication,String> {

    TSApplication findTSApplicationById(String id);

    List<TSApplication> findTSApplicationByParentApplicationId(String id);

}
