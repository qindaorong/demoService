package com.qindaorong.demo.core.resource;

import com.qindaorong.demo.client.dataresponse.BaseResponseDTO;
import com.qindaorong.demo.client.exceptions.DemoException;
import com.qindaorong.demo.core.entity.City;
import com.qindaorong.demo.core.service.CityService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * CityResource
 *
 * @author qindaorong
 * @create 2018-06-02 10:04 AM
 **/
@RestController
@RequestMapping("/api/city")
public class CityResource {
    
    @Autowired
    private CityService cityService;
    
    @ApiOperation(value="query all city", notes="query all city")
    @RequestMapping(value = { "/list" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponseDTO<List<City>>> findOrders(){
        BaseResponseDTO<List<City>> baseResponseDTO = new BaseResponseDTO<>();
        try {
            List<City> orderList = cityService.findCitys();
            baseResponseDTO.setResult(orderList);
            return new ResponseEntity<>(baseResponseDTO, HttpStatus.OK);
        } catch (DemoException e){
            baseResponseDTO.setDescribe(e.getMessage());
            baseResponseDTO.setCode(e.getCode());
            return new ResponseEntity<>(baseResponseDTO, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
