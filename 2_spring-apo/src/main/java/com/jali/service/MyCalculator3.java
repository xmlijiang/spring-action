package com.jali.service;

import com.jali.util.LogUtil2;
import com.jali.util.LogUtil3;

import java.lang.reflect.Method;

public class MyCalculator3 implements Caculator{

    public int add(Integer i, Integer j) {
        Method method = null;
        try {
            method = MyCalculator3.class.getMethod("add",Integer.class,Integer.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        LogUtil3.start(method,i,j);
        int result = i+j;
        LogUtil3.end(method,result);
        return result;
    }

    public int sub(Integer i, Integer j) throws NoSuchMethodException {
        Method method = MyCalculator3.class.getMethod("sub",Integer.class,Integer.class);
        LogUtil3.start(method,i,j);
        int result = i-j;
        LogUtil3.end(method,result);
        return result;
    }

    public int mul(Integer i, Integer j) throws NoSuchMethodException {
        Method method = MyCalculator3.class.getMethod("mul",Integer.class,Integer.class);
        LogUtil3.start(method,i,j);
        int result = i*j;
        LogUtil3.end(method,result);
        return result;
    }

    public int div(Integer i, Integer j) {
        Method method = null;
        try {
            method = MyCalculator3.class.getMethod("div",Integer.class,Integer.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        LogUtil3.start(method,i,j);
        int result = i/j;
        LogUtil3.end(method,result);
        return result;
    }
}
