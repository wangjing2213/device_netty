package com.dearho.quartz.controller;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 暂时不开放
 * @author liusong
 *
 */
@RestController
@RequestMapping(value = "/quartz/job/", produces = { "application/json;charset=utf-8" })
public class QuartzController {

	private static final Logger LOG = LoggerFactory.getLogger(QuartzController.class);

	static final String DEFAULT_GROUP = "default_group";

	@Autowired
	private Scheduler scheduler;

	@SuppressWarnings("unchecked")
	@RequestMapping(path = "add.do", method = RequestMethod.POST)
	public String add(@RequestParam(required = true) String className, @RequestParam(required = true) String cronExp,
			@RequestParam(required = false) String groupName) {
		try {
			// 创建一个job
			JobDetailImpl jobDetail = new JobDetailImpl();
			jobDetail.setJobClass((Class<? extends Job>) Class.forName(className + ".class"));
			if (StringUtils.isEmpty(groupName)) {
				groupName = DEFAULT_GROUP;
			}
			jobDetail.setKey(new JobKey(className, groupName));
			// job的数据
			JobDataMap jobDataMap = new JobDataMap();
			// jobDataMap.put(key, value);
			jobDetail.setJobDataMap(jobDataMap);
			// trigger
			CronTriggerImpl strigger = new CronTriggerImpl();
			strigger.setKey(new TriggerKey(className, groupName));

			strigger.setCronExpression(cronExp);
			// 开始一个定时任务
			scheduler.scheduleJob(jobDetail, strigger);
			return null;
		} catch (Exception pe) {
			LOG.error(pe.getMessage(), pe);
			return null;
		}
	}

	@RequestMapping(path = "delete.do", method = RequestMethod.POST)
	public String delete(@RequestParam(required = true) String className,
			@RequestParam(required = false) String groupName) {
		if (StringUtils.isEmpty(groupName)) {
			groupName = DEFAULT_GROUP;
		}
		JobKey jk = new JobKey(className, groupName);
		try {
			scheduler.deleteJob(jk);
			return null;
		} catch (SchedulerException e) {
			LOG.error(e.getMessage(), e);
			return null;
		}
	}

	@RequestMapping(path = "list.do", method = RequestMethod.GET)
	public String list(@RequestParam(required = false) String className,
			@RequestParam(required = false) String groupName,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

		return null;
	}
}