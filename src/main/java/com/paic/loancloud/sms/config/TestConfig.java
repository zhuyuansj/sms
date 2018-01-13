package com.paic.loancloud.sms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjian on 2017/4/4.
 */
//@Component
//@ConfigurationProperties("ds")
public class TestConfig {

    //    spring.datasource.url = jdbc:mysql://localhost:3306/test
//    spring.datasource.username = root
//    spring.datasource.password = root
//    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
//    spring.datasource.max-active=20
//    spring.datasource.max-idle=8
//    spring.datasource.min-idle=8
//    spring.datasource.initial-size=10

    private List<String> hosts = new ArrayList<>();


    public List<String> getHosts() {
        return hosts;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

//    @Value("${spring.datasource.url}")
    private String url;

//    @Value("spring.datasource.username")
    private String username;

//    @Autowired//将环境对象注入
    private Environment environment;

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "TestConfig{" +
                "hosts=" + hosts.get(0) +"hosts=" + hosts.get(1)+
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", environment=" + environment +
                '}';
    }
}
