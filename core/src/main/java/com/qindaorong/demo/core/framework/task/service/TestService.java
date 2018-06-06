package com.qindaorong.demo.core.framework.task.service;

import com.qindaorong.demo.core.framework.annotation.ScheduleSwitch;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

/**
 * TestService
 *
 * @author qindaorong
 * @create 2018-06-05 4:56 PM
 **/
@ScheduleSwitch
@Service
public class TestService implements Job{
    
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("I am TestService! I worked !!!");
    }
}
