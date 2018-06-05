package com.qindaorong.demo.core.framework.task.factory;


import com.qindaorong.demo.core.framework.configuration.ScheduleTaskConfigReader;
import com.qindaorong.demo.core.framework.task.domin.DemoTask;
import com.qindaorong.demo.core.framework.task.domin.ScheduleTaskConfiguration;
import com.qindaorong.demo.core.framework.task.enums.FileTypeEnum;
import com.qindaorong.demo.core.framework.task.enums.JobContextKeyEnum;
import com.qindaorong.demo.core.framework.task.enums.JobTypeEnum;
import com.qindaorong.demo.core.framework.task.exceptions.TaskException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * ScheduleTaskConfigResolver
 *
 * @author qindaorong
 * @create 2018-06-05 11:28 AM
 **/
public class ScheduleTaskConfigResolver {
    
    private ScheduleTaskConfigReader reader = new ScheduleTaskConfigReader();
    
    private List<ScheduleTaskConfiguration> scheduleTaskConfigurations;
    
    public List<DemoTask> resolveScheduleTaskConfiguration(){
        return nextTaskWrapper();
    }
    
    
    private List<DemoTask> nextTaskWrapper(){
        List<DemoTask> demoTasks = null;
        scheduleTaskConfigurations = reader.getConfigList();
        if(!CollectionUtils.isEmpty(scheduleTaskConfigurations)){
            demoTasks = new ArrayList<>();
            for(ScheduleTaskConfiguration configuration : scheduleTaskConfigurations){
                if(Objects.isNull(configuration)){
                    throw new TaskException("Your taskId in ScheduleTask annotation is wrong.");
                }
                if(!StringUtils.hasText(configuration.getCron())
                    && !StringUtils.hasText(configuration.getFixRate())){
                    throw new TaskException("Cron attribute can not be null.");
                }
                if(Objects.isNull(configuration.getEnable())){
                    throw new TaskException("Job switch attribute can not be null.");
                }
                if (!StringUtils.hasText(configuration.getGroupName())) {
                    throw new TaskException("Job groupName attribute can not be null.");
                }
                if (Objects.nonNull(configuration.getSqlConfiguration())) {
                    if (!StringUtils.hasText(configuration.getSqlConfiguration().getLimit())) {
                        configuration.getSqlConfiguration().setLimit(JobContextKeyEnum.CHECK_SQL_DEFAULT_LIMIT.getKey());
                    }
                    if (Objects.isNull(configuration.getSqlConfiguration().getLimitSwitch())) {
                        configuration.getSqlConfiguration().setLimitSwitch(Boolean.TRUE);
                    }
                }
                if (!StringUtils.hasText(configuration.getType())) {
                    throw new TaskException("type attribute can not be null.");
                }
                if (!StringUtils.hasText(configuration.getTaskId())) {
                    throw new TaskException("taskId attribute can not be null.");
                }
                if (StringUtils.hasText(configuration.getType())) {
                    if (JobTypeEnum.REPORT.getType().equals(configuration.getType())) {
                        if (!StringUtils.hasText(configuration.getFileType())) {
                            throw new TaskException(
                                "If your job type is alarm or report, you must have a fileType.Such as csv or xlsx.");
                        }
                        if (Objects.isNull(FileTypeEnum.fileTypeOf(configuration.getFileType()))) {
                            throw new TaskException("Your fileType is not in csv or xlsx file type.");
                        }
                        if (!StringUtils.hasText(configuration.getFileName())) {
                            throw new TaskException("If your job type is report, you must have a file name.");
                        }
                        if (!StringUtils.hasText(configuration.getModelType())) {
                            throw new TaskException("If your job type is report, you must have a modelType to build path.");
                        }
                        if (!StringUtils.hasText(configuration.getEmailId())) {
                            throw new TaskException("If your job type is report, you must have a emailId to sendEmail.");
                        }
                    }
                }
                DemoTask demoTask = new DemoTask();
                BeanUtils.copyProperties(configuration, demoTask);
                demoTasks.add(demoTask);
            }
        }
        
        return demoTasks;
    }
    
}
