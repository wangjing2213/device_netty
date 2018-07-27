package com.dearho.business.menu.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import  com.dearho.business.menu.model.UserGroup;
import  com.dearho.business.menu.service.UserGroupService;
import com.dearho.common.user.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("userGroupService")
public class UserGroupServiceImpl extends BaseService<UserGroup> implements UserGroupService {

    public List<UserGroup> selectByUserId(String userId) {
    	
    	
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        
        List<UserGroup> userList=selectByExample(example);
        return userList;
    }
}
