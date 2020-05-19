package com.robin.wang.test.mytestdemo.test.listener;

import org.springframework.context.ApplicationContext;

public class SpringBeanUtils {

    private static ApplicationContext applicationContextByFactories;
    private static ApplicationContext applicationContextByAnnotation;
    private static ApplicationContext applicationContextByRegisterBean;


    public static ApplicationContext getApplicationContextByRegisterBean() {
        return applicationContextByRegisterBean;
    }

    public static void setApplicationContextByRegisterBean(ApplicationContext applicationContextByRegisterBean) {
        SpringBeanUtils.applicationContextByRegisterBean = applicationContextByRegisterBean;
    }

    public static ApplicationContext getApplicationContextByAnnotation() {
        return applicationContextByAnnotation;
    }

    public static void setApplicationContextByAnnotation(ApplicationContext applicationContextByAnnotation) {
        SpringBeanUtils.applicationContextByAnnotation = applicationContextByAnnotation;
    }

    public static ApplicationContext getApplicationContextByFactories() {
        return applicationContextByFactories;
    }

    public static void setApplicationContextByFactories(ApplicationContext applicationContextByFactories) {
        SpringBeanUtils.applicationContextByFactories = applicationContextByFactories;
    }
}