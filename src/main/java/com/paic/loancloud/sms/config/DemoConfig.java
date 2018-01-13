package com.paic.loancloud.sms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * Created by sunjian on 2017/4/4.
 * @Configuration和@PropertySource是用来直接读取democonfig.properties的属性配置文件的
 */
//@Configuration
//@PropertySource("classpath:democonfig.properties")
//@PropertySources({@PropertySource("classpath:democonfig.properties"),@PropertySource("classpath:democonfig.properties")})用来直接配置多个属性文件
//@ConfigurationProperties(prefix = "ds")
//@Component
public class DemoConfig {
}
