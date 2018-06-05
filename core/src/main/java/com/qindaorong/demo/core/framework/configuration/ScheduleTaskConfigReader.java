package com.qindaorong.demo.core.framework.configuration;

import com.qindaorong.demo.core.framework.task.domin.ScheduleTaskConfiguration;
import com.qindaorong.demo.core.framework.task.domin.ScheduleTaskConfigurationRoot;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 * ScheduleTaskConfigReader
 *
 * @author qindaorong
 * @create 2018-06-05 3:41 PM
 **/
@Component
public class ScheduleTaskConfigReader {
    
    private static final Logger log = LoggerFactory.getLogger(ScheduleTaskConfigReader.class);
    
    private static final String FILE_PATH = "scheduleservice.xml";
    
    private static ScheduleTaskConfigurationRoot root ;
    
    @PostConstruct
    public void init(){
        JAXBContext jaxbContext;
        try{
            jaxbContext = JAXBContext.newInstance(ScheduleTaskConfigurationRoot.class);
            Unmarshaller um = jaxbContext.createUnmarshaller();
            ClassPathResource cpr = new ClassPathResource(FILE_PATH);
            root = (ScheduleTaskConfigurationRoot) um.unmarshal(cpr.getInputStream());
            log.info("ScheduleTaskConfigReader readConfig..........");
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }
    
    
    private List<ScheduleTaskConfiguration> getConfig(){
        return root.getScheduleTaskConfigurations();
    }
    
    public List<ScheduleTaskConfiguration> getConfigList(){
        return this.getConfig();
    }
    
}
