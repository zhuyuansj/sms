package com.paic.loancloud.sms.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by sunjian on 2017/4/5.
 */
//@Component
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor{
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        try (InputStream input = new FileInputStream("classpath:democonfig.properties")){
            Properties source = new Properties();
            source.load(input);
            PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource("my",source);
            environment.getPropertySources().addLast(propertiesPropertySource);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
