package com.dearho.common.device.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import  com.dearho.common.device.model.Fence;
import  com.dearho.common.device.service.FenceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("fenceService")
public class FenceServiceImpl extends BaseService<Fence> implements FenceService {

    @Override
    public PageInfo<Fence> selectByFence(Fence fence, Page page) {
        Example example = new Example(Fence.class);
        Example.Criteria criteria = example.createCriteria();

        if(fence!=null){
        	if (fence.getId() != null) {
                criteria.andEqualTo("id", fence.getId());
            }
        	
        	if(fence.getCompanyId()!=null){
        		criteria.andEqualTo("companyId", fence.getCompanyId());
        	}
        	if(StringUtils.isNotEmpty(fence.getCompanySn())){
        		criteria.andLike("companySn", fence.getCompanySn()+"%");
        	}
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<Fence> fenceList=selectByExample(example);
        PageInfo<Fence> pageInfo=  new PageInfo<Fence>(fenceList);
       
        return pageInfo;
    }
}
