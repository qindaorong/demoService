package com.qindaorong.demo.client.exceptions;

import com.qindaorong.demo.client.dto.TestError;
import com.qindaorong.demo.client.enums.ErrorCodeEnums;
import org.springframework.util.StringUtils;

/**
 * DemoException
 *
 * @author qindaorong
 * @create 2018-06-02 10:54 AM
 **/
public class DemoException extends BaseException{
    private  String code;
    
    public DemoException(String code, String message) {
        super(message);
        this.code = code;
    }
    
    public DemoException(TestError testErrorMessage) {
        super(testErrorMessage.getMessage());
        this.code = testErrorMessage.getCode();
    }
    
    public DemoException(String message) {
        super(message);
    }
    
    public DemoException(ErrorCodeEnums errorCodeEnums, String message) {
        super(message);
        this.code = errorCodeEnums.getCode();
    }
    
    public DemoException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public String getCode() {
        if (StringUtils.isEmpty(this.code)) {
            return ErrorCodeEnums.COMMON_CODE.getCode();
        }
        return this.code;
    }
}
