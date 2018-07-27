package com.dearho.common.log.util;

import java.lang.annotation.Documented;  
import java.lang.annotation.ElementType;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;  

@Target(ElementType.FIELD)  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public @interface FieldComment {
	String value();
	String dictCode() default "";//数据字典 code,编辑是获取cnName  LH 2017年12月26日 16:05:17 
	boolean isRecord() default true;//过滤记录字段false LH 2017年12月26日 16:45:25
}

