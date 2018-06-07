package com.qindaorong.demo.core.entity;

/**
 * User
 *
 * @author qindaorong
 * @create 2018-06-07 10:09 AM
 **/
public class User extends BaseEntity{

    private Long id;
    
    private String username;

    private String password;

    private String email;
    
    private Boolean activated;

    private String activationKey;

    private String resetPasswordKey;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean isActivated() {
        return activated;
    }
    
    public void setActivated(boolean activated) {
        this.activated = activated;
    }
    
    public String getActivationKey() {
        return activationKey;
    }
    
    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }
    
    public String getResetPasswordKey() {
        return resetPasswordKey;
    }
    
    public void setResetPasswordKey(String resetPasswordKey) {
        this.resetPasswordKey = resetPasswordKey;
    }
}
