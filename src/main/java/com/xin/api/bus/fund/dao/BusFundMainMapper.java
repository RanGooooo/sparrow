package com.xin.api.bus.fund.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xin.api.bus.fund.dto.BusSearchFundMainListDto;
import com.xin.api.bus.fund.entity.BusFundMain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* 作者:  zhaohongyu
* 创建时间:  2021-11-22 14:05
*/
@Repository
public interface BusFundMainMapper extends BaseMapper<BusFundMain>{

    /**
    * 作者:  zhaohongyu
    * 创建时间:  2021-11-22 14:05
    */
    List<BusFundMain> searchTBFundMainList(@Param("mem") BusSearchFundMainListDto mem);


}
