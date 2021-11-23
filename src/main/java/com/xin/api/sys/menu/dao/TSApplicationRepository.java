package com.xin.api.sys.menu.dao;

import com.xin.api.sys.menu.entity.SysMenuMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSApplicationRepository extends JpaRepository<SysMenuMain,String>,CrudRepository<SysMenuMain,String> {

    SysMenuMain findTSApplicationById(String id);

    List<SysMenuMain> findTSApplicationByParentApplicationId(String id);

}
