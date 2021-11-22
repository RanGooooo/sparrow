package com.xin.api.bus.fund.dao;

import com.xin.api.bus.fund.entity.BusFundMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusFundMainRepository extends JpaRepository<BusFundMain,String>,CrudRepository<BusFundMain,String> {

    BusFundMain findTBFundMainById(String id);

    BusFundMain findTBFundMainByFundCode(String fundCode);

}
