package com.qindaorong.demo.client.exceptions;

/**
 * BaseException
 *
 * @author qindaorong
 * @create 2018-06-02 10:40 AM
 **/
public class BaseException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public BaseException() {
        super();
    }
    
    public BaseException(String message) {
        super(message);
    }
    
    public BaseException(String message, Throwable rootCause) {
        super(message, rootCause);
    }
    
    public BaseException(Throwable rootCause) {
        super(rootCause);
    }
    
}
