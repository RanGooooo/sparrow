package com.xin.api.bus.fund.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xin.api.bus.fund.dto.BusFundMainDto;
import com.xin.api.bus.fund.entity.BusFundMain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusFundMainMapper extends BaseMapper<BusFundMain>{


    List<BusFundMain> searchTBFundMainList(@Param("mem") BusFundMainDto dto);


}
