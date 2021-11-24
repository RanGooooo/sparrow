package com.xin.api.bus.fund.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xin.api.bus.fund.dao.BusFundNetWorthMapper;
import com.xin.api.bus.fund.dto.*;
import com.xin.api.bus.fund.dto.echarts.MarkArea;
import com.xin.api.bus.fund.dto.echarts.MarkAreaData;
import com.xin.api.bus.fund.dto.echarts.Option;
import com.xin.api.bus.fund.dto.echarts.Serie;
import com.xin.api.bus.fund.entity.BusFundNetWorth;
import com.xin.api.bus.fund.service.BusFundMainService;
import com.xin.api.bus.fund.service.BusFundNetWorthService;
import com.xin.api.sys.inter.mail.service.SysMailMainService;
import com.xin.common.util.DxDecimalThreadLocalUtil;
import com.xin.common.util.DxTimeThreadLocalUtil;
import com.xin.common.util.DxTimeUtil;
import com.xin.common.util.DxUuidUtil;
import com.xin.sparrow.common.dto.DxResult;
import com.xin.sparrow.common.util.HttpClient4Utils;
import com.xin.sparrow.common.util.SystemBizLogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
* 作者:  zhaohongyu
* 创建时间:  2021-11-18 17:07
*/
@Service
@Transactional
public class BusFundNetWorthServiceImpl implements BusFundNetWorthService {

    @Value("${sparrow.ttjj.fundNetWorthRecordUrl}")
    private String fundNetWorthRecordUrl;

    @Autowired
    private BusFundMainService busFundMainService;

    @Autowired
    private BusFundNetWorthMapper busFundNetWorthMapper;

    @Autowired
    private SysMailMainService sysMailMainService;


    @Override
    public DxResult<BusSearchFundNetWorthReportVo> searchFundNetWorthReport(BusSearchFundNetWorthReportDto dto) throws Exception {
        String fundCode = dto.getFundCode();
        Integer dayNumber = dto.getDayNumber();
        this.pullEveryDayInsertFundNetWorthList(fundCode);

        BusSearchFundNetWorthListDto mem = new BusSearchFundNetWorthListDto();
        mem.setFundCode(fundCode);
        mem.setFundNetWorthTimeBegin(DxTimeUtil.subtractAppointDate(dayNumber));
        List<BusSearchFundNetWorthListVo> fundNetWorthList = busFundNetWorthMapper.searchFundNetWorthList(mem);
        sysMailMainService.sendSimpleMail("395994875@qq.common","1","1");
        return DxResult.success(this.assembleFundNetWorthRecordEchartsOption(fundCode,fundNetWorthList));
    }


    private void insertFundNetWorth(String fundCode, String fsrq, String ljjz) throws Exception {
        BusFundNetWorth busFundNetWorth = new BusFundNetWorth();
        busFundNetWorth.setId(DxUuidUtil.getUUID());
        busFundNetWorth.setFundCode(fundCode);
        busFundNetWorth.setFundNetWorth(new BigDecimal(ljjz));
        busFundNetWorth.setFundNetWorthTime(DxTimeThreadLocalUtil.parseDate(fsrq));
        busFundNetWorth.setCreateTime(new Date());
        busFundNetWorthMapper.insert(busFundNetWorth);
    }

    public static void main(String[] args) {
        String url = "http://api.fund.eastmoney.com/f10/lsjz?fundCode=004224&pageIndex=1&pageSize=10000";
        Map<String, String> headers = new HashMap<>();
        headers.put("Referer","http://fundf10.eastmoney.com/");
        String json = HttpClient4Utils.httpGet(url, null, headers, "UTF-8",5000);
        System.out.println(json);
    }

    private void pullEveryDayInsertFundNetWorthList(String fundCode) throws Exception {
        String url = SystemBizLogUtil.setTemplateData(SystemBizLogUtil.put(fundCode, String.valueOf(1),String.valueOf(10000)),fundNetWorthRecordUrl);
        Map<String, String> headers = new HashMap<>();
        headers.put("Referer","http://fundf10.eastmoney.com/");
        String json = HttpClient4Utils.httpGet(url, null, headers, "UTF-8",5000);
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject Data = jsonObject.getJSONObject("Data");
        JSONArray LSJZList = Data.getJSONArray("LSJZList");
        List<EveryDayFundNetWorthVo> everyDayFundNetWorthList = JSON.parseArray(LSJZList.toJSONString(), EveryDayFundNetWorthVo.class);
        System.out.println("fundCode:" + fundCode + ",size:" + everyDayFundNetWorthList.size());
        System.out.println("fundCode:" + fundCode + ",size:" + everyDayFundNetWorthList.size());
        System.out.println("fundCode:" + fundCode + ",size:" + everyDayFundNetWorthList.size());
        Date lastFundNetWorthTime = busFundNetWorthMapper.searchMaxFundNetWorthTime(fundCode);
        for (EveryDayFundNetWorthVo everyDayFundNetWorth :everyDayFundNetWorthList) {
            String fsrq = everyDayFundNetWorth.getFSRQ();
            String ljjz = everyDayFundNetWorth.getLJJZ();
            if(lastFundNetWorthTime != null){
                if(!DxTimeThreadLocalUtil.parseDate(fsrq).after(lastFundNetWorthTime)){
                    break;
                }
                insertFundNetWorth(fundCode, fsrq, ljjz);
            }else{
                insertFundNetWorth(fundCode, fsrq, ljjz);
            }
        }
    }


