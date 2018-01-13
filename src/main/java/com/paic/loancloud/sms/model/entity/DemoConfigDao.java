package com.paic.loancloud.sms.model.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by sunjian on 2017/4/4.
 */
@Component
public class DemoConfigDao {
//    spring.datasource.username = root
//    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
    @Value("spring.datasource.username")
    private String username;

    @Value("spring.datasource.driver-class-name")
    private String name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemoConfigDao{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
