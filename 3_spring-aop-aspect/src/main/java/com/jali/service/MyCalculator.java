package com.jali.service;

import org.springframework.stereotype.Service;

@Service
public class MyCalculator implements Calculator{
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
}
