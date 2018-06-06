package com.qindaorong.demo.core.framework.task.factory;

import com.qindaorong.demo.core.framework.task.domin.DemoTask;
import com.qindaorong.demo.core.framework.task.enums.JobContextKeyEnum;
import java.util.concurrent.ConcurrentHashMap;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * JobFactory
 *
 * @author qindaorong
 * @create 2018-06-05 4:56 PM
 **/
@Configuration
@Import(JobFactory.class)
public class JobFactory implements ImportBeanDefinitionRegistrar {
    
    private static final Logger log = LoggerFactory.getLogger(JobFactory.class);
    
    private static final String BEAN_NAME = "jobFactory";
    
    @Autowired
    private Scheduler scheduler;
    
    /**
     * 已经加载在内存中的job
     */
    private static ConcurrentHashMap<String, DemoTask> concurrentMap = new ConcurrentHashMap<>();
    
    
    /**
     * 是否已经加载task
     * @param taskId
     * @return
     */
    public Boolean isExist(String taskId){
     if(concurrentMap.containsKey(taskId)){
         return Boolean.TRUE;
     }else{
         return Boolean.FALSE;
     }
    }
    
    /**
     * 添加新任务并启动
     * @param task
     */
    public void loadNewJob(DemoTask task){
        if(!isExist(task.getTaskId())){
            concurrentMap.put(task.getTaskId(), task);
            this.startJob(task.getTaskId());
        }
    }
    
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        if (!registry.containsBeanDefinition(BEAN_NAME)) {
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(JobFactory.class);
            beanDefinition.setSynthetic(true);
            registry.registerBeanDefinition(BEAN_NAME, beanDefinition);
        }
    }
    
    
    /**
     * 开始启动
     * @param taskId
     */
    public void startJob(String taskId){
        
        DemoTask task = concurrentMap.get(taskId);
        try {
    
            JobKey jobKey = new JobKey(taskId, task.getGroupName());
            Class jobClazz = Class.forName(task.getExecuteClass());
    
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put(JobContextKeyEnum.JOB_CONTEXT_KEY.getKey(), task);
            
            JobDetail jobDetail = JobBuilder.newJob(jobClazz)
              .withIdentity(jobKey)
              .usingJobData(jobDataMap)
              .build();
    
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(task.getCron());
            CronTrigger trigger = TriggerBuilder.newTrigger()
              .withSchedule(cronScheduleBuilder).forJob(jobDetail).build();
             scheduler.scheduleJob(jobDetail, trigger);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 暂停job
     * @param taskId
     */
    public void pauseJob(String taskId) {
        try {
            DemoTask task = concurrentMap.get(taskId);
            JobKey jobKey = new JobKey(taskId, task.getGroupName());
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }
    
    
    /**
     * 恢复job
     * @param taskId
     */
    public void resumeJob(String taskId) {
        try {
            DemoTask task = concurrentMap.get(taskId);
            JobKey jobKey = new JobKey(taskId, task.getGroupName());
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }
    
}
