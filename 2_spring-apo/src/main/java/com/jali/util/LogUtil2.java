package com.jali.util;

import java.util.Arrays;

public class LogUtil2 {

    public static void start(Object... objects){
        System.out.println("方法开始执行，参数："+ Arrays.asList(objects));
    }

    public static void end(Object... objects){
        System.out.println("方法执行结束，结果："+ Arrays.asList(objects));
    }
}
