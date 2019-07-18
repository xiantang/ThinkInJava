package tinyspring.factory;

import tinyspring.BeanDefinition;
import tinyspring.BeanReference;
import tinyspring.PropertyValue;

import java.lang.reflect.Field;

/**
 * 可自动装配的
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        // 通过反射创建bean
        // 但是此时bean 中的需要注入的属性为null
        Object bean = createBeanInstance(beanDefinition);
        // 将bean 设置到定义中
        beanDefinition.setBean(bean);
        // 为 bean 注入属性
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws  Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean,BeanDefinition mbd) throws  Exception {
        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
            Field declareField = bean.getClass().getDeclaredField(propertyValue.getName());
            declareField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference){
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
                beanReference.setBean(value);
            }
            declareField.set(bean, value);

        }
    }


}
