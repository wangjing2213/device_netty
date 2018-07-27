package com.dearho.business.menu.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.dearho.core.validate.GroupAdd;
import com.dearho.core.validate.GroupUpdate;

@Table(name = "s_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "menu_name")
    @NotNull(message = "菜单名称不能为空", groups = {GroupAdd.class,GroupUpdate.class})  
    private String menuName;

    @Column(name = "menu_url")
    private String menuUrl;

    @Column(name = "menu_type")
    @NotNull(message = "菜单类型不能为空", groups = {GroupAdd.class,GroupUpdate.class}) 
    private String menuType;

    @Column(name = "menu_pid")
    @NotNull(message = "父菜单不能为空", groups = {GroupAdd.class,GroupUpdate.class}) 
    private Integer menuPid;

    @Column(name = "menu_order")
    private Integer menuOrder;

    private Date ts;

    

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
     * @return menu_name
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * @return menu_url
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * @param menuUrl
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    /**
     * @return menu_type
     */
    public String getMenuType() {
        return menuType;
    }

    /**
     * @param menuType
     */
    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    /**
     * @return menu_pid
     */
    public Integer getMenuPid() {
        return menuPid;
    }

    /**
     * @param menuPid
     */
    public void setMenuPid(Integer menuPid) {
        this.menuPid = menuPid;
    }

    /**
     * @return menu_order
     */
    public Integer getMenuOrder() {
        return menuOrder;
    }

    /**
     * @param menuOrder
     */
    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    /**
     * @return ts
     */
    public Date getTs() {
        return ts;
    }

    /**
     * @param ts
     */
    public void setTs(Date ts) {
        this.ts = ts;
    }
}