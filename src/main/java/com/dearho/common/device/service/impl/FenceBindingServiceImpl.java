package com.dearho.common.device.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import  com.dearho.common.device.model.FenceBinding;
import  com.dearho.common.device.service.FenceBindingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("fenceBindingService")
public class FenceBindingServiceImpl extends BaseService<FenceBinding> implements FenceBindingService {

    @Override
    public PageInfo<FenceBinding> selectByFenceBinding(FenceBinding fenceBinding, Page page) {
        Example example = new Example(FenceBinding.class);
        Example.Criteria criteria = example.createCriteria();

        if(fenceBinding!=null){
        	if (fenceBinding.getId() != null) {
                criteria.andEqualTo("id", fenceBinding.getId());
            }
        	
        	if(fenceBinding.getCompanyId()!=null){
        		criteria.andEqualTo("companyId", fenceBinding.getCompanyId());
        	}
        	if(StringUtils.isNotEmpty(fenceBinding.getCompanySn())){
        		criteria.andLike("companySn", fenceBinding.getCompanySn()+"%");
        	}
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<FenceBinding> fenceBindingList=selectByExample(example);
        PageInfo<FenceBinding> pageInfo=  new PageInfo<FenceBinding>(fenceBindingList);
       
        return pageInfo;
    }
}
