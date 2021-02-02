package com.jali.service;

/**
 * 计时器
 */
public interface Caculator {

    int add(Integer i,Integer j);

    int sub(Integer i,Integer j) throws NoSuchMethodException;

    int mul(Integer i,Integer j) throws NoSuchMethodException;

    int div(Integer i,Integer j);
}
