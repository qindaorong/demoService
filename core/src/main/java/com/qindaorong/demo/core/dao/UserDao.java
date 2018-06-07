package com.qindaorong.demo.core.dao;

import com.qindaorong.demo.core.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * UserDao
 *
 * @author qindaorong
 * @create 2018-06-07 10:42 AM
 **/
@Mapper
public interface UserDao {
    
    
    User findUserByUserName(String userName);
}
