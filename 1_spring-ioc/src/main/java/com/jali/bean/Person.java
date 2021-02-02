package com.jali.bean;

import java.util.Arrays;
import java.util.List;

public class Person {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String[] hobbies;
    private List<Address> lists;

    public Person() {
        System.out.println("person被初始化");
    }

    public void init(){
        // 编写N行代码完成初始化功能
        System.out.println("person init对象初始化完成");
    }

    public void destroy(){
        System.out.println("person destroy对象被销毁");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public List<Address> getLists() {
        return lists;
    }

    public void setLists(List<Address> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", lists=" + lists +
                '}';
    }
}
