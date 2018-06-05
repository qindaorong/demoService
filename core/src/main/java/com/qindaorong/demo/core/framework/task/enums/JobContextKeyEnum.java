package com.qindaorong.demo.core.framework.task.enums;

/**
 * Created by Michael on 2/28/2018.
 */
public enum JobContextKeyEnum {
    JOB_CONTEXT_KEY("jobContext"),
    DEFAULT_NORMAL_JOB_CLASS("com.nexttrucking.wiztruck.framework.schedule.service.task.DefaultJobService"),
    DEFAULT_ALARM_JOB_CLASS("com.nexttrucking.wiztruck.framework.schedule.service.task.DefaultAlarmJob"),
    DEFAULT_REPORT_JOB_CLASS("com.nexttrucking.wiztruck.framework.schedule.service.task.DefaultReportJob"),
    CHECK_SQL_DEFAULT_LIMIT("10");
    
    private String key;
    
    JobContextKeyEnum(String key) {
        this.key = key;
    }
    
    public String getKey() {
        return key;
    }
}
