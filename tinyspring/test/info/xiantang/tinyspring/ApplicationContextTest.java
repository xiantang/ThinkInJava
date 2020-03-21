package info.xiantang.tinyspring;

import info.xiantang.tinyspring.hello.HelloWorldService;
import org.junit.Test;
import info.xiantang.tinyspring.context.ApplicationContext;
import info.xiantang.tinyspring.context.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
//        ApplicationContext
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("info/xiantang/tinyspring/tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();

    }

}
