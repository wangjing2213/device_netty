package com.dearho.common.sms.util;

import org.apache.commons.lang.StringUtils;

import com.dearho.SpringUtils;
import com.dearho.common.company.model.CompanyConfig;
import com.dearho.common.company.model.CompanyRelation;
import com.dearho.common.company.service.CompanyConfigService;
import com.dearho.common.company.service.CompanyRelationService;



/**
 * @Author liusong
 * @Description 
 * @Version 1.0,2015-5-25
 *
 */

public class SMSUtil {

	private static CompanyRelationService companyRelationService ;//  关键点1   静态初使化 一个工具类  这样是为了在spring初使化之前
	
	private static CompanyConfigService companyConfigService;

//	public static void sendSMS(Subscriber subscriber,String content,Integer type) throws Exception {
//		Integer companyId=null;
//		String sn=null;
//		String phoneNo=null;
//		if(subscriber!=null){
//			companyId=subscriber.getRegisterCompanyId();
//			sn=subscriber.getRegisterCompanySn();
//			phoneNo=subscriber.getPhoneNo();
//		}
//		if(phoneNo!=null){
//			sendSMS(phoneNo,content,type,null,null,companyId,sn);
//		}
//		
//	}
	
//	public static void sendSMS(Driver driver,String content,Integer type) throws Exception {
//		Integer companyId=null;
//		String sn=null;
//		String phoneNo=null;
//		if(driver!=null){
//			companyId=driver.getRegisterCompanyId();
//			sn=driver.getRegisterCompanySn();
//			phoneNo=driver.getPhoneNum();
//		}
//		if(phoneNo!=null){
//			sendSMS(phoneNo,content,type,null,null,companyId,sn);
//		}
//		
//	}
	public static void sendSMS(String phoneNo,String content,Integer type,Integer companyId,String sn) throws Exception {
		sendSMS(phoneNo,content,type,null,null,companyId,sn);
	}
	public static void sendSMS(String phoneNo,String content,Integer type,String userId,String userName,Integer companyId,String sn) throws Exception {
		SMSObject smsObject=new SMSObject();
		smsObject.setPhoneNo(phoneNo);
		smsObject.setCompanyId(companyId);
		smsObject.setContent(content);
		smsObject.setPhoneNo(phoneNo);
		smsObject.setSn(sn);
		smsObject.setType(type);
		smsObject.setUserId(userId);
		smsObject.setUserName(userName);
		
		SMSConfig smsConfig=new SMSConfig();
		CompanyRelationService companyRelationService = (CompanyRelationService) SpringUtils.getBean("companyRelationService");  
		CompanyRelation companyRelation=companyRelationService.selectByKey(companyId);
		if(companyRelation==null || companyRelation.getCompanyConfigId()==null){
			throw new RuntimeException(companyRelation.getCompanyName()+"短信配置未配置");
		}
		CompanyConfigService companyConfigService = (CompanyConfigService) SpringUtils.getBean("companyConfigService");
		CompanyConfig companyConfig = companyConfigService.getCompanyConfigByid(companyRelation.getCompanyConfigId());
		
		if(companyConfig==null){
			throw new RuntimeException(companyRelation.getCompanyName()+"短信配置未配置");
		}
		
		if(StringUtils.isEmpty(companyConfig.getSmsApiKey()) || companyConfig.getSmsIsTest()==null 
				|| StringUtils.isEmpty(companyConfig.getSmsPassword()) || StringUtils.isEmpty(companyConfig.getSmsUserName())
				|| companyConfig.getSmsType()==null){
			throw new RuntimeException(companyRelation.getCompanyName()+"短信配置未完全配置");
		}else{
			smsConfig.setApikey(companyConfig.getSmsApiKey());
			smsConfig.setPassword(companyConfig.getSmsPassword());
			smsConfig.setTest(new Integer(0).equals(companyConfig.getSmsIsTest()));
			smsConfig.setType(companyConfig.getSmsType());
			smsConfig.setUsername(companyConfig.getSmsUserName());
		}

		
		SMSInterface smsInterface=SMSFactory.createSMSInstance(smsConfig);
		if(smsInterface==null){
			new RuntimeException("未初始化短信网关配置,请联系管理员进行配置");
		}
		smsInterface.sendSMS(smsObject);
	}

	
	
}
