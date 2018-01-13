package com.paic.loancloud;

import com.paic.loancloud.sms.config.SmsDemoConfig;
import com.paic.loancloud.sms.config.TestConfig;
import com.paic.loancloud.sms.model.entity.DemoConfigDao;
import com.paic.loancloud.sms.model.entity.SmsDemoDao;
import com.paic.loancloud.sms.model.entity.Test;
import com.paic.loancloud.sms.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.FileInputStream;
import java.io.InputStream;

@SpringBootApplication
@EnableScheduling//用来开启定时任务
//@ServletComponentScan
//@ComponentScan
//@EnableTransactionManagement
public class SmsApplication extends SpringBootServletInitializer {

	/**注册Spring Util
	 * 这里为了和上一个冲突，所以方面名为：springUtil2
	 * 实际中使用springUtil
	 */
	@Bean
	public SpringUtil springUtil2(){return new SpringUtil();}

//	@Bean
//	public SmsDemoDao getSms(){
//		return new SmsDemoDao();
//	}

	public static void main(String[] args) {
//		SpringApplication.run(SmsApplication.class, args);
		ConfigurableApplicationContext run = SpringApplication.run(SmsApplication.class, args);
//		SmsDemoDao smsDemoDao = (SmsDemoDao) run.getBean("getSms");
//		Test test = run.getBean(Test.class);
//		test.setName("孙坚");
//		test.setPassword("123");
//		System.out.println(test.toString());
//		TConfig bean = run.getBean(TestConfig.class);
//		System.out.println(bean);
//		DemoConfigDao bean = run.getBean(DemoConfigDao.class);
//		System.out.println(bean);
//		String property = run.getEnvironment().getProperty("spring.datasource.username");
//		System.out.println("property==>"+property);
//		TestConfig bean = run.getBean(TestConfig.class);
//		System.out.println("bean==>"+bean);

	}
}
