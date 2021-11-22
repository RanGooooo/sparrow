package com.xin.api.bus.fund.service.impl;

import com.alibaba.fastjson.JSON;
import com.xin.api.bus.fund.dao.BusFundMainMapper;
import com.xin.api.bus.fund.dao.BusFundMainRepository;
import com.xin.api.bus.fund.dto.BusFundMainDto;
import com.xin.api.bus.fund.dto.BusSearchFundMainListDto;
import com.xin.api.bus.fund.dto.BusSearchFundMainListVo;
import com.xin.api.bus.fund.dto.EveryDayFundMainVo;
import com.xin.api.bus.fund.entity.BusFundMain;
import com.xin.api.bus.fund.service.BusFundMainService;
import com.xin.sparrow.common.dto.DxResult;
import com.xin.sparrow.common.dto.RestResult;
import com.xin.sparrow.common.exception.ExceptionMessageException;
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
    public DxResult<List<BusSearchFundMainListVo>> searchFundMainList(BusSearchFundMainListDto dto) throws Exception {
        List<BusFundMain> fundMainList = busFundMainMapper.searchTBFundMainList(dto);
        List<BusSearchFundMainListVo> resultList = new ArrayList<>();
        for (BusFundMain fundMain: fundMainList) {
            String fundCode = fundMain.getFundCode();
            BigDecimal fundShare = fundMain.getFundShare();
            BusSearchFundMainListVo result = new BusSearchFundMainListVo();
            BeanUtils.copyProperties(fundMain,result);
            EveryDayFundMainVo everyDayFundMainVo = getEveryDayFundMainVo(fundCode);
            if(everyDayFundMainVo!=null){
                result.setFundNetWorth(everyDayFundMainVo.getDwjz());
                result.setEstimateFundNetWorth(everyDayFundMainVo.getGsz());
                result.setEstimateFundNetWorthFloatRate(everyDayFundMainVo.getGszzl());
                result.setEstimateFundNetWorthTime(everyDayFundMainVo.getGztime());
                result.setFundNetWorthTime(everyDayFundMainVo.getJzrq());
            }
            result.setFundShare(DecimalThreadLocalUtil.format_JING(fundShare));
            resultList.add(result);
        }
        return DxResult.success(resultList);
    }

    @Override
    public EveryDayFundMainVo getEveryDayFundMainVo(String fundCode) throws ExceptionMessageException {
        String url = SystemBizLogUtil.setTemplateData(SystemBizLogUtil.put(fundCode),fundInfoUrl);
        String Jsonp = HttpClient4Utils.httpGet(url, null,"UTF-8", 5);
        return DxStringUtil.JsonpToJson(Jsonp, EveryDayFundMainVo.class);
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
