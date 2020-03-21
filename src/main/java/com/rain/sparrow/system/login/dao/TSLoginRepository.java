package com.rain.sparrow.system.login.dao;

import com.rain.sparrow.system.menu.entity.TSMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TSLoginRepository extends JpaRepository<TSMenu,String>,CrudRepository<TSMenu,String> {

    TSMenu findTSMenuById(String id);

}
