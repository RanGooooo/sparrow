package com.rain.sparrow.database.column.service.impl;

import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.database.column.dao.DBColumnDao;
import com.rain.sparrow.database.column.dto.DBColumnDto;
import com.rain.sparrow.database.column.service.DBColumnService;
import com.rain.sparrow.database.constant.DatabaseConstant;
import com.rain.sparrow.database.table.dao.DBTableDao;
import com.rain.sparrow.database.table.dto.DBTableDto;
import com.rain.sparrow.database.table.service.DBTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Service
@Transactional
public class DBColumnServiceImpl implements DBColumnService {

    @Autowired
    private DBColumnDao dbColumnDao;

    @Override
    public RestResult searchTableList(HttpServletRequest request) throws Exception{
        RestResult result = new RestResult();
        String tableName = request.getParameter("tableName");
        List<DBColumnDto> list = dbColumnDao.searchColumnList(DatabaseConstant.DATABASE_NAME,tableName);
        result.setObject(list);
        return result;
    }
}
