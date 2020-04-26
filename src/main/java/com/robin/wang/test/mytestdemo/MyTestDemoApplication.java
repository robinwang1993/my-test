package com.robin.wang.test.mytestdemo;

import com.robin.wang.test.mytestdemo.test.MyAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyTestDemoApplication {
    @MyAnnotation
    public static void main(String[] args) {
        SpringApplication.run(MyTestDemoApplication.class, args);
    }

}
