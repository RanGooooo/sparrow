package com.sparrow.system.management.application.dao;

import com.sparrow.system.management.application.dto.TSApplicationDto;
import com.sparrow.system.management.application.entity.TSApplication;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSApplicationDao {


    List<TSApplication> searchTSApplicationList(TSApplicationDto dto);


}
