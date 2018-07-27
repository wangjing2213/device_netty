package com.dearho.quartz.config;

import java.text.ParseException;
import java.util.Properties;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.dearho.quartz.config.spring.AutoWiringSpringBeanJobFactory;

@Configuration
@EnableScheduling
public class QuartzConfig {

	

	
	@Value("${quartz.scheduler.instanceName}")
    private String quartzInstanceName;
     
    @Value("${org.quartz.dataSource.myDS.driver}")
    private String myDSDriver;
     
    @Value("${org.quartz.dataSource.myDS.URL}")
    private String myDSURL;
     
    @Value("${org.quartz.dataSource.myDS.user}")
    private String myDSUser;
     
    @Value("${org.quartz.dataSource.myDS.password}")
    private String myDSPassword;
     
    @Value("${org.quartz.dataSource.myDS.maxConnections}")
    private String myDSMaxConnections;

	@Bean("quartzPropertyies")
	public Properties getPropertyies() {
//		Properties properties = new Properties();
//		properties.setProperty("org.quartz.jobStore.mongoUri", mongoUri);// 配置mongodb的集群地址
//		properties.setProperty("org.quartz.jobStore.class", "com.novemberain.quartz.mongodb.MongoDBJobStore");
//		properties.setProperty("org.quartz.jobStore.dbName", dbName);// 配置数据库名
//		properties.setProperty("org.quartz.jobStore.collectionPrefix", "task-");// 配置表名前缀
//		properties.setProperty("org.quartz.jobStore.jobTimeoutMillis", "2000");
//		properties.setProperty("org.quartz.jobStore.triggerTimeoutMillis", "200");// 配置触发器锁的过期时间
//		properties.setProperty("org.quartz.threadPool.threadCount", "1");// 线程数量
//		properties.setProperty("org.quartz.jobStore.isClustered", isClustered); // 是否是集群
//		properties.setProperty("org.quartz.scheduler.instanceId", "AUTO");
//		properties.setProperty("org.quartz.scheduler.instanceName", "clusterName"); // ????
//		properties.setProperty("org.quartz.jobStore.clusterCheckinInterval", "5000");// 检测mongodb触发器状态的间隔时间
//		return properties;
		
		
		Properties prop = new Properties();
        prop.put("quartz.scheduler.instanceName", quartzInstanceName);
        prop.put("org.quartz.scheduler.instanceId", "AUTO");
        prop.put("org.quartz.scheduler.skipUpdateCheck", "true");
        prop.put("org.quartz.scheduler.jmx.export", "true");
         
        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        prop.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
        prop.put("org.quartz.jobStore.dataSource", "quartzDataSource");
        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
        prop.put("org.quartz.jobStore.isClustered", "true");
         
        prop.put("org.quartz.jobStore.clusterCheckinInterval", "20000");
        prop.put("org.quartz.jobStore.dataSource", "myDS");
        prop.put("org.quartz.jobStore.maxMisfiresToHandleAtATime", "1");
        prop.put("org.quartz.jobStore.misfireThreshold", "120000");
        prop.put("org.quartz.jobStore.txIsolationLevelSerializable", "true");
        prop.put("org.quartz.jobStore.selectWithLockSQL", "SELECT * FROM {0}LOCKS WHERE LOCK_NAME = ? FOR UPDATE");
         
        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        prop.put("org.quartz.threadPool.threadCount", "10");
        prop.put("org.quartz.threadPool.threadPriority", "5");
        prop.put("org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread", "true");
         
        prop.put("org.quartz.dataSource.myDS.driver", myDSDriver);
        prop.put("org.quartz.dataSource.myDS.URL", myDSURL);
        prop.put("org.quartz.dataSource.myDS.user", myDSUser);
        prop.put("org.quartz.dataSource.myDS.password", myDSPassword);
        System.out.println("myDSMaxConnections:" + myDSMaxConnections);
        prop.put("org.quartz.dataSource.myDS.maxConnections", myDSMaxConnections);
         
        prop.put("org.quartz.plugin.triggHistory.class", "org.quartz.plugins.history.LoggingJobHistoryPlugin");
        prop.put("org.quartz.plugin.shutdownhook.class", "org.quartz.plugins.management.ShutdownHookPlugin");
        prop.put("org.quartz.plugin.shutdownhook.cleanShutdown", "true");
        return prop;
	}

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() throws ParseException {
		SchedulerFactoryBean sfBean = new SchedulerFactoryBean();
		// ClassPathResource cpr = new ClassPathResource("quartz.properties");
		// sfBean.setConfigLocation(cpr); //注释掉的代码是当用.properties文件配置的时候用的,可以和上边的配置函数等价
		sfBean.setQuartzProperties(getPropertyies());
		sfBean.setOverwriteExistingJobs(true);
		sfBean.setStartupDelay(10);
		// 解决 Job类中无法使用 Autowired 依赖注入问题
		sfBean.setJobFactory(autoWiringSpringBeanJobFactory());
		sfBean.setApplicationContextSchedulerContextKey("honeywell");
		return sfBean;
	}

	@Bean
	public AutoWiringSpringBeanJobFactory autoWiringSpringBeanJobFactory() {
		return new AutoWiringSpringBeanJobFactory();
	}

	@Bean
	public Scheduler scheduler() throws ParseException {
		return schedulerFactoryBean().getScheduler();
	}

}