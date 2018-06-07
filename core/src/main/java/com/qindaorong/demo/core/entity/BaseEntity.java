package com.qindaorong.demo.core.entity;

import java.io.Serializable;
import java.util.Date;
import org.joda.time.DateTime;

/**
 * BaseEntity
 *
 * @author qindaorong
 * @create 2018-06-07 10:32 AM
 **/
public class BaseEntity implements Serializable {
    
    private int status;
    
    private Long createdBy;
    
    private Date createdDate;
    
    private Long lastModifiedBy;
    
    private Date lastModifiedDate;
    
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public Long getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    
    public Date getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }
    
    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
    
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }
    
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
