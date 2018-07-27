package com.dearho.common.user.vo;

import java.io.Serializable;

import com.dearho.common.user.model.User;

public class UserToken implements Serializable{
	
	private String token;
	
	private String userId;
	private String groupId;
	private User user;
	
	private String companyCode;
	private Integer companyId;
	private String companySn;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getCompanySn() {
		return companySn;
	}
	public void setCompanySn(String companySn) {
		this.companySn = companySn;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "UserToken [token=" + token + ", userId=" + userId + ", groupId=" + groupId + ", companyCode="
				+ companyCode + ", companyId=" + companyId + ", companySn=" + companySn + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
