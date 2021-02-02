package com.jali.service;

import com.jali.util.LogUtil2;

public class MyCalculator2 implements Caculator{

    public int add(Integer i, Integer j) {
        LogUtil2.start(i,j);
        int result = i+j;
        LogUtil2.end(result);
        return result;
    }

    public int sub(Integer i, Integer j) {
        LogUtil2.start(i,j);
        int result = i-j;
        LogUtil2.end(result);
        return result;
    }

    public int mul(Integer i, Integer j) {
        LogUtil2.start(i,j);
        int result = i*j;
        LogUtil2.end(result);
        return result;
    }

    public int div(Integer i, Integer j) {
        LogUtil2.start(i,j);
        int result = i/j;
        LogUtil2.end(result);
        return result;
    }
}
