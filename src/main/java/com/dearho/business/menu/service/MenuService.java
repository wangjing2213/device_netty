package com.dearho.business.menu.service;


import java.util.List;

import com.dearho.business.menu.model.Menu;
import com.dearho.core.Page;
import com.dearho.core.config.service.BusinessService;
import com.github.pagehelper.PageInfo;


public interface MenuService extends BusinessService<Menu> {

  
    PageInfo<Menu> selectByMenu(Menu menu, Page page);
    
    public List<Menu> selectByMenu(Menu menu);
}