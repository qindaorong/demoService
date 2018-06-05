package com.qindaorong.demo.core.framework.task.domin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * ScheduleTaskSqlConfiguration
 *
 * @author qindaorong
 * @create 2018-06-05 3:41 PM
 **/
@XmlAccessorType(XmlAccessType.FIELD)
public class ScheduleTaskSqlConfiguration {
    
    @XmlValue
    private String checkSql;
    
    @XmlAttribute
    private String limit;
    
    @XmlAttribute
    private Boolean limitSwitch;
    
    public String getCheckSql() {
        return checkSql;
    }
    
    public void setCheckSql(String checkSql) {
        this.checkSql = checkSql;
    }
    
    public String getLimit() {
        return limit;
    }
    
    public void setLimit(String limit) {
        this.limit = limit;
    }
    
    public Boolean getLimitSwitch() {
        return limitSwitch;
    }
    
    public void setLimitSwitch(Boolean limitSwitch) {
        this.limitSwitch = limitSwitch;
    }
    
    @Override
    public String toString() {
        return "ScheduleTaskSqlConfiguration{" +
            "checkSql='" + checkSql + '\'' +
            ", limit='" + limit + '\'' +
            ", limitSwitch=" + limitSwitch +
            '}';
    }
}
