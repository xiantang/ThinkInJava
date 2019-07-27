package tinyspring.aop;



import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicAopProxy  implements AopProxy, InvocationHandler {

    private AdvisedSupport advisedSupport;

    public JdkDynamicAopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    /**
     * 获得代理后的对象
     * @return
     */
    @Override
    public Object getProxy() {
        // Proxy类是专门完成代理的操作类，可以通过此类为一个或多个接口动态地生成实现类
        // newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)throws IllegalArgumentException
        // ClassLoader:类加载器
        // Class<?>[] interfaces：得到全部的接口
        // InvocationHandler接口的子类实例
        return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{advisedSupport.getTargetSource()
                .getTargetClass()}, this);
    }

    /**
     *
     * @param proxy 被代理的对象
     * @param method 要调用的方法
     * @param args 方法调用需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 获得方法拦截器
        MethodInterceptor methodInterceptor = advisedSupport.getMethodInterceptor();
        return methodInterceptor.invoke(new ReflectiveMethodInvocation(advisedSupport.getTargetSource().getTarget(), method,
                args));
    }
}
