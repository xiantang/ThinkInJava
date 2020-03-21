package info.xiantang.tinyspring.aop;

import info.xiantang.tinyspring.factory.BeanFactory;

public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
