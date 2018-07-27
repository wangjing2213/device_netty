package com.dearho.util;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.common.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dearho.common.user.vo.UserToken;
import com.dearho.core.token.AppToken;
import com.dearho.redis.RedisUtils;
import com.whalin.MemCached.MemCachedClient;



/**
 * 
 * @ClassName: TokenUtils
 * @Description: Token 工具类
 * @author LH
 * @date 2016年3月9日 下午4:24:15
 *
 */
@Component
public class TokenUtils {

	@Autowired
    private RedisUtils redisUtils;
	
	private static RedisUtils redisUtilsInstance;
	
	
	@PostConstruct
	public void init(){
		redisUtilsInstance=redisUtils;
	}
	
	/**
	 * @Title: getTokenEncode
	 * @Description: 加密 规则:当前时间戳MD5的16加密 加 code的32位加密
	 * @param @param
	 *            time
	 * @param @param
	 *            code
	 * @return String
	 */
	public static String getTokenEncode(String time, String code) {
		String md5code = Md5Util.MD5Encode(code);
		String md5time = Md5Util.MD5Encode(time).toString().substring(8, 24);
		
		return Base64.encodeBytes((md5time + md5code).getBytes());
	}

	// 解密
	public static Map<String, String> getTokenDecoder(String code) {
		Map<String, String> map = new HashMap<String, String>();
	
		byte[] decodeBuffer;
		try {
			decodeBuffer = Base64.decode(code);
			
			String md5Token = new String(decodeBuffer,"utf-8");
			map.put("md5Time", md5Token.substring(0, 16));
			map.put("md5Code", md5Token.substring(16, md5Token.length()));
		} catch (Exception e) {
			e.printStackTrace();
			map = null;
		}
		return map;
	}
	
	public static void main(String[] args) {
		//ZjZlY2U2NzA2M2Q2OGMwOThiMjliNzdlNmM1N2FiMDFjM2Q4N2M2YjM5MzMxM2Vi
		//YzkyOTFkYzgyYWNjNTM1ODhiMjliNzdlNmM1N2FiMDFjM2Q4N2M2YjM5MzMxM2Vi
		String token = "NDVhZDRjYzQ0YzM4NTU3MGVmZGEyYTU1NGUwZGE5MDNjYmMxZGZjMTEyY2E3YjJj";
		Map<String, String> tokenMap = getTokenDecoder(token);
		String md5Time = tokenMap.get("md5Time");
		String md5Code = tokenMap.get("md5Code");
		System.out.println(" md5Code："+md5Code);
		AppToken appToken = (AppToken) redisUtilsInstance.get(md5Code);
		if (appToken == null) {
			System.out.println(1);
		}else if(!StringUtils.isEmpty(token) && !StringUtils.isEmpty(appToken.getTokenCode()) && !token.equals(appToken.getTokenCode())){
			
			System.out.println("传递的 token："+token);
			System.out.println("缓存的 appToken："+appToken.getTokenCode());
		}
		
	}
	
//	//解析token
//	public static AppToken analysisToken(String data) {
//		return analysisToken(data,true);
//	}
//	public static AppToken analysisToken(String data,boolean isRedis) {
//		
//		System.out.println(memCachedClientInstance.get("newappTest"));
//		
//		if (data != null) {
//			try {
//				Map<String, String> jsonForMap = JsonTools.jsonForMap(data);
//					String token = jsonForMap.get("token");
//					Map<String, String> tokenMap = getTokenDecoder(token);
//					if (tokenMap==null || tokenMap.size() != 2) {
//						return null;
//						// request.getRequestDispatcher("/app/sys/v1/invalidToken.action").forward(request,
//						// response);
//					}
//					String md5Time = tokenMap.get("md5Time");
//					String md5Code = tokenMap.get("md5Code");
//					
//					AppToken appToken = null;
//					if(isRedis){
//						appToken = (AppToken) redisUtilsInstance.get(md5Code);
//					}else{
//						appToken = (AppToken) memCachedClientInstance.get(md5Code);
//					}
//					
//					if (appToken == null) {
//						return null;
//					}else if(!StringUtils.isEmpty(token) && !StringUtils.isEmpty(appToken.getTokenCode()) && !token.equals(appToken.getTokenCode())){
//						return null;
//					} else {
//						String md5Encode = Md5Util.MD5Encode(String.valueOf(appToken.getCreationTime().getTime()))
//								.substring(8, 24);
//						if (!md5Time.equals(md5Encode)) {// token 无效
//							return null;
//						}
//						return appToken;
//					}
//			} catch (Exception e) {
//				e.printStackTrace();
//				return null;
//			}
//		}
//		
//		return null;
//	}

