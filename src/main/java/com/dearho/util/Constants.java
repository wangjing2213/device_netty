package com.dearho.util;

public class Constants {

    public static final boolean DEBUG = true;
    public static final String DATA_ENCODE = "utf-8";

    public static final String JSON_VIEW_STATUS_SUCCESS = "success";
    public static final String JSON_VIEW_STATUS_FAILED = "failed";
    public static final String JSON_VIEW_STATUS_ERROR = "error";
    public static final String JSON_VIEW_STATUS_UNAUTHORIZED = "unauthorized";

    public static final String SPRING_PROFILE_PRODUCTION = "prod";
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_TEST = "test";
    public static final String SPRING_PROFILE_FAST = "fast";
    public static final String SPRING_PROFILE_JSE = "jse";
    public static final String SPRING_PROFILE_STAGING = "staging";

    public static final String LOCAL_SERVER_URL = "http://localhost:8080";
    
    /** APP使用的常量 **/

	public final static int APP_RESULT_CODE_SUCCESS = 0;
	public final static int APP_RESULT_CODE_FAIL = 1;
	public final static int APP_RESULT_CODE_LOGIN = -1;
	public final static int APP_RESULT_CODE_FAIL_PARAMETER = -5;
	
	
	public final static String SESSION_DRIVER = "subscriber";//前台会员登录session
	
	public final static String SESSION_DRIVER_CHANNEL = "subscriberChannel";//前台会员登录session
	
	
	public static  String UPLOAD_PATH_CAR_CONDITION="C:/Users/wt911/Desktop/upload/carImage/";//车照片
	public static  String UPLOAD_PATH_AVATAR="C:/Users/wt911/Desktop/upload/avatar/";//头像
	public static  String UPLOAD_PATH_IDENTIFY="C:/Users/wt911/Desktop/upload/identifyImage/";//身份证
	public static  String UPLOAD_PATH_DRIVING="C:/Users/wt911/Desktop/upload/drivingImage/";//驾照信息 行驶证信息
	
	public static final Integer UPLOAD_MAX_SIZE=1024*1024*5;
	
	public final static String DRIVER_DATA_SIGN = "dearho";//缓存信息key 前缀
	public final static String DRIVER_GEO_SIGN = "dearho_beijing";//jedisGeo key 
	public final static double DRIVER_NEARBY_RADIUS = 3;//附近半径距离   3 KM
	public final static double DRIVER_NEARBY_RADIUS_AGAIN = 5;//附近半径距离   3 KM
	public final static long DRIVER_TIME_OUT = 10;//超时时间   分     10分钟
	
	
	
	public final static String SUBSCIRBER_REGISTER_PHONE_CODE="registerPhoneCode";///注册短信验证码信息
	public final static String SUBSCIRBER_CHANGE_OLD_PHONE_CODE="oldChangePhoneCode";//修改绑定手机短信验证码
	public final static String SUBSCIRBER_CHANGE_NEW_PHONE_CODE="newChangePhoneCode";//修改绑定手机短信验证码
	public final static String SUBSCRIBER_PHONE_FIND_PWD_CODE="findPwdCode";
	public final static String SUBSCRIBER_LOGIN_CODE="loginCode";
	public final static String SUBSCRIBER_PHONE_RESET_PWD_CODE="resetPwdCode";

	public final static Integer REGISTER_SMS_VALID_MINUTE= 5;//注册短信验证码有效时间 单位分 5
	public final static Integer REGISTER_SMS_VALID_RETRY_MINUTE= 1;
}
