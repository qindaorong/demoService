package com.qindaorong.demo.core.framework.task.enums;

/**
 * Created by Michael on 11/27/2017.
 */
public enum JobResultEnum {
    SUCCESS("success"),
    FAILED("failed")
    ;
    private String status;
    
    JobResultEnum(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }
}
