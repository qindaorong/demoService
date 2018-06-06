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
        List<DemoTask> demoTasklist = null;
        scheduleTaskConfigurations = reader.getConfigList();
        if(!CollectionUtils.isEmpty(scheduleTaskConfigurations)){
            demoTasklist = new ArrayList<>(scheduleTaskConfigurations.size());
            for(ScheduleTaskConfiguration configuration : scheduleTaskConfigurations){
                if(Objects.isNull(configuration)){
                    throw new TaskException("Your taskId in ScheduleTask annotation is wrong.");
                }
                if(Objects.isNull(configuration.getEnable())){
                    throw new TaskException("Job switch attribute can not be null.");
                }
                if (!StringUtils.hasText(configuration.getGroupName())) {
                    throw new TaskException("Job groupName attribute can not be null.");
                }
                if (!StringUtils.hasText(configuration.getJobType())) {
                    throw new TaskException("type attribute can not be null.");
                }
                if (!StringUtils.hasText(configuration.getTaskId())) {
                    throw new TaskException("taskId attribute can not be null.");
                }

                DemoTask demoTask = new DemoTask();
                BeanUtils.copyProperties(configuration, demoTask);
                demoTasklist.add(demoTask);
            }
        }
        
        return demoTasklist;
    }
    
}
