package com.qindaorong.demo.core.framework.task.domin;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ScheduleTaskConfigurationRoot
 *
 * @author qindaorong
 * @create 2018-06-05 3:41 PM
 **/
@XmlRootElement(name="ScheduleService")
public class ScheduleTaskConfigurationRoot {
    
    @XmlElement(name = "service")
    private List<ScheduleTaskConfiguration> scheduleTaskConfigurations;
    
    public List<ScheduleTaskConfiguration> getScheduleTaskConfigurations() {
        return scheduleTaskConfigurations;
    }
    
}
