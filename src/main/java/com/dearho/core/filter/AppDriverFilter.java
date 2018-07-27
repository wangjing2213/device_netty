package com.dearho.core.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

import com.dearho.common.company.model.CompanyRelation;
import com.dearho.core.token.AppToken;
import com.dearho.util.Constants;
import com.dearho.util.TokenUtils;



public class AppDriverFilter implements Filter {
   
	private static  Log log = LogFactory.getLog(AppDriverFilter.class);
	
	public static String[] escapeUrls = {
		"/driver/app/driver/appCodeLogin",
		"/driver/app/appDriver/registerCode",
		"/driver/app/appDriver/register",
		"/driver/app/login/loginSendCode",
		"/driver/app/login/driverLogin",
		"/driver/app/appDriver/resetPWDSendCode",
//		"/driver/app/appDriver/verifyTaxiCompany",//测试
//		"/driver/app/appCar/getCarBrandList",//ceshi 
//		"/driver/app/appDriver/driverDetail",//测试
//		"/driver/app/appCar/getCarModelList",//ceshi
//		"/driver/app/recieveModel/setRecieveOrdersStatus",//测试
		
		"/driver/app/appCar/getCarModelList1",
		"/driver/app/appDriver/resetPassword"
		
	};
	
	//不需要登录
	public static String[] escapeLoginUrls = {
//			"/app/driver/appLoginMessage",
			"/driver/app/driver/appCodeLogin"
			
	};
	
	private Map<String,CompanyRelation> companyMap=new HashMap<String,CompanyRelation>();


    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain
            filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) srequest;
        HttpServletResponse response = (HttpServletResponse) sresponse;
        //打印请求Url
        System.out.println("this is AppDriverFilter,url :" + request.getRequestURI());

		String url = request.getRequestURI();
		// 先判断是不是需要检查session的资源大类
			String path = request.getContextPath();
		if (url.startsWith(path)) {
			url = url.replaceFirst(path, "");
		}
		if (url.startsWith("/app")) {
			if (!check(url, escapeUrls)) {
				
				String data = request.getParameter("data");
				if(StringUtils.isEmpty(data)){
					request.getRequestDispatcher("/app/driver/invalidToken").forward(request, response);
					return;
				}
//				//原解析方法抽出为TokenUtils.analysisToken
//				AppToken analysisToken = TokenUtils.analysisToken(data);
//				if(analysisToken!=null){
//						if(analysisToken.getObjectId()!=null){
//							request.setAttribute("driverId",analysisToken.getObjectId());
//						}
//						
//						request.setAttribute(Constants.SESSION_DRIVER_CHANNEL,analysisToken.getChannel());
//						request.getSession().setAttribute("channelCompanyCode", analysisToken.getChannelCompanyCode());
//						request.getSession().setAttribute("channelCompanyId",analysisToken.getChannelCompanyId());
//						request.getSession().setAttribute("channelCompanySn",analysisToken.getChannelCompanySn());
//						
//						request.getSession().setAttribute("defaultCompanyCode", analysisToken.getDefaultCompanyCode());
//						request.getSession().setAttribute("defaultCompanyId",analysisToken.getDefaultCompanyId());
//						request.getSession().setAttribute("defaultCompanySn",analysisToken.getDefaultCompanySn());
//						
//						
//						if(!check(url, escapeLoginUrls) && StringUtils.isEmpty(analysisToken.getObjectId())) {
//							//登录
//							request.getRequestDispatcher("/app/driver/invalidToken").forward(request, response);
//						 	return;
//						}
//						
//				}else{
//					request.getRequestDispatcher("/app/driver/invalidToken").forward(request, response);
//				 	return;
//				}
			}else{
			 	
			 	
			}
		}

		filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }
    
    @Override
    public void destroy() {
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