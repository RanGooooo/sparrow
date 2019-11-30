package com.rain.sparrow.system.menu.service.impl;

import com.rain.sparrow.system.menu.bean.TSMenu;
import com.rain.sparrow.system.menu.dao.TSMenuDao;
import com.rain.sparrow.system.menu.service.TSMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TSMenuServiceImpl implements TSMenuService{

    @Autowired
    private TSMenuDao tsMenuDao;



    public void saveData(TSMenu tsMenu){

        tsMenuDao.save(tsMenu);
    }



}
