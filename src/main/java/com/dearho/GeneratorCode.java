package com.dearho;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.util.StringUtils;

import com.dearho.generation.config.MybatisConfig;
import com.dearho.generation.enums.CodeTypeEnum;
import com.dearho.generation.util.GeneratorUtils;

public class GeneratorCode {

	public static void main(String[] args) throws Exception, XMLParserException {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(GeneratorCode.class.getResourceAsStream("/generator/generatorConfig.xml"));
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		
		//生成service
		String domainObjectName=null;
		String targetControllerPackage=null;
		String targetServicePackage=null;
		String targetModelPackage=null;
		
		String targetProject=null;
		try {
			 domainObjectName= config.getContexts().get(0).getTableConfigurations().get(0).getDomainObjectName();
			 
			 
			Properties propertiesConfig=new Properties();
			
			propertiesConfig.load(GeneratorCode.class.getResourceAsStream("/generator/config.properties"));
			targetControllerPackage =propertiesConfig.getProperty("targetControllerPackage");
			targetServicePackage =propertiesConfig.getProperty("targetServicePackage");
			targetModelPackage =propertiesConfig.getProperty("targetModelPackage");
			 
			targetProject =propertiesConfig.getProperty("targetProject");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!StringUtils.isEmpty(domainObjectName) && !StringUtils.isEmpty(targetControllerPackage)
				&& !StringUtils.isEmpty(targetServicePackage) && !StringUtils.isEmpty(targetModelPackage)){
			
			MybatisConfig mybatisConfig=new MybatisConfig();
			
			mybatisConfig.setServicePackage(targetServicePackage);
			mybatisConfig.setControllerPackage(targetControllerPackage);
			mybatisConfig.setDomainObjectName(domainObjectName);
			mybatisConfig.setModelPackage(targetModelPackage);
			
			mybatisConfig.setOverwrite(overwrite);
			mybatisConfig.setGeneratorPath(targetProject);
			//添加非空判断 否则生成代码是报错 LH 2018年4月13日18:16:48
			if(mybatisConfig.getServiceBaseInterfance()!=null && mybatisConfig.getServiceBaseInterfance().contains("business")) {
				mybatisConfig.setServiceBaseInterfance("BusinessService");
				mybatisConfig.setServiceBaseInterfancePackage("com.dearho.core.config.service.BusinessService");
				
			}else {
				mybatisConfig.setServiceBaseInterfance("IService");
				mybatisConfig.setServiceBaseInterfancePackage("com.dearho.core.config.service.IService");
				
			}
			
			GeneratorUtils.genCode(mybatisConfig,
	                  "template/mybatis/service.ftl",
	                  CodeTypeEnum.SERVICE);
			
			GeneratorUtils.genCode(mybatisConfig,
	                  "template/mybatis/serviceimpl.ftl",
	                  CodeTypeEnum.SERVICEIMPL);
			
			GeneratorUtils.genCode(mybatisConfig,
	                  "template/mybatis/controller.ftl",
	                  CodeTypeEnum.CONTROLLER);
		}
	
	}
}
