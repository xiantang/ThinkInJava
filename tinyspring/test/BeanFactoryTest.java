import hello.HelloWorldService;
import org.junit.Test;
import factory.AbstractBeanFactory;
import factory.AutowireCapableBeanFactory;
import xml.BeanDefinition;
import xml.ResourceLoader;
import xml.XmlBeanDefinitionReader;

import java.util.Map;

public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        // 初始化beanFactory
//        BeanFactory beanFactory = new AutowireCapableBeanFactory();
//        // 注入bean
//        xml.BeanDefinition beanDefinition = new xml.BeanDefinition();
//        beanDefinition.setBeanClassName("hello.HelloWorldService");
//
//        xml.PropertyValues propertyValues = new xml.PropertyValues();
//        propertyValues.addPropertyValue(new xml.PropertyValue("text", "helloWorld"));
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
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
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
