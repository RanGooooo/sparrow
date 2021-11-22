package com.xin.api.bus.fund.service.impl;

import com.alibaba.fastjson.JSON;
import com.xin.api.bus.fund.dao.BusFundMainMapper;
import com.xin.api.bus.fund.dao.BusFundMainRepository;
import com.xin.api.bus.fund.dto.BusFundMainDto;
import com.xin.api.bus.fund.dto.EveryDayFundMainVo;
import com.xin.api.bus.fund.entity.BusFundMain;
import com.xin.api.bus.fund.service.BusFundMainService;
import com.xin.api.bus.fund.vo.TBFundVo;
import com.xin.sparrow.common.dto.RestResult;
import com.xin.sparrow.common.util.DecimalThreadLocalUtil;
import com.xin.sparrow.common.util.DxStringUtil;
import com.xin.sparrow.common.util.HttpClient4Utils;
import com.xin.sparrow.common.util.SystemBizLogUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BusFundMainServiceImpl implements BusFundMainService {

    @Value("${sparrow.ttjj.fundInfoUrl}")
    private String fundInfoUrl;


    @Autowired
    private BusFundMainMapper busFundMainMapper;

    @Autowired
    private BusFundMainRepository fundRepository;

    @Override
    public RestResult searchTBFundMainList(BusFundMainDto dto) throws Exception {
        RestResult result = new RestResult();
        List<BusFundMain> list = busFundMainMapper.searchTBFundMainList(dto);
        List<TBFundVo> fundVoList = new ArrayList<>();
        String currentTimeMillis = String.valueOf(System.currentTimeMillis());
        for (BusFundMain fund: list) {
            String fundCode = fund.getFundCode();
            BigDecimal fundShare = fund.getFundShare();
            TBFundVo fundVo = new TBFundVo();
            BeanUtils.copyProperties(fund,fundVo);
            String url = SystemBizLogUtil.setTemplateData(SystemBizLogUtil.put(fundCode),fundInfoUrl);
            String JSONP = HttpClient4Utils.httpGet(url, null,"UTF-8", 5);
            EveryDayFundMainVo everyDayFundMainVo = DxStringUtil.JSONPtoJSON(JSONP, EveryDayFundMainVo.class);
            if(everyDayFundMainVo!=null){
                fundVo.setFundNetWorth(everyDayFundMainVo.getDwjz());
                fundVo.setEstimateFundNetWorth(everyDayFundMainVo.getGsz());
                fundVo.setEstimateFundNetWorthFloatPercentage(everyDayFundMainVo.getGszzl());
                fundVo.setEstimateTime(everyDayFundMainVo.getGztime());
                fundVo.setFundNetWorthTime(everyDayFundMainVo.getJzrq());
            }
            fundVo.setFundShare(DecimalThreadLocalUtil.format_JING(fundShare));
            fundVoList.add(fundVo);
        }
        result.setObject(fundVoList);
        return result;
    }

    @Override
    public void forwordTBFundSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(!StringUtils.isEmpty(id)) {
            BusFundMain entity = fundRepository.findTBFundMainById(id);
            BusFundMainDto dto = new BusFundMainDto();
            BeanUtils.copyProperties(entity, dto);
            request.setAttribute("BusFundMain", JSON.toJSONString(dto));
        }
    }

    @Override
    public RestResult fundSave(BusFundMainDto dto) throws Exception{
        RestResult result = new RestResult();
//        String id = dto.getId();
        BusFundMain entity = new BusFundMain();
//        if(!StringUtils.isEmpty(id)){
//            entity  = fundRepository.findTBFundMainById(id);
//        }
        BeanUtils.copyProperties(dto,entity);
        fundRepository.save(entity);
//        dto.setId(entity.getId());
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
