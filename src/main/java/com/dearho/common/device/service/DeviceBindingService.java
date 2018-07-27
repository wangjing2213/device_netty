package com.dearho.common.device.service;


import com.dearho.core.Page;
import com.dearho.core.config.service.IService;
import com.dearho.common.device.model.DeviceBinding;
import com.github.pagehelper.PageInfo;


public interface DeviceBindingService extends IService<DeviceBinding> {

  
    PageInfo<DeviceBinding> selectByDeviceBinding(DeviceBinding deviceBinding, Page page);

}