package com.dearho.common.device.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import  com.dearho.common.device.model.DeviceErrorCount;
import  com.dearho.common.device.service.DeviceErrorCountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("deviceErrorCountService")
public class DeviceErrorCountServiceImpl extends BaseService<DeviceErrorCount> implements DeviceErrorCountService {

    @Override
    public PageInfo<DeviceErrorCount> selectByDeviceErrorCount(DeviceErrorCount deviceErrorCount, Page page) {
        Example example = new Example(DeviceErrorCount.class);
        Example.Criteria criteria = example.createCriteria();

        if(deviceErrorCount!=null){
        	if (deviceErrorCount.getId() != null) {
                criteria.andEqualTo("id", deviceErrorCount.getId());
            }
        	
        	if(deviceErrorCount.getCompanyId()!=null){
        		criteria.andEqualTo("companyId", deviceErrorCount.getCompanyId());
        	}
        	if(StringUtils.isNotEmpty(deviceErrorCount.getCompanySn())){
        		criteria.andLike("companySn", deviceErrorCount.getCompanySn()+"%");
        	}
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<DeviceErrorCount> deviceErrorCountList=selectByExample(example);
        PageInfo<DeviceErrorCount> pageInfo=  new PageInfo<DeviceErrorCount>(deviceErrorCountList);
       
        return pageInfo;
    }
}
