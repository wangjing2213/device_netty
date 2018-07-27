package com.dearho.common.user.service;


import com.dearho.core.Page;
import com.dearho.core.config.service.IService;
import com.dearho.common.user.model.User;
import com.github.pagehelper.PageInfo;


public interface UserService extends IService<User> {

  
    PageInfo<User> selectByUser(User user, Page page);

}