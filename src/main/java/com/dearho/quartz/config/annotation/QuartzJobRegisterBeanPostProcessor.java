package com.dearho.quartz.config.annotation;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobKey;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Scheduler;
import org.quartz.TriggerKey;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 处理注解 @see QuartzJobRegister
 * 
 * @author chenhua
 *
 */
@Component
public class QuartzJobRegisterBeanPostProcessor implements BeanPostProcessor {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	static final String DEFAULT_GROUP = "default_group";

	@Autowired
	private Scheduler scheduler;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean.getClass().isAnnotationPresent(QuartzJobRegister.class)) {
			String className = bean.getClass().getName();
			LOG.info("即将添加定时任务[{}]到quartz...", beanName);
			if (bean instanceof org.quartz.Job) {
				try {
					// 创建一个job
					JobDetailImpl jobDetail = new JobDetailImpl();
					jobDetail.setJobClass((Class<? extends Job>) bean.getClass());
					jobDetail.setKey(new JobKey(className, DEFAULT_GROUP));
					// job的数据
					JobDataMap jobDataMap = new JobDataMap();
					jobDetail.setJobDataMap(jobDataMap);
					// trigger
					CronTriggerImpl strigger = new CronTriggerImpl();
					String cornExp = bean.getClass().getAnnotation(QuartzJobRegister.class).value();
					strigger.setKey(new TriggerKey(className, DEFAULT_GROUP));
					strigger.setCronExpression(cornExp);
					// 开始一个定时任务
					scheduler.scheduleJob(jobDetail, strigger);
					LOG.info("添加定时任务[{}]到quartz...OK!", beanName);
				} catch (ObjectAlreadyExistsException oae) {
					LOG.warn("数据库中已经存在该任务,JobClass=" + className);
				} catch (Exception e) {
					LOG.error("添加定时任务失败,JobClass=" + className, e);
				}
			}
		}
		return bean;
	}
}