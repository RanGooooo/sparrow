package com.rain.sparrow.system.menu.bean;

import org.apache.ibatis.type.Alias;

import javax.persistence.*;


@Alias(value = "TSMenu")
@Entity
@Table(name = "t_s_menu")
public class TSMenu {

    private String id;

    private String menuName;

    private String menuUrl;

    private Integer menuLevel;

    private Integer menuOrder;

    private String menuIcon;

    private String parentMenuId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Column(name ="menu_name")
    public String getMenuName() {
        return menuName;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    @Column(name ="menu_url")
    public String getMenuUrl() {
        return menuUrl;
    }
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
    @Column(name ="menu_level")
    public Integer getMenuLevel() {
        return menuLevel;
    }
    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }
    @Column(name ="menu_order")
    public Integer getMenuOrder() {
        return menuOrder;
    }
    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }
    @Column(name ="menu_icon")
    public String getMenuIcon() {
        return menuIcon;
    }
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }
    @Column(name ="parent_menu_id")
    public String getParentMenuId() {
        return parentMenuId;
    }
    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
    }



}
