package com.dearho.common.sms.util;

public class SMSFactory {

	private SMSFactory() {
		
	}

	 
	 
	public static SMSInterface createSMSInstance(SMSConfig smsConfig){
		if(smsConfig==null || smsConfig.getType()==null){
			return null;
		}
		//美联软通的sms
		SMSInterface smsInterface=null;
		if(SMSConfig.SMS_TYPE_MLRT.equals(smsConfig.getType())){
			smsInterface=new MLRTSMSUtil(smsConfig); 
		}
		else
		if(SMSConfig.SMS_TYPE_MWKJ.equals(smsConfig.getType())){
			smsInterface=new MWKJSMSUtil(smsConfig);
		}
		return smsInterface;
	}
}

