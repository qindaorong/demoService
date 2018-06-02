package com.qindaorong.demo.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * CoreApplication
 *
 * @author qindaorong
 * @create 2018-06-02 9:53 AM
 **/
@SpringBootApplication
public class CoreApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(
      SpringApplicationBuilder application) {
        return application.sources(CoreApplication.class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }
}
