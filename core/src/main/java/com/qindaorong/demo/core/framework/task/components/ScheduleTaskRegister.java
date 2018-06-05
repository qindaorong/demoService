package com.qindaorong.demo.core.framework.task.components;

import com.qindaorong.demo.core.framework.task.domin.DemoTask;
import com.qindaorong.demo.core.framework.task.domin.JobContext;
import com.qindaorong.demo.core.framework.task.domin.JobContext.ContextBuilder;
import com.qindaorong.demo.core.framework.task.domin.JobResult;
import com.qindaorong.demo.core.framework.task.enums.JobContextKeyEnum;
import com.qindaorong.demo.core.framework.task.enums.JobTypeEnum;
import com.qindaorong.demo.core.framework.task.factory.ScheduleTaskConfigResolver;
import com.qindaorong.demo.core.framework.task.service.JobManagement;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * ScheduleTaskRegister
 *
 * @author qindaorong
 * @create 2018-06-05 2:13 PM
 **/
@Component
public class ScheduleTaskRegister {
    
    private static Logger log = LoggerFactory.getLogger(ScheduleTaskRegister.class);
    
    
    private ScheduleTaskConfigResolver resolver = new ScheduleTaskConfigResolver();
    private List<DemoTask> demoTasks;
    
    @Autowired
    private JobManagement jobManagement;
    
    @PostConstruct
    public void init(){
        
        //load xml data
        demoTasks = resolver.resolveScheduleTaskConfiguration();

        if (!CollectionUtils.isEmpty(demoTasks)) {
            for (DemoTask task : demoTasks) {
                if(task.getEnable()){
                    quartzJobWrapper(task);
                }
            }
        }
    }
    
    /**
     * 配置文件启动调度
     * @param task
     */
    private void quartzJobWrapper(DemoTask task){
        JobResult jobResult = new JobResult();
        ContextBuilder contextBuilder = new JobContext.ContextBuilder();
        jobResult.setTaskId(task.getTaskId());
        jobResult.setServiceName(task.getExecuteClass());
        jobResult.setJobSwitch(task.getEnable());
        contextBuilder.setExecuteClass(task.getExecuteClass())
            .setCron(task.getCron())
            .setEnable(task.getEnable())
            .setTaskId(task.getTaskId())
            .setGroupName(task.getGroupName())
            .setFileType(task.getFileType())
            .setFileName(task.getFileName())
            .setModelType(task.getModelType())
            .setEmailId(task.getEmailId())
        ;
        if (StringUtils.hasText(task.getExecuteClass())) {
            contextBuilder.setExecuteClass(task.getExecuteClass());
        }
        if (Objects.nonNull(task.getSqlConfiguration())) {
            contextBuilder.setLimit(task.getSqlConfiguration().getLimit());
            contextBuilder.setLimitSwitch(task.getSqlConfiguration().getLimitSwitch());
        }
        if (JobTypeEnum.ALARM.getType().equals(task.getType())) {
            if (!StringUtils.hasText(task.getExecuteClass())) {
                contextBuilder.setExecuteClass(JobContextKeyEnum.DEFAULT_ALARM_JOB_CLASS.getKey());
                jobResult.setServiceName(JobContextKeyEnum.DEFAULT_ALARM_JOB_CLASS.getKey());
            } else {
                contextBuilder.setExecuteClass(task.getExecuteClass());
                jobResult.setServiceName(task.getExecuteClass());
            }
            contextBuilder.setSql(task.getSqlConfiguration().getCheckSql());
        } else if (JobTypeEnum.REPORT.getType().equals(task.getType())) {
            if (!StringUtils.hasText(task.getExecuteClass())) {
                contextBuilder.setExecuteClass(JobContextKeyEnum.DEFAULT_REPORT_JOB_CLASS.getKey());
                jobResult.setServiceName(JobContextKeyEnum.DEFAULT_REPORT_JOB_CLASS.getKey());
            } else {
                contextBuilder.setExecuteClass(task.getExecuteClass());
                jobResult.setServiceName(task.getExecuteClass());
            }
            contextBuilder.setSql(task.getSqlConfiguration().getCheckSql());
        } else {
            contextBuilder.setExecuteClass(task.getExecuteClass());
            jobResult.setServiceName(JobContextKeyEnum.DEFAULT_NORMAL_JOB_CLASS.getKey());
        }
        contextBuilder.setJobResult(jobResult);
        jobManagement.startJob(contextBuilder.build());
    }
    
}
