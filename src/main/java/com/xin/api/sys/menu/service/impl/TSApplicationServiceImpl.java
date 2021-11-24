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
import com.xin.api.sys.menu.dto.TSApplicationDto;
import com.xin.api.sys.menu.service.TSApplicationService;
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
public class TSApplicationServiceImpl implements TSApplicationService {

    @Autowired
    private SysMenuMainMapper sysMenuMainMapper;

    @Override
    public DxResult<List<SysMenuMain>> searchMyTSApplicationList(TSApplicationDto dto) throws Exception {
        return DxResult.success(sysMenuMainMapper.searchTSApplicationList(dto));
    }

    @Override
    public RestResult searchTSApplicationList(TSApplicationDto dto) throws Exception {
        RestResult result = new RestResult();
        String parentApplicationId = dto.getParentApplicationId();
        String runningState = dto.getRunningState();
        String applicationName = dto.getApplicationName();
        if(StringUtils.isEmpty(parentApplicationId)&&
            StringUtils.isEmpty(runningState)&&
            StringUtils.isEmpty(applicationName)){
            dto.setParentApplicationId(SysMenuMainConstant.PARENT_APPLICATION_ID_TOP);
        }
        List<SysMenuMain> list = sysMenuMainMapper.searchTSApplicationList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordTSApplicationSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(!StringUtils.isEmpty(id)){
            SysMenuMain entity = sysMenuMainMapper.selectById(id);
            TSApplicationDto dto = new TSApplicationDto();
            BeanUtils.copyProperties(entity,dto);
            String parentApplicationId = entity.getParentApplicationId();
            SysMenuMain parentTSApplication = sysMenuMainMapper.selectById(parentApplicationId);
            if(!StringUtils.isEmpty(parentTSApplication)){
                dto.setParentApplicationName(parentTSApplication.getApplicationName());
            }
            request.setAttribute("SysMenuMain", JSON.toJSONString(dto));
        }
    }

    @Override
    public RestResult applicationSave(@CheckData TSApplicationDto dto) throws Exception{
        RestResult result = new RestResult();
        String id = dto.getId();
        SysMenuMain entity = new SysMenuMain();
        String parentApplicationId = dto.getParentApplicationId();
        if(StringUtils.isEmpty(parentApplicationId)){
            dto.setParentApplicationId(SysMenuMainConstant.PARENT_APPLICATION_ID_TOP);
        }else{
            SysMenuMain parentApplication = sysMenuMainMapper.selectById(parentApplicationId);
            if(parentApplication!=null){
                parentApplication.setPosition(SysMenuMainConstant.POSITION_TRUE);
                sysMenuMainMapper.insert(parentApplication);
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
    public void applicationDelete(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new Exception("删除失败，主键为空");
        }
        SysMenuMain entity = sysMenuMainMapper.selectById(id);
        List<SysMenuMain> applicationList1 = sysMenuMainMapper.selectList(
                new QueryWrapper<SysMenuMain>().eq("parent_application_id",id));
        if(applicationList1.size()>0){
            throw new Exception("存在子应用");
        }
        String parentApplicationId = entity.getParentApplicationId();
        List<SysMenuMain> applicationList = sysMenuMainMapper.selectList(
                new QueryWrapper<SysMenuMain>().eq("parent_application_id",parentApplicationId));
        if(applicationList.size()==1){
            SysMenuMain parent = sysMenuMainMapper.selectById(parentApplicationId);
            parent.setPosition(SysMenuMainConstant.POSITION_FALSE);
            sysMenuMainMapper.insert(parent);
        }
        sysMenuMainMapper.deleteById(id);
    }

    @Override
    public RestResult searchTSApplicationTree(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        TSApplicationDto dto = new TSApplicationDto();
        List<SysMenuMain> list = sysMenuMainMapper.searchTSApplicationList(dto);
        List<TreeDto> treeList = new ArrayList<>();
        for (SysMenuMain application:list){
            TreeDto treeDto = new TreeDto();
            treeList.add(treeDto);
            treeDto.setId(application.getId());
            treeDto.setName(application.getApplicationName());
            treeDto.setpId(application.getParentApplicationId());
        }
        result.setObject(treeList);
        return result;
    }
}
