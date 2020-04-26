package com.robin.wang.test.mytestdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class MyConfiguration {

    @Bean("myBean")
    public String getMyBean(){
        return "Hello World!";
    }
}
