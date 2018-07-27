package com.dearho.core;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dearho.common.user.model.User;


/**
 * @Author wangyx
 * @Description:(此类型的描述)
 * @Version 1.0, 2015-4-21
 */
public abstract class AbstractController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Log log = LogFactory.getLog(AbstractController.class);
	
	private static final SimpleDateFormat sdf10=new SimpleDateFormat("yyyy-MM-dd"); 
	
	private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static final SimpleDateFormat sdf4=new SimpleDateFormat("HH:mm");
	
	private static final SimpleDateFormat sdf6=new SimpleDateFormat("yyyy-MM");
	
	private static final SimpleDateFormat sdf12=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	private static final SimpleDateFormat sdf_xyk=new SimpleDateFormat("MM / yy");// 信用卡有效期
	protected String result;
	
	public String actionName;
	
	public String channelCompanyCode;
	
	public Integer channelCompanyId;//渠道公司id
	public String channelCompanySn;//渠道公司sn
	

	public  User getAdminUser(HttpServletRequest request) {
		if(request.getSession().getAttribute("user")!=null){
			return (User) request.getSession().getAttribute("loginUser");
		}else{
//			return null;
			User user=new User();
			user.setId("8aae20bc5d5578ed015d557e77be0003");
			user.setCompanySn("1|");
			user.setCompanyId(1);
			user.setLoginName("admin");
			user.setName("admin");
			return user;
		}
	}
	

	public  Integer getAdminUserCompanyId(HttpServletRequest request) {
		if(request.getSession().getAttribute("user")!=null){
			User user= (User) request.getSession().getAttribute("loginUser");
			return null;
		}else{
			return null;
		}
	}
	

	public  Integer getAdminUserCompanySn(HttpServletRequest request) {
		if(request.getSession().getAttribute("user")!=null){
			User user= (User) request.getSession().getAttribute("loginUser");
			return null;
		}else{
			return null;
		}
	}

	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	public HttpServletResponse getResponse() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	

	
}