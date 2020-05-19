package com.robin.wang.test.mytestdemo.test.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationContextEvent;

@Configuration
public class ListenerConfig {

    //Spring 的listener 却想通过servlet的listener进行注入
  /*  @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean();

        registrationBean.setListener(new ApplicationListener<ApplicationContextEvent>() {
            @Override
            public void onApplicationEvent(ApplicationContextEvent event) {
                SpringBeanUtils.setApplicationContextByRegisterBean(event.getApplicationContext());
            }
        });
        return registrationBean;
    }*/

    @Bean
    CustApplicationListener myListener() {
        return new CustApplicationListener();
    }
}

class CustApplicationListener implements ApplicationListener<ApplicationContextEvent> {
    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        SpringBeanUtils.setApplicationContextByRegisterBean(event.getApplicationContext());
    }
}
