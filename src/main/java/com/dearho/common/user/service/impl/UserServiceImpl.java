package com.dearho.common.user.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import  com.dearho.common.user.model.User;
import  com.dearho.common.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Override
    public PageInfo<User> selectByUser(User user, Page page) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        if(user!=null){
        	if (user.getId() != null) {
                criteria.andEqualTo("id", user.getId());
            }
        	
        	if(user.getCompanyId()!=null){
        		criteria.andEqualTo("companyId", user.getCompanyId());
        	}
        	if(StringUtils.isNotEmpty(user.getCompanySn())){
        		criteria.andLike("companySn", user.getCompanySn()+"%");
        	}
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<User> userList=selectByExample(example);
        PageInfo<User> pageInfo=  new PageInfo<User>(userList);
       
        return pageInfo;
    }
}
