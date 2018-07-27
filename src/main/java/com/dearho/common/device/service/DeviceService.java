package com.dearho.common.device.service;


import com.dearho.core.Page;
import com.dearho.core.config.service.IService;
import com.dearho.common.device.model.Device;
import com.github.pagehelper.PageInfo;


public interface DeviceService extends IService<Device> {

  
    PageInfo<Device> selectByDevice(Device device, Page page);

}