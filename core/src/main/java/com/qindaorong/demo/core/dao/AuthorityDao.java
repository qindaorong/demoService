package com.qindaorong.demo.core.dao;

import com.qindaorong.demo.core.entity.Authority;
import com.qindaorong.demo.core.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * AuthorityDao
 *
 * @author qindaorong
 * @create 2018-06-07 11:41 AM
 **/
@Mapper
public interface AuthorityDao {

    List<Authority> findUserAuthority(String userName);
}
