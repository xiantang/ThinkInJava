import org.junit.Test;
import tinyspring.BeanDefinition;
import tinyspring.ResourceLoader;
import tinyspring.factory.AbstractBeanFactory;
import tinyspring.factory.AutowireCapableBeanFactory;
import tinyspring.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        // 初始化beanFactory
//        BeanFactory beanFactory = new AutowireCapableBeanFactory();
//        // 注入bean
//        BeanDefinition beanDefinition = new BeanDefinition();
//        beanDefinition.setBeanClassName("HelloWorldService");
//
//        PropertyValues propertyValues = new PropertyValues();
//        propertyValues.addPropertyValue(new PropertyValue("text", "helloWorld"));
//        beanDefinition.setPropertyValues(propertyValues);
//
//        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
//
//
//        // 获取bean
//        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
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
