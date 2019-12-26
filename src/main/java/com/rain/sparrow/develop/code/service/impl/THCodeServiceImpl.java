package com.rain.sparrow.develop.code.service.impl;

import com.rain.sparrow.common.annotation.check.CheckData;
import com.rain.sparrow.database.column.dao.DBColumnDao;
import com.rain.sparrow.database.constant.DatabaseConstant;
import com.rain.sparrow.develop.code.dto.THCodeDto;
import com.rain.sparrow.develop.code.service.THCodeService;
import com.rain.sparrow.develop.code.service.sdk.Field;
import com.rain.sparrow.develop.code.service.sdk.LiberateHand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class THCodeServiceImpl implements THCodeService {

    @Autowired
    private DBColumnDao columnDao;

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
}
