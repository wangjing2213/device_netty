package com.dearho.core;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	// 字典缓存KEY
	public static final String CACHE_DICT_MAP = "cacheDictMap";
	public static final String CURRENT_USER = "systemuser";
	public static final String CURRENT_USERNAME = "systemusername";
	public static final String SESSION_FORCE_LOGOUT_KEY = "session.force.logout";

	public static final String ERROR = "error";
	public static final String SUCCESS = "error";
	public static final String MESSAGE = "message";
	
	
	public static final String MODEL_TYPE_ADD="添加";
	public static final String MODEL_TYPE_UPDATE="编辑";
	public static final String MODEL_TYPE_DELETE="删除";
	public static final String MODEL_TYPE_PAGE="分页";
	public static final String MODEL_TYPE_VIEW="详情";
	
	
	public static final String MODEL_ID_SYS_COMPANY="公司";
	public static final String MODEL_ID_SYS_COMPANY_CONFIG="公司配置";
	public static final String MODEL_ID_SYS_COUPON="优惠券";
//	public static final String MODEL_ID_SYS_COUPON_INSTANCE="会员优惠券";
	
	public static final String MODEL_ID_SYS_TRADE_RECORD="交易记录";
	
	public static List<String> mainMenu=new ArrayList<String>();
	
	
	public static String driver_geopos_key="dearho_beijing_test";
	
	static {
		mainMenu.add(MODEL_ID_SYS_COMPANY);
		mainMenu.add(MODEL_ID_SYS_COMPANY_CONFIG);
		mainMenu.add(MODEL_ID_SYS_COUPON);
		mainMenu.add(MODEL_ID_SYS_TRADE_RECORD);
	}

	
	
}
