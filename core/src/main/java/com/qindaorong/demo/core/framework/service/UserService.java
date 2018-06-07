package com.qindaorong.demo.core.framework.service;


import com.qindaorong.demo.core.dao.AuthorityDao;
import com.qindaorong.demo.core.dao.UserDao;
import com.qindaorong.demo.core.entity.Authority;
import com.qindaorong.demo.core.entity.User;
import com.qindaorong.demo.core.framework.dto.UserDTO;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CityServiceImpl
 *
 * @author qindaorong
 * @create 2018-06-02 10:29 AM
 **/
@Service("userService")
public class UserService{

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private AuthorityDao authorityDao;

    public UserDTO findUserByUsername(String login) {
        logger.info("[UserService][findUserByUsername],userName is {}.",login);
        User user = userDao.findUserByUserName(login);
        List<Authority> authorityList = authorityDao.findUserAuthority(login);
        
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,user);
        userDTO.setAuthorityList(authorityList);
        
        return userDTO;
    }
}
