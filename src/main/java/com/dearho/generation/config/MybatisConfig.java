package com.dearho.generation.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 生成代码配置类
 * @author liusong
 */
@Configuration
@ConfigurationProperties(prefix = "generator.mybatis")
public class MybatisConfig {

  
	private String modelPackage;
	  
    private String servicePackage;
    
    private String controllerPackage;
    
    //项目地址（代码生成的根路径）
    private String generatorPath;
  
    //实体类的类名
    private String domainObjectName;
    
    private String domainObjectNameToLowerCase;
    
    private String serviceBaseInterfance;
    
    private String serviceBaseInterfancePackage;
    
    //是否覆盖文件
    private Boolean overwrite;
	public String getServicePackage() {
		return servicePackage;
	}
	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}
	public String getControllerPackage() {
		return controllerPackage;
	}
	public void setControllerPackage(String controllerPackage) {
		this.controllerPackage = controllerPackage;
	}
	public String getGeneratorPath() {
		return generatorPath;
	}
	public void setGeneratorPath(String generatorPath) {
		this.generatorPath = generatorPath;
	}
	public String getDomainObjectName() {
		return domainObjectName;
	}
	public void setDomainObjectName(String domainObjectName) {
		this.domainObjectName = domainObjectName;
	}
	public Boolean getOverwrite() {
		return overwrite;
	}
	public void setOverwrite(Boolean overwrite) {
		this.overwrite = overwrite;
	}
	public String getModelPackage() {
		return modelPackage;
	}
	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}
	public String getDomainObjectNameToLowerCase() {
		if(domainObjectName!=null){
			return domainObjectName.substring(0, 1).toLowerCase()+domainObjectName.substring( 1);
		}else{
			return domainObjectNameToLowerCase;
		}
		
	}
	public void setDomainObjectNameToLowerCase(String domainObjectNameToLowerCase) {
		this.domainObjectNameToLowerCase = domainObjectNameToLowerCase;
	}
	public String getServiceBaseInterfance() {
		return serviceBaseInterfance;
	}
	public void setServiceBaseInterfance(String serviceBaseInterfance) {
		this.serviceBaseInterfance = serviceBaseInterfance;
	}
	public String getServiceBaseInterfancePackage() {
		return serviceBaseInterfancePackage;
	}
	public void setServiceBaseInterfancePackage(String serviceBaseInterfancePackage) {
		this.serviceBaseInterfancePackage = serviceBaseInterfancePackage;
	}
    
    
    
    
    
    
    
    
    

}
