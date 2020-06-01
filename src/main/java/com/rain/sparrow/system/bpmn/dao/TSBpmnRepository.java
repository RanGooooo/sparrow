package com.rain.sparrow.system.bpmn.dao;

import com.rain.sparrow.system.bpmn.entity.TSBpmn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TSBpmnRepository extends CrudRepository<TSBpmn,String>,JpaRepository<TSBpmn,String> {

}
