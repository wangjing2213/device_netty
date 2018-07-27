package com.dearho.common.device.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import  com.dearho.common.device.model.Device;
import  com.dearho.common.device.service.DeviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("deviceService")
public class DeviceServiceImpl extends BaseService<Device> implements DeviceService {

    @Override
    public PageInfo<Device> selectByDevice(Device device, Page page) {
        Example example = new Example(Device.class);
        Example.Criteria criteria = example.createCriteria();

        if(device!=null){
        	if (device.getId() != null) {
                criteria.andEqualTo("id", device.getId());
            }
        	
        	if(device.getCompanyId()!=null){
        		criteria.andEqualTo("companyId", device.getCompanyId());
        	}
        	if(StringUtils.isNotEmpty(device.getCompanySn())){
        		criteria.andLike("companySn", device.getCompanySn()+"%");
        	}
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<Device> deviceList=selectByExample(example);
        PageInfo<Device> pageInfo=  new PageInfo<Device>(deviceList);
       
        return pageInfo;
    }
}
