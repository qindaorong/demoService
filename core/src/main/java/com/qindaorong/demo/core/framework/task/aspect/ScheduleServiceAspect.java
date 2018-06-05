package com.qindaorong.demo.core.framework.task.aspect;

import com.qindaorong.demo.core.framework.task.domin.JobContext;
import com.qindaorong.demo.core.framework.task.domin.JobResult;
import com.qindaorong.demo.core.framework.task.enums.JobContextKeyEnum;
import com.qindaorong.demo.core.framework.task.enums.JobResultEnum;
import java.util.Objects;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.joda.time.DateTime;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Michael on 11/27/2017.
 */
@Aspect
@Component
public class ScheduleServiceAspect {
    
    private static final Logger log = LoggerFactory.getLogger(ScheduleServiceAspect.class);
    
    @Pointcut("@within(com.qindaorong.demo.core.framework.annotation.ScheduleSwitch)")
    public void scheduleServicePointcut(){
    }
    
    @Around("scheduleServicePointcut()")
    public void scheduleServiceAround(ProceedingJoinPoint joinPoint){
        JobResult jobResult = null;
        JobContext jobContext = null;
        try{
            log.info("[scheduleServiceAround] start execute.........................");
            Object[] objArray = joinPoint.getArgs();
            JobExecutionContext context = (JobExecutionContext) objArray[0];
            jobContext = (JobContext) context.getJobDetail().getJobDataMap().get(JobContextKeyEnum.JOB_CONTEXT_KEY.getKey());
            jobResult = jobContext.getJobResult();
            if(Objects.isNull(jobResult)){
                log.error("[scheduleServiceAround] Can not find JobResult Object");
                throw new Throwable("[scheduleServiceAround] Can not find JobResult Object");
            }
            DateTime startTime = DateTime.now();
            jobResult.setStartTime(startTime);
            log.info("[scheduleServiceAround] job execute start and taskId = {}........",jobResult.getTaskId());
            joinPoint.proceed();
            log.info("[scheduleServiceAround] job execute end and taskId = {}..........",jobResult.getTaskId());
            DateTime endTime = DateTime.now();
            jobResult.setEndTime(endTime);
            jobResult.setResult(JobResultEnum.SUCCESS.getStatus());
            long duration = (jobResult.getEndTime().getMillis() - jobResult.getStartTime().getMillis())/1000;
            jobResult.setDuration(duration);
            log.info("[scheduleServiceAround|{}] job result = {} and taskId = {}",JobResultEnum.SUCCESS.getStatus(),jobResult,jobResult.getTaskId());
            log.info("[scheduleServiceAround] job execute success ----------------------------");
        }catch(Throwable  e){
            if(Objects.nonNull(jobResult)){
                log.error("[scheduleServiceAround] job execute failed and taskId = {} and error message = {}",
                    jobResult.getTaskId(), e.getMessage(), e);
                DateTime endTime = DateTime.now();
                jobResult.setEndTime(endTime);
                jobResult.setResult(JobResultEnum.FAILED.getStatus());
                long duration = (jobResult.getEndTime().getMillis() - jobResult.getStartTime().getMillis())/1000;
                jobResult.setDuration(duration);
                log.error("[scheduleServiceAround|{}] job result = {}",JobResultEnum.FAILED.getStatus(),jobResult);
            }else{
                log.error("[scheduleServiceAround] job execute failed and taskId is null.The error message = {}",e.getMessage(),e);
            }
        }
    }
}
