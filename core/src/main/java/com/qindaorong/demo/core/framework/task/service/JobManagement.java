package com.qindaorong.demo.core.framework.task.service;

import com.qindaorong.demo.core.framework.task.domin.JobContext;
import com.qindaorong.demo.core.framework.task.enums.JobContextKeyEnum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * JobManagement
 *
 * @author qindaorong
 * @create 2018-06-05 1:05 PM
 **/
@Service
public class JobManagement {
    
    private static final Logger log = LoggerFactory.getLogger(JobManagement.class);
    
    @Autowired
    private Scheduler scheduler;
    
    private Map<String, JobContext> taskMapContext = new HashMap<>();//this is a memory switch
    
    private List<String> groupNames = new ArrayList<>();
    
    public void startJob(JobContext context) {
        try {
            JobKey jobKey = new JobKey(context.getTaskId(), context.getGroupName());
            boolean isExist = scheduler.checkExists(jobKey);
            if (!isExist) {
                Class jobClazz = Class.forName(JobContextKeyEnum.DEFAULT_NORMAL_JOB_CLASS.getKey());
                JobDataMap jobDataMap = new JobDataMap();
                jobDataMap.put(JobContextKeyEnum.JOB_CONTEXT_KEY.getKey(), context);
                JobDetail jobDetail = JobBuilder.newJob(jobClazz)
                    .withIdentity(jobKey)
                    .usingJobData(jobDataMap)
                    .build();
                CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(context.getCron());
                CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withSchedule(cronScheduleBuilder).forJob(jobDetail).build();
                scheduler.scheduleJob(jobDetail, trigger);
                taskMapContext.put(context.getTaskId(), context);
                groupNames.add(context.getGroupName());
            }
        } catch (SchedulerException | ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }
    }
    
    public JobContext getTaskMapContext(String taskId) {
        return taskMapContext.get(taskId);
    }
    
    public Trigger.TriggerState getTriggerStateByJobKey(JobKey jobKey) {
        Trigger trigger;
        Trigger.TriggerState triggerState = null;
        try {
            trigger = scheduler.getTriggersOfJob(jobKey).get(0);
            triggerState = scheduler.getTriggerState(trigger.getKey());
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
        return triggerState;
    }
    
    public void pauseJob(JobKey jobKey) {
        try {
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }
    
    public void resumeJob(JobKey jobKey) {
        try {
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }
    
    public List<JobContext> getJobContexts() {
        List<JobContext> jobContexts = new ArrayList<>();
        List<String> jobGroupNames;
        JobDetail jobDetail;
        Set<JobKey> jobKeys;
        try {
            jobGroupNames = scheduler.getJobGroupNames();
            if (!CollectionUtils.isEmpty(jobGroupNames)) {
                for (String jobGroupName : jobGroupNames) {
                    if (groupNames.contains(jobGroupName)) {
                        jobKeys = scheduler.getJobKeys(GroupMatcher.groupContains(jobGroupName));
                        if (!CollectionUtils.isEmpty(jobKeys)) {
                            for (JobKey key : jobKeys) {
                                jobDetail = scheduler.getJobDetail(key);
                                JobContext context = (JobContext) jobDetail.getJobDataMap()
                                    .get(JobContextKeyEnum.JOB_CONTEXT_KEY.getKey());
                                List<? extends Trigger> triggers = scheduler.getTriggersOfJob(key);
                                if (!CollectionUtils.isEmpty(triggers)) {
                                    Trigger.TriggerState triggerState = scheduler.getTriggerState(triggers.get(0).getKey());
                                    context.setStatus(triggerState.name());
                                }
                                jobContexts.add(context);
                            }
                        }
                    }
                }
            }
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
        return jobContexts;
    }
    
}
