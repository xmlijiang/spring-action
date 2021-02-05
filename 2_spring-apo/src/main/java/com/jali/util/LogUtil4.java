package com.jali.util;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * 设置以下方法在什么时候运行
 * @Before：在目标方法之前运行：前置通知
 * @After：在目标方法之后运行：后置通知
 * @AfterReturning：在目标方法正常返回之后：返回通知
 * @AfterThrowing：在目标方法抛出异常后开始运行：异常通知
 * @Around：环绕：环绕通知
 *
 */
@Component
@Aspect
public class LogUtil4 {


    public static void start(Method method, Object... objects){
        System.out.println(method.getName()+"方法开始执行，参数："+ Arrays.asList(objects));
    }

    public static void end(Method method, Object... objects){
        System.out.println(method.getName()+"方法执行结束，结果："+ Arrays.asList(objects));
    }
}
