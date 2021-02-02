package com.jali.service;

public class MyCalculator implements Caculator{

    public int add(Integer i, Integer j) {
        System.out.println("add方法开始执行，参数："+i+","+j);
        int result = i+j;
        System.out.println("add方法执行结束，结果："+result);
        return result;
    }

    public int sub(Integer i, Integer j) {
        System.out.println("sub方法开始执行，参数："+i+","+j);
        int result = i-j;
        System.out.println("sub方法执行结束，结果："+result);
        return result;
    }

    public int mul(Integer i, Integer j) {
        System.out.println("mul方法开始执行，参数："+i+","+j);
        int result = i*j;
        System.out.println("mul方法执行结束，结果："+result);
        return result;
    }

    public int div(Integer i, Integer j) {
        System.out.println("div方法开始执行，参数："+i+","+j);
        int result = i/j;
        System.out.println("div方法执行结束，结果："+result);
        return result;
    }
}
