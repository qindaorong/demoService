package com.qindaorong.demo.core.framework.task.interfaces;

import org.quartz.JobExecutionContext;

/**
 * Created by Michael on 11/27/2017.
 */
public interface IScheduleTask {
    void doTask(JobExecutionContext context);
}
