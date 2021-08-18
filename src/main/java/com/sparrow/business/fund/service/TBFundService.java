package com.sparrow.business.fund.service;

import com.sparrow.common.dto.RestResult;
import com.sparrow.business.fund.dto.TBFundDto;

import javax.servlet.http.HttpServletRequest;

public interface TBFundService {

    RestResult searchTBFundList(TBFundDto dto) throws Exception;

    void forwordTBFundSave(HttpServletRequest request) throws Exception;

    RestResult fundSave(TBFundDto dto) throws Exception;

    void fundDelete(HttpServletRequest request) throws Exception;

}
