package com.rain.sparrow.system.menu.dao;

import com.rain.sparrow.system.menu.bean.TSMenu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TSMenuRepository extends CrudRepository<TSMenu,String> {

}
