package com.qindaorong.demo.core.dao;

import com.qindaorong.demo.core.entity.City;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * CityDao
 *
 * @author qindaorong
 * @create 2018-06-02 10:22 AM
 **/
@Mapper
public interface CityDao {
    List<City> findCitys();
}
