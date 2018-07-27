package com.dearho.common.sms.util;

import java.util.Date;

import org.springframework.web.context.ContextLoader;

import com.dearho.SpringUtils;
import com.dearho.common.sms.model.SMSRecord;
import com.dearho.common.sms.service.SMSRecordService;

public abstract class SMSAbstract {

	
	private static SMSRecordService sMSRecordService = 
			(SMSRecordService)SpringUtils.getBean("sMSRecordService") ;
	

	public void logRecord(SMSConfig smsConfig, SMSObject smsObject) {
		SMSRecord smsRecord =new SMSRecord();
		smsRecord.setContent(smsObject.getContent());
		smsRecord.setPhoneNo(smsObject.getPhoneNo());
		smsRecord.setType(smsObject.getType());
		smsRecord.setResult(smsObject.getResult());
		smsRecord.setUserId(smsObject.getUserId());
		smsRecord.setUserName(smsObject.getUserName());
		smsRecord.setTs(new Date());
		smsRecord.setCompanySn(smsObject.getSn());
		smsRecord.setCompanyId(smsObject.getCompanyId());
		sMSRecordService.save(smsRecord);
	}
}
