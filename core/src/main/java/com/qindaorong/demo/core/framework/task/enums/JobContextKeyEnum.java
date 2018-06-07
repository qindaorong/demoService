package com.qindaorong.demo.core.framework.task.enums;

/**
 * JobContextKeyEnum
 *
 * @author qindaorong
 * @create 2018-06-05 10:51 AM
 **/
public enum JobContextKeyEnum {
    JOB_CONTEXT_KEY("jobContext");
    
    private String key;
    
    JobContextKeyEnum(String key) {
        this.key = key;
    }
    
    public String getKey() {
        return key;
    }
}
