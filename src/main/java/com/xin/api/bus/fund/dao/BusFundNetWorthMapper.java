package com.xin.api.bus.fund.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xin.api.bus.fund.dto.BusSearchFundNetWorthListDto;
import com.xin.api.bus.fund.dto.BusSearchFundNetWorthListVo;
import com.xin.api.bus.fund.entity.BusFundNetWorth;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 功能:
 * 作者: zhaohongyu
 * 创建时间: 2021-11-24 15:25
 */
@Repository
public interface BusFundNetWorthMapper extends BaseMapper<BusFundNetWorth> {


    /**
     * 作者:  zhaohongyu
     * 创建时间:  2021-11-22 11:43
     */
    @Select("searchMaxFundNetWorthTime")
    Date searchMaxFundNetWorthTime(@Param("fundCode") String fundCode);

    /**
     * 作者:  zhaohongyu
     * 创建时间:  2021-11-22 11:43
     */
    @Select("searchFundNetWorthList")
    List<BusSearchFundNetWorthListVo> searchFundNetWorthList(@Param("mem") BusSearchFundNetWorthListDto mem);

}
