package com.jali.service;

import com.jali.util.LogUtil3;

import java.lang.reflect.Method;

public class MyCalculator4 implements Caculator{

    public int add(Integer i, Integer j) {
        int result = i+j;
        return result;
    }

    public int sub(Integer i, Integer j) throws NoSuchMethodException {
        int result = i-j;
        return result;
    }

    public int mul(Integer i, Integer j) throws NoSuchMethodException {
        int result = i*j;
        return result;
    }

    public int div(Integer i, Integer j) {
        int result = i/j;
        return result;
    }
}
