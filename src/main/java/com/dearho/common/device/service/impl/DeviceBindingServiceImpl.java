package com.dearho.common.device.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import  com.dearho.common.device.model.DeviceBinding;
import  com.dearho.common.device.service.DeviceBindingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("deviceBindingService")
public class DeviceBindingServiceImpl extends BaseService<DeviceBinding> implements DeviceBindingService {

    @Override
    public PageInfo<DeviceBinding> selectByDeviceBinding(DeviceBinding deviceBinding, Page page) {
        Example example = new Example(DeviceBinding.class);
        Example.Criteria criteria = example.createCriteria();

        if(deviceBinding!=null){
        	if (deviceBinding.getId() != null) {
                criteria.andEqualTo("id", deviceBinding.getId());
            }
        	
        	if(deviceBinding.getCompanyId()!=null){
        		criteria.andEqualTo("companyId", deviceBinding.getCompanyId());
        	}
        	if(StringUtils.isNotEmpty(deviceBinding.getCompanySn())){
        		criteria.andLike("companySn", deviceBinding.getCompanySn()+"%");
        	}
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<DeviceBinding> deviceBindingList=selectByExample(example);
        PageInfo<DeviceBinding> pageInfo=  new PageInfo<DeviceBinding>(deviceBindingList);
       
        return pageInfo;
    }
}
