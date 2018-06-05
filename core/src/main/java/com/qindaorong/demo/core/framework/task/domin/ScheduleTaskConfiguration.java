package com.qindaorong.demo.core.framework.task.domin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * ScheduleTaskConfiguration
 *
 * @author qindaorong
 * @create 2018-06-05 3:41 PM
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
})
@XmlRootElement(name="service")
public class ScheduleTaskConfiguration {
    @XmlAttribute(name="taskId")
    private String taskId;
    
    @XmlAttribute(name="enable")
    private Boolean enable;
    
    @XmlAttribute(name="cron")
    private String cron;
    
    @XmlAttribute(name="fixRate")
    private String fixRate;
    
    @XmlAttribute(name="className")
    private String className;
    
    @XmlAttribute(name="other")
    private String other;
    
    @XmlAttribute(name="groupName")
    private String groupName;
    
    @XmlAttribute(name="executeClass")
    private String executeClass;
    
    @XmlElement(name = "sql")
    private ScheduleTaskSqlConfiguration sqlConfiguration;
    
    @XmlAttribute(name = "type")
    private String type;
    
    @XmlAttribute(name = "fileType")
    private String fileType;
    
    @XmlAttribute(name = "fileName")
    private String fileName;
    
    @XmlAttribute(name = "modelType")
    private String modelType;
    
    @XmlAttribute(name = "emailId")
    private String emailId;
    
    public String getTaskId() {
        return taskId;
    }
    
    public Boolean getEnable() {
        return enable;
    }
    
    public String getCron() {
        return cron;
    }
    
    public String getFixRate() {
        return fixRate;
    }
    
    public String getClassName() {
        return className;
    }
    
    public String getOther() {
        return other;
    }
    
    public String getGroupName() {
        return groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
    
    public void setCron(String cron) {
        this.cron = cron;
    }
    
    public void setFixRate(String fixRate) {
        this.fixRate = fixRate;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }
    
    public void setOther(String other) {
        this.other = other;
    }
    
    public String getExecuteClass() {
        return executeClass;
    }
    
    public void setExecuteClass(String executeClass) {
        this.executeClass = executeClass;
    }
    
    public ScheduleTaskSqlConfiguration getSqlConfiguration() {
        return sqlConfiguration;
    }
    
    public void setSqlConfiguration(ScheduleTaskSqlConfiguration sqlConfiguration) {
        this.sqlConfiguration = sqlConfiguration;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
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
}
