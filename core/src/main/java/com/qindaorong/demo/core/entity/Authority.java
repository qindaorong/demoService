package com.qindaorong.demo.core.entity;

/**
 * Authority
 *
 * @author qindaorong
 * @create 2018-06-07 10:12 AM
 **/
public class Authority {

    private Long id;
    
    private String userName;
    
    private String authority;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getAuthority() {
        return authority;
    }
    
    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
