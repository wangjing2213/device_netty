package com.dearho.business.menu.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import  com.dearho.business.menu.model.Menu;
import  com.dearho.business.menu.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("menuService")
public class MenuServiceImpl extends BaseService<Menu> implements MenuService {

    @Override
    public PageInfo<Menu> selectByMenu(Menu menu, Page page) {
        Example example = new Example(Menu.class);
        Example.Criteria criteria = example.createCriteria();

        if(menu!=null){
        	if(StringUtils.isNotEmpty(menu.getMenuName())) {
        		criteria.andLike("menuName", "%"+menu.getMenuName()+"%");
        	}
        	if(StringUtils.isNotEmpty(menu.getMenuUrl())) {
        		criteria.andLike("menuUrl", "%"+menu.getMenuUrl()+"%");
        	}
        	if(menu.getMenuPid()!=null) {
        		criteria.andEqualTo("menuPid", menu.getMenuPid());
        	}
        	if(StringUtils.isNotEmpty(menu.getMenuType())) {
        		criteria.andEqualTo("menuType", menu.getMenuType());
        	}
        	
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<Menu> menuList=selectByExample(example);
        PageInfo<Menu> pageInfo=  new PageInfo<Menu>(menuList);
       
        return pageInfo;
    }
    
    public List<Menu> selectByMenu(Menu menu){
    	 Example example = new Example(Menu.class);
         Example.Criteria criteria = example.createCriteria();

         if(menu!=null){
         	 if(StringUtils.isNotEmpty(menu.getMenuUrl())){
         		criteria.andEqualTo("menuUrl", menu.getMenuUrl());
         	 }
         	 if(menu.getMenuPid()!=null){
         		criteria.andEqualTo("menuPid", menu.getMenuPid());
         	 }
         	
         }
         
       
        
         //分页查询
         
         List<Menu> menuList=selectByExample(example);
        
         return menuList;
    }
}
