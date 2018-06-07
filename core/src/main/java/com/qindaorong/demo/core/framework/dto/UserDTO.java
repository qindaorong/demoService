package com.qindaorong.demo.core.framework.dto;

import com.qindaorong.demo.core.entity.Authority;
import java.util.List;

/**
 * UserDTO
 *
 * @author qindaorong
 * @create 2018-06-07 11:14 AM
 **/
public class UserDTO {
    private Long id;
    
    private String username;
    
    private String password;
    
    private String email;
    
    private Boolean activated;
    
    private String activationKey;
    
    private String resetPasswordKey;
    
    private List<Authority> authorityList;
    
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
    
    public Boolean getActivated() {
        return activated;
    }
    
    public void setActivated(Boolean activated) {
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
    
    public List<Authority> getAuthorityList() {
        return authorityList;
    }
    
    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }
}
