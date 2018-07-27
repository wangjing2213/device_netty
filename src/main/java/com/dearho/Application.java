package com.dearho;


import java.util.Properties;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.dearho.core.MyMapper;
import com.dearho.util.property.ConfigProperties;

import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.spring.annotation.MapperScan;



/**
 * Spring Boot 应用启动类
 * <p>
 * 
 * SpringBoot项目的Bean装配默认规则是根据Application类所在的包位置从上往下扫描！ “Application类”是指SpringBoot项目入口类。这个类的位置很关键：

	如果Application类所在的包为：io.github.gefangshuai.app，则只会扫描io.github.gefangshuai.app包及其所有子包，如果service或dao所在包不在io.github.gefangshuai.app及其子包下，则不会被扫描！
 */
// Spring Boot 应用的标识
@SpringBootApplication
@EnableTransactionManagement
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@MapperScan({"com.dearho.business.*.mapper","com.dearho.common.*.mapper"})
//public class Application   implements CommandLineRunner {

	public class Application  extends SpringBootServletInitializer  implements CommandLineRunner {
	//打war包时打开此注释
	 @Override
	   protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(Application.class);
	   }
	 
    @Autowired
    private ConfigProperties configProperties;
    
 
//    @Autowired
//    private Configuration configuration;
    
    @Autowired
    private  SqlSessionTemplate sqlSessionTemplate;
    
    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class, args);
        
        
      
    }

    @Override
    public void run(String... args) throws Exception {
    	
    	 MapperHelper mapperHelper = new MapperHelper();
    	
         //特殊配置
         Config config = new Config();
         //具体支持的参数看后面的文档
//         config.set.setXXX(XXX);
         Properties properties=new Properties();
         properties.setProperty("basePackage", "com.dearho.core.MyMapper");
         properties.setProperty("mappers", "com.dearho.core.MyMapper");
//         
//         config.setProperties(properties);
         //设置配置
//         mapperHelper.setConfig(config);
         // 注册自己项目中使用的通用Mapper接口，这里没有默认值，必须手动注册
//         mapperHelper.registerMapper(MyMapper.class);
         //配置完成后，执行下面的操作

         mapperHelper.registerMapper(MyMapper.class);
         mapperHelper.processConfiguration(sqlSessionTemplate.getConfiguration());
    	
        System.out.println("\n" + configProperties.toString());
        System.out.println();
    }
    
   
    
    private CorsConfiguration buildConfig() {  
        CorsConfiguration corsConfiguration = new CorsConfiguration();  
        corsConfiguration.addAllowedOrigin("*");  
        corsConfiguration.addAllowedHeader("*");  
        corsConfiguration.addAllowedMethod("*");  
//        corsConfiguration.addAllowedMethod("POST");
        return corsConfiguration;  
    }  
      
    /** 
     * 跨域过滤器 
     * @return 
     */  
    @Bean  
    public CorsFilter corsFilter() {  
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
        source.registerCorsConfiguration("/**", buildConfig()); // 4  
        return new CorsFilter(source);  
    }  
}
