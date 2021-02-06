package com.jali.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(2)
public class SecurityUtil {

    @Pointcut("execution(* *(..))")
    public void myPointCut(){}

    @Before(value = "execution(* *(..)) && args(i,j)",argNames = "i,j")
    private void start(int i,int j){
        System.out.println("SecurityUtil 2方法开始执行，参数："+ i+","+j);
    }

    @AfterReturning(value = "execution(public int com.jali.service.MyCalculator.*(int,int)) || execution(* *(..))",
        returning = "result")
    public static void stop(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName()+" SecurityUtil 3方法执行完成，结果是："+result);
    }

    @AfterThrowing(value = "!execution(public int com.jali.service.MyCalculator.*(int,int))",
        throwing = "e")
    public static void logException(JoinPoint joinPoint,Throwable e){
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName()+" SecurityUtil 4方法出现异常："+e.getMessage());
    }

    @After("myPointCut()")
    public static void end(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName()+" SecurityUtil 4方法执行结束了...");
    }

}
