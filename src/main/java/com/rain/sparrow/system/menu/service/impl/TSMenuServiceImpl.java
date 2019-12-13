package com.rain.sparrow.system.menu.service.impl;

import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.common.dto.TreeDto;
import com.rain.sparrow.system.menu.bean.TSMenu;
import com.rain.sparrow.system.menu.dao.TSMenuDao;
import com.rain.sparrow.system.menu.dao.TSMenuRepository;
import com.rain.sparrow.system.menu.service.TSMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TSMenuServiceImpl implements TSMenuService{

    @Autowired
    private TSMenuDao tsMenuDao;

    @Autowired
    private TSMenuRepository tsMenuRepository;

    @Override
    public void deleteMenu(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new Exception("删除菜单失败，主键为空");
        }
        tsMenuRepository.deleteById(id);
    }

    @Override
    public void editMenu(HttpServletRequest request) throws Exception{
        String id = request.getParameter("id");
        TSMenu tsMenu = new TSMenu();
        if(!StringUtils.isEmpty(id)){
            Optional<TSMenu> optional = tsMenuRepository.findById(id);
            tsMenu = optional.get();
        }

        tsMenu.setMenuName(request.getParameter("menuName"));
        tsMenu.setMenuIcon(request.getParameter("menuIcon"));
        tsMenu.setMenuUrl(request.getParameter("menuUrl"));
        tsMenu.setParentMenuId(request.getParameter("parentMenuId"));
        tsMenuRepository.save(tsMenu);
    }

    @Override
    public RestResult searchMenuTree(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        List<TSMenu> list = tsMenuDao.menuList();
        List<TreeDto> treeList = new ArrayList<>();
        for (TSMenu menu:list){
            TreeDto dto = new TreeDto();
            treeList.add(dto);
            dto.setId(menu.getId());
            dto.setName(menu.getMenuName());
            dto.setpId(menu.getParentMenuId());
        }
        result.setObject(treeList);
        return result;
    }

    @Override
    public RestResult searchMenuList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        List<TSMenu> list = tsMenuDao.menuList();
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordMenuAdd(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        Optional<TSMenu> optional = tsMenuRepository.findById(id);
        TSMenu menu = optional.get();
        request.setAttribute("menu",menu);
    }
}
