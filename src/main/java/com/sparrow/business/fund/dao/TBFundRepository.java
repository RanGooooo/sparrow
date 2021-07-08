package com.sparrow.business.fund.dao;

import com.sparrow.business.fund.entity.TBFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TBFundRepository extends JpaRepository<TBFund,String>,CrudRepository<TBFund,String> {

    TBFund findTBFundById(String id);

}
