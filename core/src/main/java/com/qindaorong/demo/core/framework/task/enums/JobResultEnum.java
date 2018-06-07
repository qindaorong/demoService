package com.qindaorong.demo.core.framework.task.enums;

/**
 * JobResultEnum
 *
 * @author qindaorong
 * @create 2018-06-05 10:51 AM
 **/
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
