package com.dearho.core.filter;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by zsl on 2017/9/3.
 */
@Configuration
public class ConfigurationFilter {
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

   /* @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());//添加过滤器
        registration.addUrlPatterns("/*");//设置过滤路径，/*所有路径
        registration.addInitParameter("name", "alue");//添加默认参数
        registration.setName("MyFilter");//设置优先级
        registration.setOrder(1);//设置优先级
        
   
        return registration;
    }*/
    
    
    @Bean
    public FilterRegistrationBean adminRegistration() {  
        FilterRegistrationBean registration = new FilterRegistrationBean();  
        registration.setFilter(new AdminFilter());  
        registration.addUrlPatterns("/console/*");  
        registration.addInitParameter("paramName", "paramValue");  
        registration.setName("adminFilter");  
        registration.setOrder(2);  
        return registration;  
    }  
    
    
//    @Bean
//    public FilterRegistrationBean appDriverRegistration() {  
//        FilterRegistrationBean registration = new FilterRegistrationBean();  
//        registration.setFilter(new AppDriverFilter());  
//        registration.addUrlPatterns("/driver/*");  
//        registration.addInitParameter("paramName", "paramValue");  
//        registration.setName("appDriverFilter");  
//        registration.setOrder(2);  
//        return registration;  
//    }  
    
    
//    @Bean
//    public FilterRegistrationBean appSubscriberRegistration() {  
//        FilterRegistrationBean registration = new FilterRegistrationBean();  
//        registration.setFilter(new AppSubscriberFilter());  
//        registration.addUrlPatterns("/wyc/*");  
//        registration.addInitParameter("paramName", "paramValue");  
//        registration.setName("appSubscriberFilter");  
//        registration.setOrder(2);  
//        return registration;  
//    }  
   
}