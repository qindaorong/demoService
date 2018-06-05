package com.qindaorong.demo.core.framework.task.enums;

/**
 * Created by Michael on 2/28/2018.
 */
public enum JobTypeEnum {
    NORMAL("normal"),
    REPORT("report"),
    ALARM("alarm");
    
    private String type;
    
    JobTypeEnum(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
}
