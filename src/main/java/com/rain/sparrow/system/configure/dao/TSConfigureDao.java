package com.rain.sparrow.system.configure.dao;

import com.rain.sparrow.system.configure.dto.TSConfigureDto;
import com.rain.sparrow.system.configure.entity.TSConfigure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSConfigureDao {


    List<TSConfigure> searchTSConfigureList(TSConfigureDto dto);


}
