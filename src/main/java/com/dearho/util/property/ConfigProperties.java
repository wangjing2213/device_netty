package com.dearho.util.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 *
 * Created by liusong
 */
@Component
@ConfigurationProperties(prefix = "config")
public class ConfigProperties {

    /**
     * 省份
     */
    private String version;
    
    private String commonImagePath;
    
    private String commonFilePath;
    
//    private String random
    
    //
    private Integer  passwordErrorAccount;
    private Integer  passwordErrorMinute;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	

	public String getCommonImagePath() {
		return commonImagePath;
	}

	public void setCommonImagePath(String commonImagePath) {
		this.commonImagePath = commonImagePath;
	}

	public String getCommonFilePath() {
		return commonFilePath;
	}

	public void setCommonFilePath(String commonFilePath) {
		this.commonFilePath = commonFilePath;
	}

	@Override
	public String toString() {
		return "ConfigProperties [version=" + version + "]";
	}

	

    
	

	public Integer getPasswordErrorAccount() {
		return passwordErrorAccount;
	}

	public void setPasswordErrorAccount(Integer passwordErrorAccount) {
		this.passwordErrorAccount = passwordErrorAccount;
	}

	public Integer getPasswordErrorMinute() {
		return passwordErrorMinute;
	}

	public void setPasswordErrorMinute(Integer passwordErrorMinute) {
		this.passwordErrorMinute = passwordErrorMinute;
	}
    
	
}
