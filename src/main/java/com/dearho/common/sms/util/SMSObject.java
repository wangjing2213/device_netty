package com.dearho.common.sms.util;

public class SMSObject {

	public SMSObject() {
		super();
	}
	
	private Integer type;
	private String phoneNo;
	private String content;
	private String result;
	
	private String userId;
	private String userName;
	private Integer companyId;
	private String sn;
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "SMSObject [phoneNo=" + phoneNo + ", content=" + content + ", result=" + result + ", userId=" + userId
				+ ", userName=" + userName + ", companyId=" + companyId + ", sn=" + sn + "]";
	}
	
	
	
	
	
	
	
}
