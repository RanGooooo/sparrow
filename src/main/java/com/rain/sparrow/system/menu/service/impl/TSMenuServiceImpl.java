package com.rain.sparrow.system.menu.service.impl;

import com.rain.sparrow.system.menu.bean.TSMenu;
import com.rain.sparrow.system.menu.dao.TSMenuDao;
import com.rain.sparrow.system.menu.service.TSMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Service
@Transactional
public class TSMenuServiceImpl implements TSMenuService{

    @Autowired
    private TSMenuDao tsMenuDao;


    @Override
    public void menuAdd(HttpServletRequest request) throws Exception{
        String menuname = request.getParameter("menuName");
        if(!StringUtils.isEmpty(menuname)){
            TSMenu tsMenu = new TSMenu();
            tsMenu.setMenuName(request.getParameter("menuName"));
            tsMenu.setMenuIcon(request.getParameter("menuIcon"));
            tsMenuDao.save(tsMenu);
        }
    }

    public void saveData(TSMenu tsMenu){

    }



}
