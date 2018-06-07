package com.qindaorong.demo.core.framework.service;

import com.qindaorong.demo.core.entity.Authority;
import com.qindaorong.demo.core.framework.dto.UserDTO;
import java.util.ArrayList;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * DemoUserDetailsService
 *
 * @author qindaorong
 * @create 2018-06-07 10:08 AM
 **/
@Component("userDetailsService")
public class DemoUserDetailsService implements UserDetailsService {
    
    
    private final Logger log = LoggerFactory.getLogger(DemoUserDetailsService.class);
    
    @Autowired
    private UserService userService;
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating {}", login);
        
        UserDTO userDTO = userService.findUserByUsername(login);
        
        if (userDTO == null) {
           throw new UsernameNotFoundException("User " + login + " was not found in the database");
        }
        
        //获取用户的所有权限并且SpringSecurity需要的集合
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : userDTO.getAuthorityList()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getUserName());
            grantedAuthorities.add(grantedAuthority);
        }

        //返回一个SpringSecurity需要的用户对象
        return new org.springframework.security.core.userdetails.User(
          userDTO.getUsername(),
          userDTO.getPassword(),
          grantedAuthorities);
        
    }
}
