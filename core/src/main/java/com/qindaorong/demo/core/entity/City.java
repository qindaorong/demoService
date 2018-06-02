package com.qindaorong.demo.core.entity;

/**
 * City
 *
 * @author qindaorong
 * @create 2018-06-02 10:23 AM
 **/
public class City {
    
    private Long id;
    
    private String city;
    
    private String state;
    
    private String country;
    
    private String lat;
    
    private String lng;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getLat() {
        return lat;
    }
    
    public void setLat(String lat) {
        this.lat = lat;
    }
    
    public String getLng() {
        return lng;
    }
    
    public void setLng(String lng) {
        this.lng = lng;
    }
}
