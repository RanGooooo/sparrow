package com.xin.api.bus.fund.controller;


import com.xin.api.bus.fund.dto.BusFundMainDto;
import com.xin.api.bus.fund.dto.BusSearchFundMainListDto;
import com.xin.api.bus.fund.dto.BusSearchFundMainListVo;
import com.xin.api.bus.fund.service.BusFundMainService;
import com.xin.sparrow.common.dto.DxResult;
import com.xin.sparrow.common.dto.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* 作者:  zhaohongyu
* 创建时间:  2021-11-22 13:55
*/
@RestController
@RequestMapping("busFundMainController")
public class BusFundMainController {

    @Autowired
    private BusFundMainService tbFundMainService;


    @RequestMapping("searchFundMainList")
    public DxResult<List<BusSearchFundMainListVo>> searchFundMainList(@RequestBody BusSearchFundMainListDto dto) {
        try {
            return tbFundMainService.searchFundMainList(dto);
        } catch (Exception e) {
            return DxResult.warning(e);
        }
    }


    @RequestMapping("saveTBFundMain")
    public RestResult saveTBFundMain(BusFundMainDto dto) {
        RestResult result = new RestResult();
        try {
            result = tbFundMainService.fundSave(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("deleteTBFundMain")
    public RestResult deleteTBFundMain(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            tbFundMainService.fundDelete(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setType(RestResult.MESSAGE_TYPE_WARNING);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
