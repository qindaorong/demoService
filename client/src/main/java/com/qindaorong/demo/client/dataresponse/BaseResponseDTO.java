package com.qindaorong.demo.client.dataresponse;

/**
 * BaseResponseDTO
 *
 * @author qindaorong
 * @create 2018-06-02 10:43 AM
 **/
public class BaseResponseDTO<T> {
    private String code;
    private String describe;
    private String defaultDescribe;
    private T result;
    
    public BaseResponseDTO(String defaultDescribe) {
        this.code = "200";
        this.describe = "success";
        this.defaultDescribe = defaultDescribe;
    }
    
    public BaseResponseDTO(String code, String describe) {
        this.code = code;
        this.describe = describe;
    }
    
    public BaseResponseDTO() {
    }
    
    public BaseResponseDTO(String code, String describe, T result) {
        this.code = code;
        this.describe = describe;
        this.result = result;
    }
    
    public String getDefaultDescribe() {
        return this.defaultDescribe;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getDescribe() {
        return this.describe;
    }
    
    public void setDescribe(String describe) {
        this.describe = describe;
    }
    
    public T getResult() {
        return this.result;
    }
    
    public void setResult(T result) {
        this.result = result;
    }
}
