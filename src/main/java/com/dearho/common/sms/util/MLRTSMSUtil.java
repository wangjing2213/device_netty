package com.dearho.common.sms.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * 美联软通短信工具类
 * @author liusong
 *
 */
public class MLRTSMSUtil extends SMSAbstract implements SMSInterface{

	
	private SMSConfig smsConfig;
	public  static final String RESULT_SUCCESS="success";
	public  static final String RESULT_ERROR="error";
	
	public static final Log log = LogFactory.getLog(SMSUtil.class);
	
	public MLRTSMSUtil(SMSConfig smsConfig) {
		this.smsConfig=smsConfig;
	}


	/**
	 * 
	 * 	apikey="d61c5a73de13f97279ef71127dd55049";
		username="bjfs";
		password="ml150513";
	 * 
	 * 
	 */
	@Override
	public void sendSMS(SMSObject smsObject) throws Exception {
		
		log.info(smsObject.getPhoneNo()+":"+smsObject.getContent());

		if(smsObject==null ||StringUtils.isEmpty(smsObject.getPhoneNo())){
			new Exception("下发短信手机号不能为空!");
		}
		if(StringUtils.isEmpty(smsObject.getContent())){
			new Exception("下发短信短信内容不能为空!");
		}
		if(smsObject.getContent()!=null && smsObject.getContent().length()>500){
			new Exception("下发短信短信内容过长!");
		}
		//发送内容
		
		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer("http://m.5c.com.cn/api/send/?");
		// APIKEY
		sb.append("apikey="+smsConfig.getApikey());
		//用户名
		sb.append("&username="+smsConfig.getUsername());
		// 向StringBuffer追加密码
		sb.append("&password="+smsConfig.getPassword());

		// 向StringBuffer追加手机号码
		sb.append("&mobile="+smsObject.getPhoneNo());

		// 向StringBuffer追加消息内容转URL标准码
		sb.append("&content="+URLEncoder.encode(smsObject.getContent(),"GBK"));
		// 创建url对象
		URL url = new URL(sb.toString());
		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 设置url请求方式 ‘get’ 或者 ‘post’
		connection.setRequestMethod("POST");
		// 发送
		BufferedReader in =null;
		String inputline = null;
		
	
		if(smsConfig.isTest()){
			log.info("短信网关没有开");
			inputline="success:00000000000000";
		}else{
			in=new BufferedReader(new InputStreamReader(url.openStream()));
			inputline=in.readLine();
		}
		// 输出结果
		log.info(smsObject);
		
		smsObject.setResult(inputline);
		
		logRecord(smsConfig,smsObject);
		
		if(StringUtils.isEmpty(inputline)){
			throw new Exception("返回结果为空");
		}else if(inputline.indexOf(":")==-1){
			throw new Exception("返回结果为格式不正确");
		}else{
			String[] resultArr=inputline.split(":");
			if(!RESULT_SUCCESS.equals(resultArr[0])){
				//发送失败
				throw new Exception("发送短信失败:"+resultArr[1]);
			}
		}
		
		
	}



	

}
