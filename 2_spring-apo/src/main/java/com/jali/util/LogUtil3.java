package com.jali.util;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogUtil3 {

    public static void start(Method method, Object... objects){
        System.out.println(method.getName()+"方法开始执行，参数："+ Arrays.asList(objects));
    }

    public static void end(Method method, Object... objects){
        System.out.println(method.getName()+"方法执行结束，结果："+ Arrays.asList(objects));
    }
}
