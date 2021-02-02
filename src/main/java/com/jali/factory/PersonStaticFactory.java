package com.jali.factory;


import com.jali.bean.Person;

/**
 * 静态工厂类
 *
 * @author lijiang
 * @create 2021-01-30 15:57
 */
public class PersonStaticFactory {

    public static Person getInstance(String name){
        Person person = new Person();
        person.setId(1);
        person.setName(name);
        person.setAge(20);
        return person;
    }
}
