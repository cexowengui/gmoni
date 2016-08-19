package angus.gmoni.service.quartz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
@ComponentScan("angus.gmoni.service.impl")
public class QuartzConfig {

	// MethodInvokingJobDetailFactoryBean在spring-context-support中
	// create a jobDetail named collectEverythingJobDetail
	@Bean
	public MethodInvokingJobDetailFactoryBean collectEverythingJobDetailFactoryBean() {
		MethodInvokingJobDetailFactoryBean obj = new MethodInvokingJobDetailFactoryBean();
		obj.setTargetBeanName("collectService");
		obj.setTargetMethod("collectEverything");
		obj.setConcurrent(false);
		return obj;
	}

	// config trigger for collectEverything job detail
	// Job is scheduled after every 5 SECOND
	@Bean
	public CronTriggerFactoryBean collectEverythingCronTriggerFactoryBean() {
		CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
		stFactory.setJobDetail(collectEverythingJobDetailFactoryBean().getObject());
		stFactory.setStartDelay(3000);
		stFactory.setName("mytrigger");
		stFactory.setGroup("mygroup");
		stFactory.setCronExpression("5 * * * * ?");//
		return stFactory;
	}
	
	
	//还有其他定时任务
	
	
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
		scheduler.setTriggers(collectEverythingCronTriggerFactoryBean().getObject());
		return scheduler;
	}

}
