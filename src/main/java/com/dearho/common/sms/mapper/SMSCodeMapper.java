package com.dearho.common.sms.mapper;

import java.util.List;
import java.util.Map;

import com.dearho.common.sms.model.SMSCode;

import tk.mybatis.mapper.common.Mapper;

public interface SMSCodeMapper extends Mapper<SMSCode> {
	
	List<SMSCode> getLatestSMSCode(Map<String, Object> map);
}