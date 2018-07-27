package com.dearho.common.sms.service;


import com.dearho.core.Page;
import com.dearho.core.config.service.IService;
import com.dearho.common.sms.model.SMSCode;
import com.github.pagehelper.PageInfo;


public interface SMSCodeService extends IService<SMSCode> {

  
    PageInfo<SMSCode> selectBySMSCode(SMSCode sMSCode, Page page);

    public SMSCode getLatestSMSCode(SMSCode smsCode,Integer validMinute,String sn);
    
}