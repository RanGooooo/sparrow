package com.rain.sparrow.system.menu.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.rain.sparrow.common.dto.RestResult;
import com.rain.sparrow.common.dto.TreeDto;
import com.rain.sparrow.system.menu.constant.TSMenuConstant;
import com.rain.sparrow.system.menu.dto.TSMenuDto;
import com.rain.sparrow.system.menu.entity.TSMenu;
import com.rain.sparrow.system.menu.dao.TSMenuDao;
import com.rain.sparrow.system.menu.dao.TSMenuRepository;
import com.rain.sparrow.system.menu.service.TSMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void menuDelete(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new Exception("删除菜单失败，主键为空");
        }
        tsMenuRepository.deleteById(id);
    }


    @Override
    public void menuSave(TSMenuDto dto) throws Exception{
        String menuName = dto.getMenuName();
        String menuUrl = dto.getMenuUrl();
        Integer menuLevel = dto.getMenuLevel();
        Integer menuOrder = dto.getMenuOrder();
        String menuIcon = dto.getMenuIcon();
        if(StringUtils.isEmpty(menuName)||
            StringUtils.isEmpty(menuUrl)||
            StringUtils.isEmpty(menuLevel)||
            StringUtils.isEmpty(menuOrder)||
            StringUtils.isEmpty(menuIcon)){
            throw new Exception("参数为空");
        }
        String id = dto.getId();
        TSMenu menu = new TSMenu();
        if(!StringUtils.isEmpty(id)){
            Optional<TSMenu> optional = tsMenuRepository.findById(id);
            menu = optional.get();
        }
        BeanUtils.copyProperties(dto,menu);
        if(StringUtils.isEmpty(menu.getParentMenuId())){
            menu.setParentMenuId(TSMenuConstant.PARENT_MENU_TOP);
        }
        tsMenuRepository.save(menu);
    }

    @Override
    public RestResult searchTSMenuTree(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        TSMenuDto dto = new TSMenuDto();
        List<TSMenu> list = tsMenuDao.searchTSMenuList(dto);
        List<TreeDto> treeList = new ArrayList<>();
        for (TSMenu menu:list){
            TreeDto treeDto = new TreeDto();
            treeList.add(treeDto);
            treeDto.setId(menu.getId());
            treeDto.setName(menu.getMenuName());
            treeDto.setpId(menu.getParentMenuId());
        }
        result.setObject(treeList);
        return result;
    }

    @Override
    public RestResult searchTSMenuList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        String parentMenuId = request.getParameter("parentMenuId");
        TSMenuDto dto = new TSMenuDto();
        if(StringUtils.isEmpty(parentMenuId)){
            parentMenuId = "TOP";
        }
        dto.setParentMenuId(parentMenuId);

        List<TSMenu> list = tsMenuDao.searchTSMenuList(dto);
        result.setObject(list);
        return result;
    }


    @Override
    public RestResult searchMyTSMenuList(HttpServletRequest request) {
        RestResult result = new RestResult();
        TSMenuDto dto = new TSMenuDto();
        List<TSMenu> list = tsMenuDao.searchTSMenuList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordTSMenuSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtil.isNotEmpty(id)){
            Optional<TSMenu> optional = tsMenuRepository.findById(id);
            TSMenu menu = optional.get();
            if(menu != null){
                String parentMenuId = menu.getParentMenuId();
                TSMenu parentMenu = tsMenuRepository.findTSMenuById(parentMenuId);
                request.setAttribute("parentMenu",parentMenu);
            }
            request.setAttribute("menu",menu);
        }
    }
}
