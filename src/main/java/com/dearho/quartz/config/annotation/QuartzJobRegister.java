package com.dearho.quartz.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 没采用spring schduler，而是用quartz集群 暂时又不从界面操作job，所以代码中预先扫描了自动添加
 * 
 * @author chenhua
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface QuartzJobRegister {

	String value() default "";

}