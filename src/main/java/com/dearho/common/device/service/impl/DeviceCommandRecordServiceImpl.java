package com.dearho.common.device.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dearho.core.config.service.impl.BaseService;
import com.dearho.core.Page;
import  com.dearho.common.device.model.DeviceCommandRecord;
import  com.dearho.common.device.service.DeviceCommandRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


@Service("deviceCommandRecordService")
public class DeviceCommandRecordServiceImpl extends BaseService<DeviceCommandRecord> implements DeviceCommandRecordService {

    @Override
    public PageInfo<DeviceCommandRecord> selectByDeviceCommandRecord(DeviceCommandRecord deviceCommandRecord, Page page) {
        Example example = new Example(DeviceCommandRecord.class);
        Example.Criteria criteria = example.createCriteria();

        if(deviceCommandRecord!=null){
        	if (deviceCommandRecord.getId() != null) {
                criteria.andEqualTo("id", deviceCommandRecord.getId());
            }
        	
        	if(deviceCommandRecord.getCompanyId()!=null){
        		criteria.andEqualTo("companyId", deviceCommandRecord.getCompanyId());
        	}
        	if(StringUtils.isNotEmpty(deviceCommandRecord.getCompanySn())){
        		criteria.andLike("companySn", deviceCommandRecord.getCompanySn()+"%");
        	}
        }
        
        if(StringUtils.isNotEmpty(page.getPageOrderString())){
        	example.setOrderByClause(page.getPageOrderString());
        }
       
        //分页查询
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        
        List<DeviceCommandRecord> deviceCommandRecordList=selectByExample(example);
        PageInfo<DeviceCommandRecord> pageInfo=  new PageInfo<DeviceCommandRecord>(deviceCommandRecordList);
       
        return pageInfo;
    }
}
