package com.rain.sparrow.database.table.dao;


import com.rain.sparrow.database.table.dto.DBTableDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DBTableDao {


    List<DBTableDto> searchTableList(String tableSchema);


}
