package com.qindaorong.demo.core.framework.task.service;

import com.qindaorong.demo.core.framework.annotation.ScheduleSwitch;
import com.qindaorong.demo.core.framework.task.interfaces.IScheduleTask;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Service;

/**
 * Created by Michael on 11/27/2017.
 * @author Michael
 */
@ScheduleSwitch
@Service
public class TestService implements IScheduleTask {
    
    @Override
    public void doTask(JobExecutionContext context) {
        System.out.println("I am TestService! I worked !!!");
    }
}
