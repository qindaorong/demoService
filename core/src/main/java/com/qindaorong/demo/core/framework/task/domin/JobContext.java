package com.qindaorong.demo.core.framework.task.domin;


/**
 * JobContext
 *
 * @author qindaorong
 * @create 2018-06-05 12:01 PM
 **/
public class JobContext {
    
    private Boolean enable;
    private String taskId;
    private String className;
    
    private String cron;
    
    private String fixRate;
    
    private String groupName;
    
    private String executeClass;
    
    private String sql;
    
    private String status;
    
    private String limit;
    
    private Boolean limitSwitch;
    
    private String fileType;
    
    private String fileName;
    
    private String modelType;
    
    private String emailId;
    
    private JobResult jobResult;
    
    
    private JobContext(ContextBuilder builder) {
        this.enable = builder.enable;
        this.className = builder.className;
        this.cron = builder.cron;
        this.executeClass = builder.executeClass;
        this.fixRate = builder.fixRate;
        this.groupName = builder.groupName;
        this.sql = builder.sql;
        this.taskId = builder.taskId;
        this.limit = builder.limit;
        this.limitSwitch = builder.limitSwitch;
        this.fileType = builder.fileType;
        this.fileName = builder.fileName;
        this.modelType = builder.modelType;
        this.emailId = builder.emailId;
        this.jobResult = builder.jobResult;
    }
    
    public static class ContextBuilder {
        
        private Boolean enable;
        private String taskId;
        private String className;
        private String cron;
        private String fixRate;
        private String groupName;
        private String executeClass;
        private String sql;
        private String limit;
        private Boolean limitSwitch;
        private String fileType;
        private String fileName;
        private String modelType;
        private String emailId;
        private JobResult jobResult;
        
        public ContextBuilder() {
        }
        
        public ContextBuilder setSql(String sql) {
            this.sql = sql;
            return this;
        }
        
        public ContextBuilder setGroupName(String groupName) {
            this.groupName = groupName;
            return this;
        }
        
        public ContextBuilder setClassName(String className) {
            this.className = className;
            return this;
        }
        
        public ContextBuilder setFixRate(String fixRate) {
            this.fixRate = fixRate;
            return this;
        }
        
        public ContextBuilder setExecuteClass(String executeClass) {
            this.executeClass = executeClass;
            return this;
        }
        
        public ContextBuilder setEnable(boolean enable) {
            this.enable = enable;
            return this;
        }
        
        public ContextBuilder setCron(String cron) {
            this.cron = cron;
            return this;
        }
        
        public ContextBuilder setTaskId(String taskId) {
            this.taskId = taskId;
            return this;
        }
        
        public ContextBuilder setJobResult(JobResult jobResult) {
            this.jobResult = jobResult;
            return this;
        }
        
        public ContextBuilder setLimit(String limit) {
            this.limit = limit;
            return this;
        }
    
        public ContextBuilder setLimitSwitch(Boolean limitSwitch) {
            this.limitSwitch = limitSwitch;
            return this;
        }
    
        public ContextBuilder setFileType(String fileType) {
            this.fileType = fileType;
            return this;
        }
    
        public ContextBuilder setFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }
    
        public ContextBuilder setModelType(String modelType) {
            this.modelType = modelType;
            return this;
        }
    
        public ContextBuilder setEmailId(String emailId) {
            this.emailId = emailId;
            return this;
        }
        
        public JobContext build() {
            return new JobContext(this);
        }
    }
    
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
    
    public String getSql() {
        return sql;
    }
    
    public void setSql(String sql) {
        this.sql = sql;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public JobResult getJobResult() {
        return jobResult;
    }
    
    public void setJobResult(JobResult jobResult) {
        this.jobResult = jobResult;
    }
    
    public String getLimit() {
        return limit;
    }
    
    public void setLimit(String limit) {
        this.limit = limit;
    }
    
    public Boolean getLimitSwitch() {
        return limitSwitch;
    }
    
    public void setLimitSwitch(Boolean limitSwitch) {
        this.limitSwitch = limitSwitch;
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
        return "JobContext{" +
            "enable=" + enable +
            ", taskId='" + taskId + '\'' +
            ", className='" + className + '\'' +
            ", cron='" + cron + '\'' +
            ", fixRate='" + fixRate + '\'' +
            ", groupName='" + groupName + '\'' +
            ", executeClass='" + executeClass + '\'' +
            ", sql='" + sql + '\'' +
            ", status='" + status + '\'' +
            ", limit='" + limit + '\'' +
            ", limitSwitch=" + limitSwitch +
            ", fileType='" + fileType + '\'' +
            ", fileName='" + fileName + '\'' +
            ", modelType='" + modelType + '\'' +
            ", jobResult=" + jobResult +
            '}';
    }
}
