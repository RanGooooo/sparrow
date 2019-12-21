package com.rain.sparrow.database.table.service.impl;

import com.rain.sparrow.common.dto.RestResult;
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
public class DBTableServiceImpl implements DBTableService {

    @Autowired
    private DBTableDao dbTableDao;

    @Override
    public RestResult searchTableList(HttpServletRequest request) {
        RestResult result = new RestResult();
        List<DBTableDto> list = dbTableDao.searchTableList(DatabaseConstant.DATABASE_NAME);
        result.setObject(list);
        return result;
    }
}
