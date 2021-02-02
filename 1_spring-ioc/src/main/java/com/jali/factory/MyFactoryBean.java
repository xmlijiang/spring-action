package com.jali.factory;


import com.jali.bean.Person;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * 实现了FactoryBean接口的类是Spring中可以识别的工厂类，spring会自动调用工厂方法创建实例
 *
 * 此方式是spring创建bean方式的一种补充，用户可以按照需求创建对象，
 * 将创建的对象交由spring IOC容器来进行管理，无论是否单例，都是在用到的时候才会创建该对象，不用该对象不会创建
 *
 * 本身自己用的时候不怎么会用到这种方式，但是在看源码的时候会经常看到这种实现类
 * @author lijiang
 * @create 2021-01-30 16:32
 */
public class MyFactoryBean implements FactoryBean<Person> {


    /**
     * 工厂方法，返回需要创建的对象
     * @return
     * @throws Exception
     */
    @Override
    public Person getObject() throws Exception {
        Person person = new Person();
        person.setId(3);
        person.setName("王五");
        person.setAge(28);
        return person;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    /**
     * 无论是否是单例模式，spring容器都不会提前创建该对象，只有在使用的时候才会创建
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
