package tinyspring.factory;

import tinyspring.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface BeanFactory {


     Object getBean(String name) throws Exception;




    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;


}
