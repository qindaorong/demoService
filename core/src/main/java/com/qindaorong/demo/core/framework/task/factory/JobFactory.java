package com.qindaorong.demo.core.framework.task.factory;

import com.qindaorong.demo.core.framework.task.domin.JobContext;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * JobFactory
 *
 * @author qindaorong
 * @create 2018-06-05 4:56 PM
 **/
@Configuration
@Import(JobFactory.class)
public class JobFactory implements ImportBeanDefinitionRegistrar {
    
    private static final String BEAN_NAME = "jobFactory";
    
    //已经加载在内存中的job
    private static ConcurrentHashMap<String, JobContext> concurrentMap = new ConcurrentHashMap<String, JobContext>();
    
    
    /**
     * 是否已经加载task
     * @param taskId
     * @return
     */
    public static Boolean isExist(String taskId){
     if(concurrentMap.containsKey(taskId)){
         return Boolean.TRUE;
     }else{
         return Boolean.FALSE;
     }
    }
    
    /**
     * 添加新任务
     * @param context
     */
    public static void loadNewJob(JobContext context){
        if(!isExist(context.getTaskId())){
            concurrentMap.put(context.getTaskId(), context);
        }
    }
    
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        if (!registry.containsBeanDefinition(BEAN_NAME)) {
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(JobFactory.class);
            beanDefinition.setSynthetic(true);
            registry.registerBeanDefinition(BEAN_NAME, beanDefinition);
        }
    }
}
