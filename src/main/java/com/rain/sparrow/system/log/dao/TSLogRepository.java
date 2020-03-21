package com.rain.sparrow.system.log.dao;

import com.rain.sparrow.system.log.entity.TSLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TSLogRepository extends JpaRepository<TSLog,String>,CrudRepository<TSLog,String> {

    TSLog findTSLogById(String id);

}
