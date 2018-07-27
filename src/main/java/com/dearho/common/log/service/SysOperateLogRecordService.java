package com.dearho.common.log.service;


import com.dearho.core.Page;
import com.dearho.core.config.service.IService;
import com.dearho.common.log.model.SysOperateLogRecord;
import com.github.pagehelper.PageInfo;


public interface SysOperateLogRecordService extends IService<SysOperateLogRecord> {

  
    PageInfo<SysOperateLogRecord> selectBySysOperateLogRecord(SysOperateLogRecord sysOperateLogRecord, Page page);

}