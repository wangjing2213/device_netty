package com.dearho.business.menu.service;


import com.dearho.business.menu.model.Group;
import com.dearho.core.Page;
import com.dearho.core.config.service.BusinessService;
import com.github.pagehelper.PageInfo;


public interface GroupService extends BusinessService<Group> {

  
    PageInfo<Group> selectByGroup(Group group, Page page);

}