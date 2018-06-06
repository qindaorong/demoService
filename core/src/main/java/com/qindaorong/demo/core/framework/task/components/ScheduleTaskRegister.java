package com.qindaorong.demo.core.framework.task.components;

import com.qindaorong.demo.core.framework.task.domin.DemoTask;
import com.qindaorong.demo.core.framework.task.factory.JobFactory;
import com.qindaorong.demo.core.framework.task.factory.ScheduleTaskConfigResolver;
import java.util.List;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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
    private JobFactory jobFactory;
    
    @PostConstruct
    public void init(){
        
        //load xml data
        demoTasks = resolver.resolveScheduleTaskConfiguration();

        if (!CollectionUtils.isEmpty(demoTasks)) {
            for (DemoTask task : demoTasks) {
                if(task.getEnable()){
                    //装配到工厂准备开启管理
                    jobFactory.loadNewJob(task);
                }
            }
        }
    }
    
}
