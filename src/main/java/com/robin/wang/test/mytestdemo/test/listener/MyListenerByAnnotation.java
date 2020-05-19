package com.robin.wang.test.mytestdemo.test.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;


/**
 * @author Robin
 */
@Component
public class MyListenerByAnnotation implements ApplicationContextInitializer {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyListenerByAnnotation.class);
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        LOGGER.info("-------------------------------------------");
        SpringBeanUtils.setApplicationContextByAnnotation(applicationContext);
    }
}
