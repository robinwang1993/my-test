package com.robin.wang.test.mytestdemo;

import com.robin.wang.test.mytestdemo.test.MyAnnotation;
import com.robin.wang.test.mytestdemo.test.listener.SpringBeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyTestDemoApplication {
    static ApplicationContext applicationContext;

    @MyAnnotation
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MyTestDemoApplication.class, args);
        MyTestDemoApplication.applicationContext = applicationContext;
    }

    @RequestMapping("/test")
    public String test() {
        ApplicationContext applicationContext = SpringBeanUtils.getApplicationContextByAnnotation();
        System.out.println(applicationContext);
        ApplicationContext byFactories = SpringBeanUtils.getApplicationContextByFactories();
        System.out.println(byFactories);
        ApplicationContext byRegisterBean = SpringBeanUtils.getApplicationContextByRegisterBean();
        System.out.println(byRegisterBean);
        return "test";
    }
}
