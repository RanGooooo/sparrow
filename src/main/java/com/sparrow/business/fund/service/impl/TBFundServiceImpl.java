package com.sparrow.business.fund.service.impl;

import com.sparrow.common.dto.RestResult;
import com.sparrow.business.fund.dao.TBFundDao;
import com.sparrow.business.fund.dao.TBFundRepository;
import com.sparrow.business.fund.dto.TBFundDto;
import com.sparrow.business.fund.entity.TBFund;
import com.sparrow.business.fund.service.TBFundService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional
public class TBFundServiceImpl implements TBFundService {

    @Autowired
    private TBFundDao fundDao;

    @Autowired
    private TBFundRepository fundRepository;

    @Override
    public RestResult searchTBFundList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        TBFundDto dto = new TBFundDto();
        List<TBFund> list = fundDao.searchTBFundList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordTBFundSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        TBFund entity = fundRepository.findTBFundById(id);
        request.setAttribute("TBFund",entity);
    }

    @Override
    public void fundSave(TBFundDto dto) throws Exception{
        //TODO 判空代码 稍后添加
        String id = "";//dto.getId();
        TBFund entity = new TBFund();
        if(!StringUtils.isEmpty(id)){
            entity  = fundRepository.findTBFundById(id);
        }
        BeanUtils.copyProperties(dto,entity);
        fundRepository.save(entity);
    }

    @Override
    public void fundDelete(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new Exception("删除TBFund_ZH失败，主键为空");
        }
        fundRepository.deleteById(id);
    }






}
