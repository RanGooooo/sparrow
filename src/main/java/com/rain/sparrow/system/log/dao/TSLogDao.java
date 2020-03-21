package com.rain.sparrow.system.log.dao;

import com.rain.sparrow.system.log.dto.TSLogDto;
import com.rain.sparrow.system.log.entity.TSLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSLogDao {


    List<TSLog> searchTSLogList(TSLogDto dto);


}
