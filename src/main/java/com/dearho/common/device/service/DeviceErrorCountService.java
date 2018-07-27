package com.dearho.common.device.service;


import com.dearho.core.Page;
import com.dearho.core.config.service.IService;
import com.dearho.common.device.model.DeviceErrorCount;
import com.github.pagehelper.PageInfo;


public interface DeviceErrorCountService extends IService<DeviceErrorCount> {

  
    PageInfo<DeviceErrorCount> selectByDeviceErrorCount(DeviceErrorCount deviceErrorCount, Page page);

}