	public static UserToken analysisTokenUser(String token) {
		return analysisTokenUser(token,true);
	}
	
	public static UserToken analysisTokenUser(String token,boolean isRedis) {
		Map<String, String> tokenMap = getTokenDecoder(token);
		if (tokenMap == null || tokenMap.size() != 2) {
			return null;
			// request.getRequestDispatcher("/app/sys/v1/invalidToken.action").forward(request,
			// response);
		}
		String md5Time = tokenMap.get("md5Time");
		String md5Code = tokenMap.get("md5Code");
		UserToken userToken=null;
//		if(isRedis){
			userToken = (UserToken) redisUtilsInstance.get(md5Code);
//		}else{
//			userToken = (UserToken) memCachedClientInstance.get(md5Code);
//		}
		
		if (userToken == null) {
			return null;
		} else {
			return userToken;
		}
		
	}
	
	public static String analysisAppTokenUser(String token){
		return analysisAppTokenUser(token,true);
	}
	public static String analysisAppTokenUser(String token,boolean isRedis) {
		Map<String, String> tokenMap = getTokenDecoder(token);
		if (tokenMap == null || tokenMap.size() != 2) {
			return null;
			// request.getRequestDispatcher("/app/sys/v1/invalidToken.action").forward(request,
			// response);
		}
		String md5Time = tokenMap.get("md5Time");
		String md5Code = tokenMap.get("md5Code");
		AppToken appToken =null;
//		if(isRedis){
			appToken= (AppToken) redisUtilsInstance.get(md5Code);
//		}else{
//			appToken= (AppToken) memCachedClientInstance.get(md5Code);
//		}
		
		if (appToken == null) {
			return null;
		} else {
			String md5Encode = Md5Util.MD5Encode(String.valueOf(appToken.getCreationTime().getTime())).substring(8, 24);
			if (!md5Time.equals(md5Encode)) {// token 无效
				return null;
			}
		}
		return appToken.getObjectId();
	}
	
	
	public static AppToken analysisTokenByToken(String token) {
		return analysisTokenByToken(token,true);
	}
	public static AppToken analysisTokenByToken(String token,boolean isRedis) {
		Map<String, String> tokenMap = getTokenDecoder(token);
		if (tokenMap == null || tokenMap.size() != 2) {
			return null;
			// request.getRequestDispatcher("/app/sys/v1/invalidToken.action").forward(request,
			// response);
		}
		String md5Time = tokenMap.get("md5Time");
		String md5Code = tokenMap.get("md5Code");
		AppToken appToken =null;
//		if(isRedis){
			appToken = (AppToken) redisUtilsInstance.get(md5Code);
//		}else{
//			appToken = (AppToken) memCachedClientInstance.get(md5Code);
//		}
		
		if (appToken == null) {
			return null;
		} else {
			String md5Encode = Md5Util.MD5Encode(String.valueOf(appToken.getCreationTime().getTime())).substring(8, 24);
			if (!md5Time.equals(md5Encode)) {// token 无效
				return null;
			}
		}
		return appToken;
	}
	
	public static int delAppToken(String token){
		return delAppToken(token,true);
	}
	
	public static int delAppToken(String token,boolean isRedis){
		Map<String, String> tokenMap = getTokenDecoder(token);
		if (tokenMap.size() != 2) {
			return 1;
		}
		String md5Time = tokenMap.get("md5Time");
		String md5Code = tokenMap.get("md5Code");
//		if(isRedis){
			AppToken appToken = (AppToken) redisUtilsInstance.get(md5Code);
			if(appToken!=null){
				redisUtilsInstance.remove(md5Code);
			}
//		}else{
//			AppToken appToken = (AppToken) memCachedClientInstance.get(md5Code);
//			if(appToken!=null){
//				memCachedClientInstance.delete(md5Code);
//			}
//		}
		
		return 0;
	}
}
