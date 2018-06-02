package com.qindaorong.demo.core.service.impl;

import com.qindaorong.demo.core.dao.CityDao;
import com.qindaorong.demo.core.entity.City;
import com.qindaorong.demo.core.service.CityService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CityServiceImpl
 *
 * @author qindaorong
 * @create 2018-06-02 10:29 AM
 **/
@Service("cityService")
public class CityServiceImpl implements CityService {

    private final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);
    
    @Autowired
    private CityDao cityDao;
    
    @Override
    public List<City> findCitys() {
        return cityDao.findCitys();
    }
}
