package com.rain.sparrow.control.code.dao;


import com.rain.sparrow.control.code.dto.DBTableDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DBTableDao {


    List<DBTableDto> searchTableList(String tableSchema);


}
