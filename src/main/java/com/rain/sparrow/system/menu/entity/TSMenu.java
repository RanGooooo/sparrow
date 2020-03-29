package com.rain.sparrow.system.menu.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;



@Entity
@Table(name = "t_s_menu")
@Alias(value = "TSMenu")
public class TSMenu {

    /**主键*/
    private String id;
    /**菜单名称*/
    private String menuName;
    /**菜单地址*/
    private String menuUrl;
    /**菜单等级*/
    private Integer menuLevel;
    /**菜单排序*/
    private Integer menuOrder;
    /**菜单图标*/
    private String menuIcon;
    /**父菜单id*/
    private String parentMenuId;
    /**[00 树枝]，[01 叶子]*/
    private String position;

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name ="ID",nullable=false,length=36)
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
    @Column(name ="position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
