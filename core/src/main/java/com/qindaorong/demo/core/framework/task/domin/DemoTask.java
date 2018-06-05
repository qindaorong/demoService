package com.qindaorong.demo.core.framework.task.domin;

/**
 * ScheduleTaskConfigResolver
 *
 * @author qindaorong
 * @create 2018-06-05 10:51 AM
 **/
public class DemoTask {
    
    private Boolean enable;
    private String taskId;
    private String className;
    
    private String cron;
    
    private String fixRate;
    
    private String groupName;
    
    private String executeClass;
    
    private String type;
    
    private ScheduleTaskSqlConfiguration sqlConfiguration;
    
    private String fileType;
    
    private String fileName;
    
    private String modelType;
    
    private String emailId;
    
    public Boolean getEnable() {
        return enable;
    }
    
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
    
    public String getTaskId() {
        return taskId;
    }
    
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    
    public String getClassName() {
        return className;
    }
    
    public void setClassName(String className) {
        this.className = className;
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
    
    public ScheduleTaskSqlConfiguration getSqlConfiguration() {
        return sqlConfiguration;
    }
    
    public void setSqlConfiguration(ScheduleTaskSqlConfiguration sqlConfiguration) {
        this.sqlConfiguration = sqlConfiguration;
    }
    
    public String getFileType() {
        return fileType;
    }
    
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    
    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public String getModelType() {
        return modelType;
    }
    
    public void setModelType(String modelType) {
        this.modelType = modelType;
    }
    
    public String getEmailId() {
        return emailId;
    }
    
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    @Override
    public String toString() {
        return "DemoTask{" +
            "enable=" + enable +
            ", taskId='" + taskId + '\'' +
            ", className='" + className + '\'' +
            ", cron='" + cron + '\'' +
            ", fixRate='" + fixRate + '\'' +
            ", groupName='" + groupName + '\'' +
            ", executeClass='" + executeClass + '\'' +
            ", type='" + type + '\'' +
            ", sqlConfiguration=" + sqlConfiguration +
            ", fileType='" + fileType + '\'' +
            ", fileName='" + fileName + '\'' +
            ", modelType='" + modelType + '\'' +
            '}';
    }
}
