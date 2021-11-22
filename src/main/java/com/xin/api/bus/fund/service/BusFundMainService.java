package com.xin.api.bus.fund.service;

import com.xin.sparrow.common.dto.RestResult;
import com.xin.api.bus.fund.dto.BusFundMainDto;

import javax.servlet.http.HttpServletRequest;

public interface BusFundMainService {

    RestResult searchTBFundMainList(BusFundMainDto dto) throws Exception;

    void forwordTBFundSave(HttpServletRequest request) throws Exception;

    RestResult fundSave(BusFundMainDto dto) throws Exception;

    void fundDelete(HttpServletRequest request) throws Exception;

}
