package com.rain.sparrow.control.code.service.impl;

import com.rain.sparrow.common.annotation.check.CheckData;
import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.control.code.service.THCodeService;
import com.rain.sparrow.control.code.service.sdk.Field;
import com.rain.sparrow.control.code.service.sdk.LiberateHand;
import com.rain.sparrow.control.code.dao.DBColumnDao;
import com.rain.sparrow.control.code.dto.DBColumnDto;
import com.rain.sparrow.control.code.constant.DatabaseConstant;
import com.rain.sparrow.control.code.dto.THCodeDto;
import com.rain.sparrow.control.code.dao.DBTableDao;
import com.rain.sparrow.control.code.dto.DBTableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class THCodeServiceImpl implements THCodeService {

    @Autowired
    private DBColumnDao columnDao;

    @Autowired
    private DBColumnDao dbColumnDao;

    @Autowired
    private DBTableDao dbTableDao;

    @Override
    public void codeSave(@CheckData THCodeDto dto) throws Exception {
        String table = dto.getTable();
        Map<String,String> map = columnDao.searchGroupConcatColumn(DatabaseConstant.DATABASE_NAME, table);
        Field field = new Field()
                .setColumns(map.get("columns"))
                .setComments(map.get("comments"))
                .setDatatypes(map.get("datatypes"));
        new LiberateHand()
                .setModel(dto.getModel())
                .setEntity(dto.getEntity())
                .setTable(dto.getTable())
                .setPackagePath(dto.getPackagePath())
                .setField(field)
                .build();
    }


    @Override
    public RestResult searchColumnList(HttpServletRequest request) throws Exception{
        RestResult result = new RestResult();
        String tableName = request.getParameter("tableName");
        List<DBColumnDto> list = dbColumnDao.searchColumnList(DatabaseConstant.DATABASE_NAME,tableName);
        result.setObject(list);
        return result;
    }


    @Override
    public RestResult searchTableList(HttpServletRequest request) {
        RestResult result = new RestResult();
        List<DBTableDto> list = dbTableDao.searchTableList(DatabaseConstant.DATABASE_NAME);
        result.setObject(list);
        return result;
    }

}
