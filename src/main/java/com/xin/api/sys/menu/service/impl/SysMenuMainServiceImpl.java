package com.xin.api.sys.menu.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xin.api.sys.menu.entity.SysMenuMain;
import com.xin.sparrow.common.annotation.check.CheckData;
import com.xin.sparrow.common.constant.status.RunningStateConstant;
import com.xin.sparrow.common.dto.DxResult;
import com.xin.sparrow.common.dto.RestResult;
import com.xin.sparrow.common.dto.TreeDto;
import com.xin.api.sys.menu.constant.SysMenuMainConstant;
import com.xin.api.sys.menu.dao.SysMenuMainMapper;
import com.xin.api.sys.menu.dto.SysMenuMainDto;
import com.xin.api.sys.menu.service.SysMenuMainService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SysMenuMainServiceImpl implements SysMenuMainService {

    @Autowired
    private SysMenuMainMapper sysMenuMainMapper;

    @Override
    public DxResult<List<SysMenuMain>> searchMyTSMenuNameList(SysMenuMainDto dto) throws Exception {
        return DxResult.success(sysMenuMainMapper.searchTSMenuNameList(dto));
    }

    @Override
    public RestResult searchTSMenuNameList(SysMenuMainDto dto) throws Exception {
        RestResult result = new RestResult();
        String parentMenuNameId = dto.getParentMenuId();
        String runningState = dto.getRunningState();
        String menuName = dto.getMenuName();
        if(StringUtils.isEmpty(parentMenuNameId)&&
            StringUtils.isEmpty(runningState)&&
            StringUtils.isEmpty(menuName)){
            dto.setParentMenuId(SysMenuMainConstant.PARENT_APPLICATION_ID_TOP);
        }
        List<SysMenuMain> list = sysMenuMainMapper.searchTSMenuNameList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordTSMenuNameSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(!StringUtils.isEmpty(id)){
            SysMenuMain entity = sysMenuMainMapper.selectById(id);
            SysMenuMainDto dto = new SysMenuMainDto();
            BeanUtils.copyProperties(entity,dto);
            String parentMenuNameId = entity.getParentMenuId();
            SysMenuMain parentTSMenuName = sysMenuMainMapper.selectById(parentMenuNameId);
            if(!StringUtils.isEmpty(parentTSMenuName)){
                dto.setParentMenuName(parentTSMenuName.getMenuName());
            }
            request.setAttribute("SysMenuMain", JSON.toJSONString(dto));
        }
    }

    @Override
    public RestResult menuSave(@CheckData SysMenuMainDto dto) throws Exception{
        RestResult result = new RestResult();
        String id = dto.getId();
        SysMenuMain entity = new SysMenuMain();
        String parentMenuNameId = dto.getParentMenuId();
        if(StringUtils.isEmpty(parentMenuNameId)){
            dto.setParentMenuId(SysMenuMainConstant.PARENT_APPLICATION_ID_TOP);
        }else{
            SysMenuMain parentMenuName = sysMenuMainMapper.selectById(parentMenuNameId);
            if(parentMenuName!=null){
                parentMenuName.setPosition(SysMenuMainConstant.POSITION_TRUE);
                sysMenuMainMapper.insert(parentMenuName);
            }
        }
        if(!StringUtils.isEmpty(id)){
            entity  = sysMenuMainMapper.selectById(id);
        }else{
            dto.setRunningState(RunningStateConstant.RUNNING_STATE_00);
        }
        BeanUtils.copyProperties(dto,entity);
        sysMenuMainMapper.insert(entity);
        dto.setId(entity.getId());
        result.setObject(dto);
        return result;
    }

    @Override
    public void menuDelete(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new Exception("删除失败，主键为空");
        }
        SysMenuMain entity = sysMenuMainMapper.selectById(id);
        List<SysMenuMain> menuList1 = sysMenuMainMapper.selectList(
                new QueryWrapper<SysMenuMain>().eq("parent_menu_id",id));
        if(menuList1.size()>0){
            throw new Exception("存在子应用");
        }
        String parentMenuNameId = entity.getParentMenuId();
        List<SysMenuMain> menuList = sysMenuMainMapper.selectList(
                new QueryWrapper<SysMenuMain>().eq("parent_menu_id",parentMenuNameId));
        if(menuList.size()==1){
            SysMenuMain parent = sysMenuMainMapper.selectById(parentMenuNameId);
            parent.setPosition(SysMenuMainConstant.POSITION_FALSE);
            sysMenuMainMapper.insert(parent);
        }
        sysMenuMainMapper.deleteById(id);
    }

    @Override
    public RestResult searchTSMenuNameTree(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        SysMenuMainDto dto = new SysMenuMainDto();
        List<SysMenuMain> list = sysMenuMainMapper.searchTSMenuNameList(dto);
        List<TreeDto> treeList = new ArrayList<>();
        for (SysMenuMain menu:list){
            TreeDto treeDto = new TreeDto();
            treeList.add(treeDto);
            treeDto.setId(menu.getId());
            treeDto.setName(menu.getMenuName());
            treeDto.setpId(menu.getParentMenuId());
        }
        result.setObject(treeList);
        return result;
    }
}
