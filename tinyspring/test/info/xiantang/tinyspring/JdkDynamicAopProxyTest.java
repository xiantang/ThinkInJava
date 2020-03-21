package info.xiantang.tinyspring;

import info.xiantang.tinyspring.hello.HelloWorldService;
import org.junit.Test;
import info.xiantang.tinyspring.aop.AdvisedSupport;
import info.xiantang.tinyspring.aop.JdkDynamicAopProxy;
import info.xiantang.tinyspring.aop.TargetSource;
import info.xiantang.tinyspring.aop.TimerInterceptor;
import info.xiantang.tinyspring.context.ApplicationContext;
import info.xiantang.tinyspring.context.ClassPathXmlApplicationContext;

public class JdkDynamicAopProxyTest {

    @Test
    public void testInterceptor() throws Exception {
        // --------- helloWorldService without AOP
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("info/xiantang/tinyspring/tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
        // 1. 设置被代理对象(Joinpoint)
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(HelloWorldService.class, helloWorldService);
        advisedSupport.setTargetSource(targetSource);

//            public interface MethodInterceptor extends Interceptor {
//                Object invoke(MethodInvocation invocation) throws Throwable;
//            }
        // 2. 设置拦截器
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 3. 创建代理
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        HelloWorldService helloWorldServiceProxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();
        helloWorldServiceProxy.helloWorld();

    }
}
