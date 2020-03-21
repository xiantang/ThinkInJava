package info.xiantang.tinyspring;

import info.xiantang.tinyspring.hello.HelloWorldService;
import org.junit.Test;
import info.xiantang.tinyspring.factory.AbstractBeanFactory;
import info.xiantang.tinyspring.factory.AutowireCapableBeanFactory;
import info.xiantang.tinyspring.xml.BeanDefinition;
import info.xiantang.tinyspring.xml.ResourceLoader;
import info.xiantang.tinyspring.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        // 初始化beanFactory
//        BeanFactory beanFactory = new AutowireCapableBeanFactory();
//        // 注入bean
//        info.xiantang.tinyspring.xml.BeanDefinition beanDefinition = new info.xiantang.tinyspring.xml.BeanDefinition();
//        beanDefinition.setBeanClassName("hello.HelloWorldService");
//
//        info.xiantang.tinyspring.xml.PropertyValues propertyValues = new info.xiantang.tinyspring.xml.PropertyValues();
//        propertyValues.addPropertyValue(new info.xiantang.tinyspring.xml.PropertyValue("text", "helloWorld"));
//        beanDefinition.setPropertyValues(propertyValues);
//
//        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
//
//
//        // 获取bean
//        hello.HelloWorldService helloWorldService = (hello.HelloWorldService) beanFactory.getBean("helloWorldService");
//        helloWorldService.helloWorld();
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("info/xiantang/tinyspring/tinyioc.xml");
        // 2.初始化BeanFactory并注册bean
        // 此时bean null
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
        // 3.初始化bean
        beanFactory.preInstantiateSingletons();
        // 4.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

}
