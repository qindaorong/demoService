package com.qindaorong.demo.core.framework.task.enums;

/**
 * Created by Michael on 2/28/2018.
 */
public enum JobTypeEnum {
    NORMAL("normal"),//普通任务
    REPORT("report"),//报表任务
    ALARM("alarm");//报警任务
    
    private String type;
    
    JobTypeEnum(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
}
