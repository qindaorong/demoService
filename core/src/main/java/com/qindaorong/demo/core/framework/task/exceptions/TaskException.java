package com.qindaorong.demo.core.framework.task.exceptions;

/**
 * TaskException
 *
 * @author qindaorong
 * @create 2018-06-05 3:41 PM
 **/
public class TaskException extends RuntimeException {
    
    private String code;
    
    public TaskException(String code,String message){
        super(message);
        this.code = code;
    }
    
    public TaskException(String message){
        super(message);
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
}
