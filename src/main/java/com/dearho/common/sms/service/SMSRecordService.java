package com.dearho.common.sms.service;


import com.dearho.core.Page;
import com.dearho.core.config.service.IService;
import com.dearho.common.sms.model.SMSRecord;
import com.github.pagehelper.PageInfo;


public interface SMSRecordService extends IService<SMSRecord> {

  
    PageInfo<SMSRecord> selectBySMSRecord(SMSRecord sMSRecord, Page page);

}