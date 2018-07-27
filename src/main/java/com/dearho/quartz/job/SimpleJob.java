package com.dearho.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.dearho.quartz.config.annotation.QuartzJobRegister;

@Component
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@QuartzJobRegister("0 */1 * * * ?")  //测试 一分钟一次
public class SimpleJob  extends QuartzJobBean{
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println(sdf.format(new Date()));
		
	}

}
