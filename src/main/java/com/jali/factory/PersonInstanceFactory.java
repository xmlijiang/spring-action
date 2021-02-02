package com.jali.factory;


import com.jali.bean.Person;

/**
 * @author lijiang
 * @create 2021-01-30 16:01
 */
public class PersonInstanceFactory {

    public Person getInstance(String name){
        Person person = new Person();
        person.setId(2);
        person.setName(name);
        person.setAge(22);
        return person;
    }
}
