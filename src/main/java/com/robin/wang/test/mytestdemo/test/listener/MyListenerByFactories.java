package com.robin.wang.test.mytestdemo.test.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * @author Robin
 */
public class MyListenerByFactories implements ApplicationContextInitializer {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyListenerByFactories.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        LOGGER.info("****************************");
        SpringBeanUtils.setApplicationContextByFactories(applicationContext);
    }
}
