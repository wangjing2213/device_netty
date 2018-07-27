package com.dearho.core.token;

import java.util.Date;

public class AppToken implements java.io.Serializable{

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	private String id;
	private String uuid;
	private Date creationTime;
	private String tokenCode;
	private String objectId;
	private String channelCompanyCode;
	private Integer channelCompanyId;
	private String channelCompanySn;
	
	
	private String  defaultCompanyCode;
	private Integer defaultCompanyId;
	private String  defaultCompanySn;
	
//	private String currentCompanyCode;
	
	private Integer channel;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public String getTokenCode() {
		return tokenCode;
	}
	public void setTokenCode(String tokenCode) {
		this.tokenCode = tokenCode;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getChannelCompanyCode() {
		return channelCompanyCode;
	}
	public void setChannelCompanyCode(String channelCompanyCode) {
		this.channelCompanyCode = channelCompanyCode;
	}
	public Integer getChannelCompanyId() {
		return channelCompanyId;
	}
	public void setChannelCompanyId(Integer channelCompanyId) {
		this.channelCompanyId = channelCompanyId;
	}
	public String getChannelCompanySn() {
		return channelCompanySn;
	}
	public void setChannelCompanySn(String channelCompanySn) {
		this.channelCompanySn = channelCompanySn;
	}
//	public String getCurrentCompanyCode() {
//		return currentCompanyCode;
//	}
//	public void setCurrentCompanyCode(String currentCompanyCode) {
//		this.currentCompanyCode = currentCompanyCode;
//	}
	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	/*@Override
	public String toString() {
		return "AppToken [id=" + id + ", creationTime=" + creationTime + ", tokenCode=" + tokenCode + ", objectId="
				+ objectId + ", channelCompanyCode=" + channelCompanyCode + ", channelCompanyId=" + channelCompanyId
				+ ", channelCompanySn=" + channelCompanySn + ", currentCompanyCode=" + currentCompanyCode + ", channel="
				+ channel + "]";
	}*/
	
	
	public Integer getDefaultCompanyId() {
		return defaultCompanyId;
	}
	public String getDefaultCompanyCode() {
		return defaultCompanyCode;
	}
	public void setDefaultCompanyCode(String defaultCompanyCode) {
		this.defaultCompanyCode = defaultCompanyCode;
	}
	public void setDefaultCompanyId(Integer defaultCompanyId) {
		this.defaultCompanyId = defaultCompanyId;
	}
	public String getDefaultCompanySn() {
		return defaultCompanySn;
	}
	public void setDefaultCompanySn(String defaultCompanySn) {
		this.defaultCompanySn = defaultCompanySn;
	}
	@Override
	public String toString() {
		return "AppToken [id=" + id + ", creationTime=" + creationTime + ", tokenCode=" + tokenCode + ", objectId="
				+ objectId + ", channelCompanyCode=" + channelCompanyCode + ", channelCompanyId=" + channelCompanyId
				+ ", channelCompanySn=" + channelCompanySn + ", defaultCompanyCode=" + defaultCompanyCode
				+ ", defaultCompanyId=" + defaultCompanyId + ", defaultCompanySn=" + defaultCompanySn + ", channel="
				+ channel + "]";
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	
	
	

}
