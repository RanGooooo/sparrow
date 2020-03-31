package com.rain.sparrow.system.conf.application.dao;

import com.rain.sparrow.system.conf.application.dto.TSApplicationDto;
import com.rain.sparrow.system.conf.application.entity.TSApplication;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSApplicationDao {


    List<TSApplication> searchTSApplicationList(TSApplicationDto dto);


}