    private BusSearchFundNetWorthReportVo assembleFundNetWorthRecordEchartsOption(String fundCode, List<BusSearchFundNetWorthListVo> busFundNetWorthList) throws Exception {
        Option option = new Option();
        /* 组织类别 */
        Set<String> categoryNameSet = new HashSet<>();
        categoryNameSet.add(fundCode);
        Map<String, BigDecimal> countMap = new HashMap<>();
        List<String> dateList = new ArrayList<>();
        BigDecimal newFundNetWorth = null;
        String newFundNetWorthTime = null;
        BigDecimal maxFundNetWorth= null;
        String maxFundNetWorthTime= null;
        for (BusSearchFundNetWorthListVo busFundNetWorth : busFundNetWorthList) {
            BigDecimal fundNetWorth = busFundNetWorth.getFundNetWorth();
            String fundNetWorthTime = DxTimeThreadLocalUtil.formatDate(busFundNetWorth.getFundNetWorthTime());
            if(maxFundNetWorth==null){
                maxFundNetWorth = fundNetWorth;
            } else {
                if (fundNetWorth.compareTo(maxFundNetWorth)==1) {
                    maxFundNetWorth = fundNetWorth;
                    maxFundNetWorthTime = fundNetWorthTime;
                }
            }
            countMap.put(fundCode + fundNetWorthTime,fundNetWorth);
            dateList.add(fundNetWorthTime);
            newFundNetWorthTime = fundNetWorthTime;
            newFundNetWorth = fundNetWorth;
        }
        //设置参数中线条的分类
        option.getLegend().setData(new ArrayList<>(categoryNameSet));
        //设置X轴坐标
        option.getxAxis().setData(dateList);
        //组织每条线上的数据集合，集合元素serie
        for(String categoryName : categoryNameSet){
            Serie serie = new Serie();
            MarkArea markArea = new MarkArea();
            serie.setMarkArea(markArea);
            List<List<MarkAreaData>> data = new ArrayList<>();
            List<MarkAreaData> markAreaDataList = new ArrayList<>();
            data.add(markAreaDataList);
            markAreaDataList.add(new MarkAreaData("",maxFundNetWorthTime));
            markAreaDataList.add(new MarkAreaData(null,newFundNetWorthTime));
            markArea.setData(data);
            option.getSeries().add(serie);
            serie.setName(categoryName);
            serie.setType("line");
            for (String date : dateList) {
                serie.getData().add(countMap.get(categoryName + date) == null ? new BigDecimal(0) : countMap.get(categoryName + date));
            }
        }
        BusSearchFundNetWorthReportVo result = new BusSearchFundNetWorthReportVo();
        BusSearchFundNetWorthReportVoData resultData = new BusSearchFundNetWorthReportVoData();
        result.setData(resultData);
        result.setOption(option);
        BigDecimal subtract = maxFundNetWorth.subtract(newFundNetWorth);
        BigDecimal divide = subtract.divide(maxFundNetWorth,6, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
        resultData.setFundNetWorthFloat(DxDecimalThreadLocalUtil.replaceTailZero(subtract));
        resultData.setFundNetWorthFloatRate(DxDecimalThreadLocalUtil.replaceTailZero(divide) + "%");
        resultData.setMaxFundNetWorth(DxDecimalThreadLocalUtil.replaceTailZero(maxFundNetWorth));
        resultData.setMaxFundNetWorthTime(maxFundNetWorthTime);
        resultData.setNewFundNetWorth(DxDecimalThreadLocalUtil.replaceTailZero(newFundNetWorth));
        resultData.setNewFundNetWorthTime(newFundNetWorthTime);
        EveryDayFundMainVo everyDayFundMainVo = busFundMainService.getEveryDayFundMainVo(fundCode);
        resultData.setEstimateFundNetWorth(everyDayFundMainVo.getGsz());
        resultData.setEstimateFundNetWorthFloatRate(everyDayFundMainVo.getGszzl() + "%");
        resultData.setEstimateFundNetWorthTime(everyDayFundMainVo.getGztime());
        return result;
    }

}
