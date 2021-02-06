package com.jali.service.impl;

import org.springframework.stereotype.Service;

@Service
//public class MyCalculator implements Calculator{
public class MyCalculator2 {
    public int add(int i, int j) {
        int result = i+j;
        return result;
    }

    public int sub(int i, int j) {
        int result = i-j;
        return result;
    }

    public int mul(int i, int j) {
        int result = i*j;
        return result;
    }

    public int div(int i, int j) {
        int result = i/j;
        return result;
    }

    public int show(int i,Double j){
        System.out.println("show");
        return i;
    }
}
