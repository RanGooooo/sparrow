package com.sparrow.business.fund.service.impl;

import com.alibaba.fastjson.JSON;
import com.sparrow.business.fund.dao.TBFundDao;
import com.sparrow.business.fund.dao.TBFundRepository;
import com.sparrow.business.fund.dto.TBFundDto;
import com.sparrow.business.fund.entity.TBFund;
import com.sparrow.business.fund.service.TBFundService;
import com.sparrow.business.fund.vo.EastmoneyFundVo;
import com.sparrow.business.fund.vo.TBFundVo;
import com.sparrow.common.dto.RestResult;
import com.sparrow.common.util.DecimalThreadLocalUtil;
import com.sparrow.common.util.HttpClient4Utils;
import com.sparrow.common.util.StringUtil;
import com.sparrow.common.util.SystemBizLogUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TBFundServiceImpl implements TBFundService {

    @Value("${sparrow.fundinfo.url}")
    private String fundinfoUrl;

    @Autowired
    private TBFundDao fundDao;

    @Autowired
    private TBFundRepository fundRepository;

    @Override
    public RestResult searchTBFundList(TBFundDto dto) throws Exception {
        RestResult result = new RestResult();
        List<TBFund> list = fundDao.searchTBFundList(dto);
        List<TBFundVo> fundVoList = new ArrayList<>();
        String currentTimeMillis = String.valueOf(System.currentTimeMillis());
        for (TBFund fund: list) {
            TBFundVo fundVo = new TBFundVo();
            fundVoList.add(fundVo);
            BeanUtils.copyProperties(fund,fundVo);
            fundVo.setFundShare(DecimalThreadLocalUtil.format_JING(fund.getFundShare()));
            String url = SystemBizLogUtil.setTemplateData(SystemBizLogUtil.put(fund.getFundCode(), currentTimeMillis),fundinfoUrl);
            System.out.println(url);
            String JSONP = HttpClient4Utils.httpGet(url, null,"UTF-8", 5);
            System.err.println(JSONP);
            System.err.println(JSONP);
            EastmoneyFundVo eastmoneyFundVo = StringUtil.JSONPtoJSON(JSONP, EastmoneyFundVo.class);
            if(eastmoneyFundVo!=null){
                fundVo.setFundNetWorth(eastmoneyFundVo.getDwjz());
                fundVo.setEstimateFundNetWorth(eastmoneyFundVo.getGsz());
                fundVo.setEstimateFundNetWorthFloatPercentage(eastmoneyFundVo.getGszzl());
                fundVo.setEstimateTime(eastmoneyFundVo.getGztime());
                fundVo.setFundNetWorthTime(eastmoneyFundVo.getJzrq());
            }

        }
        result.setObject(fundVoList);
        return result;
    }

    @Override
    public void forwordTBFundSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(!StringUtils.isEmpty(id)) {
            TBFund entity = fundRepository.findTBFundById(id);
            TBFundDto dto = new TBFundDto();
            BeanUtils.copyProperties(entity, dto);
            request.setAttribute("TBFund", JSON.toJSONString(dto));
        }
    }

    @Override
    public RestResult fundSave(TBFundDto dto) throws Exception{
        RestResult result = new RestResult();
        String id = dto.getId();
        TBFund entity = new TBFund();
        if(!StringUtils.isEmpty(id)){
            entity  = fundRepository.findTBFundById(id);
        }
        BeanUtils.copyProperties(dto,entity);
        fundRepository.save(entity);
        dto.setId(entity.getId());
        result.setObject(dto);
        return result;
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
