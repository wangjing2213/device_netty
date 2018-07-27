package com.dearho.common.sms.util;



public class SMSConfig {

	public SMSConfig() {
		super();
		this.isTest=false;
	}


	public static  Integer SMS_TYPE_MLRT=1;
	public static  Integer SMS_TYPE_MWKJ=2;

	private Integer type;
	private boolean isTest;

	private String apikey;
	private  String username;
	private  String password;
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getApikey() {
		return apikey;
	}
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isTest() {
		return isTest;
	}
	public void setTest(boolean isTest) {
		this.isTest = isTest;
	}
	@Override
	public String toString() {
		return "SMSConfig [type=" + type + ", isTest=" + isTest + ", apikey=" + apikey + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	
}
