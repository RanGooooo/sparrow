package com.rain.sparrow.control.code.dao;


import com.rain.sparrow.control.code.dto.DBColumnDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DBColumnDao {


    List<DBColumnDto> searchColumnList(@Param("tableSchema") String tableSchema, @Param("tableName")String tableName);


    Map<String,String> searchGroupConcatColumn(@Param("tableSchema") String tableSchema, @Param("tableName")String tableName);


}
