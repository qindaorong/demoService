package com.qindaorong.demo.core.framework.task.domin;

import java.io.Serializable;

/**
 * DemoTask
 *
 * @author qindaorong
 * @create 2018-06-05 10:51 AM
 **/
public class DemoTask implements Serializable{

    private String taskId;

    private Boolean enable;

    private String cron;

    private String fixRate;

    private String className;

    private String other;

    private String groupName;

    private String executeClass;

    private String type;
    
    public String getTaskId() {
        return taskId;
    }
    
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    
    public Boolean getEnable() {
        return enable;
    }
    
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
    
    public String getCron() {
        return cron;
    }
    
    public void setCron(String cron) {
        this.cron = cron;
    }
    
    public String getFixRate() {
        return fixRate;
    }
    
    public void setFixRate(String fixRate) {
        this.fixRate = fixRate;
    }
    
    public String getClassName() {
        return className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }
    
    public String getOther() {
        return other;
    }
    
    public void setOther(String other) {
        this.other = other;
    }
    
    public String getGroupName() {
        return groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public String getExecuteClass() {
        return executeClass;
    }
    
    public void setExecuteClass(String executeClass) {
        this.executeClass = executeClass;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
