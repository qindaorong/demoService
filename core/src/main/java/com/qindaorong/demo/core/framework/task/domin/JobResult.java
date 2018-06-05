package com.qindaorong.demo.core.framework.task.domin;

import org.joda.time.DateTime;

/**
 * Created by Michael on 11/27/2017.
 * @author Michael
 */
public class JobResult {
    
    private String taskId;
    private String serviceName;
    
    private DateTime startTime;
    
    private DateTime endTime;
    
    private Long duration;
    
    private boolean jobSwitch;
    
    private String result;
    
    private Integer effectedRow;
    
    
    public String getTaskId() {
        return taskId;
    }
    
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    
    public String getServiceName() {
        return serviceName;
    }
    
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    
    public DateTime getStartTime() {
        return startTime;
    }
    
    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }
    
    public DateTime getEndTime() {
        return endTime;
    }
    
    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }
    
    public Long getDuration() {
        return duration;
    }
    
    public void setDuration(Long duration) {
        this.duration = duration;
    }
    
    public boolean getJobSwitch() {
        return jobSwitch;
    }
    
    public void setJobSwitch(boolean jobSwitch) {
        this.jobSwitch = jobSwitch;
    }
    
    
    public String getResult() {
        return result;
    }
    
    public void setResult(String result) {
        this.result = result;
    }
    
    public Integer getEffectedRow() {
        return effectedRow;
    }
    
    public void setEffectedRow(Integer effectedRow) {
        this.effectedRow = effectedRow;
    }
    
    @Override
    public String toString() {
        return "JobResult{" +
            "taskId='" + taskId + '\'' +
            ", serviceName='" + serviceName + '\'' +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", duration=" + duration +
            ", jobSwitch=" + jobSwitch +
            ", result='" + result + '\'' +
            ", effectedRow=" + effectedRow +
            '}';
    }
    
    
    
}
