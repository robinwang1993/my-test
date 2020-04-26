package com.robin.wang.test.mytestdemo.configuration;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableHelloWorldAnnotation
public class TestConfiguration {
    public static void main(String[] args) {
        SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder(TestConfiguration.class);
        ConfigurableApplicationContext context = applicationBuilder.web(WebApplicationType.NONE).run(args);
        String myBean = context.getBean("myBean", String.class);
        System.out.println(myBean);
    }
}
