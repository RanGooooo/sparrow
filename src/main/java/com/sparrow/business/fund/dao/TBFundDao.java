package com.sparrow.business.fund.dao;

import com.sparrow.business.fund.dto.TBFundDto;
import com.sparrow.business.fund.entity.TBFund;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TBFundDao {


    List<TBFund> searchTBFundList(TBFundDto dto);


}
