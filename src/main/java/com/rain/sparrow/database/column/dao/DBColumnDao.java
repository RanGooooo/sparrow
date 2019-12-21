package com.rain.sparrow.database.column.dao;


import com.rain.sparrow.database.column.dto.DBColumnDto;
import com.rain.sparrow.database.table.dto.DBTableDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DBColumnDao {


    List<DBColumnDto> searchColumnList(@Param("tableSchema") String tableSchema, @Param("tableName")String tableName);

}
