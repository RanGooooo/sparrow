package com.xin.api.bus.fund.service;

import com.xin.api.bus.fund.dto.BusFundMainDto;
import com.xin.api.bus.fund.dto.BusSearchFundMainListDto;
import com.xin.api.bus.fund.dto.BusSearchFundMainListVo;
import com.xin.api.bus.fund.dto.EveryDayFundMainVo;
import com.xin.sparrow.common.dto.DxResult;
import com.xin.sparrow.common.dto.RestResult;
import com.xin.sparrow.common.exception.ExceptionMessageException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* 作者:  zhaohongyu
* 创建时间:  2021-11-22 14:16
*/
public interface BusFundMainService {

    /**
    * 作者:  zhaohongyu
    * 创建时间:  2021-11-22 14:16
    */
    DxResult<List<BusSearchFundMainListVo>> searchFundMainList(BusSearchFundMainListDto dto) throws Exception;

    /**
    * 作者:  zhaohongyu
    * 创建时间:  2021-11-22 14:16
    */
    EveryDayFundMainVo getEveryDayFundMainVo(String fundCode) throws ExceptionMessageException;

    void forwordTBFundSave(HttpServletRequest request) throws Exception;

    RestResult fundSave(BusFundMainDto dto) throws Exception;

    void fundDelete(HttpServletRequest request) throws Exception;

}
