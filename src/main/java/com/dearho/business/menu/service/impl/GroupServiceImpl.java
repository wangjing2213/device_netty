package com.dearho.business.menu.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import  com.dearho.business.menu.model.Group;
import  com.dearho.business.menu.service.GroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("groupService")
public class GroupServiceImpl extends BaseService<Group> implements GroupService {

    @Override
    public PageInfo<Group> selectByGroup(Group group, Page page) {
        Example example = new Example(Group.class);
        Example.Criteria criteria = example.createCriteria();

        if(group!=null){
        	if (StringUtils.isNotEmpty(group.getGroupName())) {
                criteria.andLike("groupName", group.getGroupName());
            }
        	if (StringUtils.isNotEmpty(group.getGroupRemark())) {
                criteria.andLike("groupRemark", group.getGroupRemark());
            }
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<Group> groupList=selectByExample(example);
        PageInfo<Group> pageInfo=  new PageInfo<Group>(groupList);
       
        return pageInfo;
    }
}
