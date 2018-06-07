package com.qindaorong.demo.core.enums;

/**
 * Authorities
 *
 * @author qindaorong
 * @create 2018-06-07 12:01 PM
 **/
public enum Authorities
{
    ROLE_ANONYMOUS("anonymous"),
    ROLE_USER("user"),
    ROLE_ADMIN("admin");
    
    private String name;
    
    Authorities(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
}
