package com.dearho.common.sms.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Element;

//import com.alipay.api.internal.util.XmlUtils;
//import com.szsoling.cs.util.HttpclientUtil;

/**
 * 美联软通短信工具类
 * @author liusong
 *
 */
public class MWKJSMSUtil extends SMSAbstract implements SMSInterface{
//extends SMSAbstract implements SMSInterface

	private SMSConfig smsConfig;
	public  static final String RESULT_SUCCESS="success";
	public  static final String RESULT_ERROR="error";

	public static final Log log = LogFactory.getLog(SMSUtil.class);
//    public static  final  String url="http://61.145.229.26:8086/MWGate/wmgw.asmx/MongateMULTIXSend";
	 public static    String url= "http://61.145.229.26:8086/MWGate/wmgw.asmx/MongateSendSubmit";
		 
   
	public MWKJSMSUtil(SMSConfig smsConfig) {
		this.smsConfig=smsConfig;
	}

    private String xmlAny(String post){

			try {

//			Element rootElementFromString = XmlUtils.getRootElementFromString("<?xml version=\"1.0\" encoding=\"utf-8\"?><string xmlns=\"http://tempuri.org/\">-8917528582274692397</string>");
//				String textContent = rootElementFromString.getTextContent();
//
//				return textContent;
			} catch (Exception e) {
				log.info(e.getMessage());

			}
			return "";

	}

	private  String send(String userId,String password,String userPhone,String msg){
		Map<String,String> map=new HashMap<String,String>();
		/*map.put("userId",userId);
		map.put("password",password);
		StringBuffer sb=new StringBuffer();
		sb.append("0|*|");
		sb.append(userPhone);
		sb.append("|");
		try {
		msg= com.alibaba.druid.util.Base64.byteArrayToBase64(msg.getBytes("gbk"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		sb.append(msg);
		map.put("multixmt",sb.toString());*/
		
		map.put("userId",userId);
		map.put("password",password);
		map.put("pszMobis", userPhone);
		map.put("pszMsg", msg);
		map.put("iMobiCount", ""+userPhone.split(",").length);
		map.put("pszSubPort", "*");
		map.put("MsgId", new Date().getTime()+"");
//		String post = HttpclientUtil.post(url, map, "UTF-8");
//		if(post!=null&&!"".equals(post)){
//			String s = xmlAny(post);
//			return s;
//		}
//		return post;
		return null;


	}


	/**
	 *
	 * 	apikey="d61c5a73de13f97279ef71127dd55049";
		username="bjfs";
		password="ml150513";
	 *
	 *
	 */

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

//		// 创建StringBuffer对象用来操作字符串
//		StringBuffer sb = new StringBuffer("http://m.5c.com.cn/api/send/?");
//		// APIKEY
//		sb.append("apikey="+smsConfig.getApikey());
		//用户名
		String username=smsConfig.getUsername();
//		// 向StringBuffer追加密码
String password=smsConfig.getPassword();
//
//		// 向StringBuffer追加手机号码
String mobile=smsObject.getPhoneNo();
//
//		// 向StringBuffer追加消息内容转URL标准码
String msg=smsObject.getContent();
//		// 创建url对象
//		URL url = new URL(sb.toString());
//		// 打开url连接
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//		// 设置url请求方式 ‘get’ 或者 ‘post’
//		connection.setRequestMethod("POST");
//		// 发送
//		BufferedReader in =null;
//		String inputline = null;

		String result ="";
		if(smsConfig.isTest()){
			log.info("短信网关没有开");
			result="success:00000000000000";
		}else {
			result = send(username, password, mobile, msg);
			if(result.length()<15){
				result=RESULT_ERROR+":"+result;
			}else{
				result =RESULT_SUCCESS+":00000000000000";
			}
		}
		// 输出结果
		log.info(smsObject);
		smsObject.setResult(result);

		logRecord(smsConfig,smsObject);




	}


	
	public static void main(String[] args) throws Exception {
		SMSObject smsObject=new SMSObject();
		smsObject.setPhoneNo("15210660866,17611228690");
		smsObject.setContent("欢迎使用小灵狗租车");

		
		SMSConfig smsConfig=new SMSConfig();
		smsConfig.setUsername("J25866");
		smsConfig.setPassword("632107");
		smsConfig.setTest(false);
		
		MWKJSMSUtil util=new MWKJSMSUtil(smsConfig);
		util.sendSMS(smsObject);
		
	}

	

}
