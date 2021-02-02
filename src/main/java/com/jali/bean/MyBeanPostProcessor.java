package com.jali.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author lijiang
 * @create 2021-01-30 17:21
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在每一个对象的初始化方法前面执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化方法之前调用"+beanName);
        return bean;
    }

    /**
     * 在每一个对象的初始化方法后面执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化方法之后调用"+beanName);
        return bean;
    }
}
