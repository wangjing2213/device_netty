package com.dearho.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dearho.common.user.vo.UserToken;
import com.dearho.redis.RedisUtils;
import com.dearho.result.JSONResult;
import com.dearho.util.TokenUtils;


public class AdminFilter implements Filter {
   
	private static  Log log = LogFactory.getLog(AdminFilter.class);
	
	private static String prefix="/console";
	
	//无需传token的
	public static String[] escapeUrls = {
			"/console/sys/user/invalidToken",
			"/console/sys/file/upload",
			prefix+"/sys/user/getToken",
			prefix+"/sys/area/list"
	};
	
	//无需传真token的
	public static String[] escapeLoginUrls = {
			"/console/sys/user/getVerify",
			"/console/sys/user/login",

	};
	
	 @Autowired
	 private RedisUtils redisUtils;
	
	
	@Override
	public void destroy() {

	}
	
	@Override
	  public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain
	            chain) {
		HttpServletRequest request = (HttpServletRequest) srequest;
		HttpServletResponse response = (HttpServletResponse) sresponse;

         response.setHeader("Access-Control-Allow-Origin", "*");  
         response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
         response.setHeader("Access-Control-Max-Age", "3600");  
         response.setHeader("Access-Control-Allow-Headers", "x-requested-with");  
		try {
				String url = request.getRequestURI();
				String path = request.getContextPath();
				

				System.out.println("url:"+url);
				if (  !check(url, escapeUrls)) {

					String token = request.getParameter("token");
					System.out.println("token:"+token);
					if(StringUtils.isEmpty(token)){
						request.getRequestDispatcher("/console/sys/user/invalidToken").forward(request, response);
						return;
					}
					//原解析方法抽出为TokenUtils.analysisToken
					UserToken userToken=null;
					try {
						userToken = TokenUtils.analysisTokenUser(token);
						System.out.println("userToken:"+userToken);
						
					} catch (Exception e) {
						e.printStackTrace();
						request.getRequestDispatcher("/console/sys/user/invalidToken").forward(request, response);
						return;

					}
					if(userToken==null) {
						request.getRequestDispatcher("/console/sys/user/invalidToken").forward(request, response);
						return;
					}
					if(!check(url, escapeLoginUrls) && StringUtils.isEmpty(userToken.getUserId())) {
						request.getRequestDispatcher("/console/sys/user/invalidToken").forward(request, response);
					 	return;
					}
					
					
					request.setAttribute("adminToken",userToken.getToken());
					
				
					if( StringUtils.isNotEmpty(userToken.getUserId())){
						request.setAttribute("userToken",userToken);
					}
					if(userToken.getUser()!=null) {
						request.setAttribute("loginUser",userToken.getUser());
					}
				}else{
				 	
				 	
				}

				chain.doFilter(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	private boolean check(String element, String[] elements) {
		for (String e : elements) {
			if (element.endsWith(e)) {
				return true;
			}
		}
		return false;
	}
}