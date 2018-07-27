package com.dearho.common.device.service;


import com.dearho.core.Page;
import com.dearho.core.config.service.IService;
import com.dearho.common.device.model.DeviceCommandRecord;
import com.github.pagehelper.PageInfo;


public interface DeviceCommandRecordService extends IService<DeviceCommandRecord> {

  
    PageInfo<DeviceCommandRecord> selectByDeviceCommandRecord(DeviceCommandRecord deviceCommandRecord, Page page);

}