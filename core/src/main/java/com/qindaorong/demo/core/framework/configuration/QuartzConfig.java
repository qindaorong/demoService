package com.qindaorong.demo.core.framework.configuration;

import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;


/**
 * QuartzConfig
 *
 * @author qindaorong
 * @create 2018-06-07 9:27 AM
 **/
@Configuration
@EnableAutoConfiguration
public class QuartzConfig {
    
    private static Logger logger = LoggerFactory.getLogger(QuartzConfig.class);

    
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(ApplicationContext applicationContext) {
        return new SchedulerFactoryBean();
    }
    
    @Bean
    public Scheduler scheduler(ApplicationContext applicationContext) {
        return schedulerFactoryBean(applicationContext).getObject();
    }
}
