package com.jali.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * 设置以下方法在什么时候运行
 * @Before：在目标方法之前运行：前置通知
 * @After：在目标方法之后运行：后置通知
 * @AfterReturning：在目标方法正常返回之后：返回通知
 * @AfterThrowing：在目标方法抛出异常后开始运行：异常通知
 * @Around：环绕：环绕通知
 *
 * 当编写完注解之后还需要设置在哪些方法上执行，使用表达式
 * execution（访问修饰符 返回值类型 方法全称）
 *
 * 参数要一致，不能基础类型和包装类混用
 * 例如:
 * execution(public int com.jali.service.MyCalculator.*(int,int))
 * execution(public int com.jali.service.MyCalculator.*(Integer,Integer))
 * 两者是不一样的
 *
 * 在实际的生成环境中，更多的时候使用通配符的方式
 *      *
 *          1.可以用来匹配一个或者多个字符：MyCalculator.*(int,int)，M*Calculator.*(int,int)
 *          2.匹配任意的参数：MyCalculator.*(int,*)
 *          3.*在进行匹配的时候只能匹配一层路径，不能匹配多层
 *              一层：com.jali.*.MyCalculator
 *              两层：com.jali.*.*.MyCalculator
 *          4.*不能够匹配访问修饰符，如果不确定访问修饰符是什么，可以直接省略不写
 *              "execution(int com.jali.*.*.MyCalculator*.*(int,*))"
 *          5.返回值可以使用*来代替
 *              "execution(* com.jali.*.*.MyCalculator*.*(..))"
 *      ..
 *          1.可以匹配多个参数，任意类型，MyCalculator*.*(..)，不限制任何参数，不限制任何类型
 *          2.匹配多层路径："execution(* com..MyCalculator*.*(..))"
 *
 *      最偷懒的方式
 *          "execution(* com..*(..))"
 *          "execution(* *(..))"
 *
 *      在使用表达式的时候还支持逻辑运算
 *      &&  两个或多个条件必须要同时满足
 *          "execution(public int com.jali.service.MyCalculator.*(int,int)) && execution(* *(..))"
 *
 *      ||  多个条件只要满足其中一个即可
 *          "execution(public int com.jali.service.MyCalculator.*(int,int)) || execution(* *(..))"
 *
 *      !   取反，除了这种情况，其他都满足
 *          "!execution(public int com.jali.service.MyCalculator.*(int,int))"
 *
 *      使用通配符的时候不是越简洁越好，更多的是要选择符合要求或者符合规则的匹配方式，
 *      此时就要求在定义标识符的时候必须要遵循项目规范
 *
 *      通知的正常执行顺序：
 *      如果正常秩序：@Before-->@AfterReturning-->@After
 *      如果异常结束：@Before-->@AfterThrowing-->@After
 *
 *
 */
@Component
//@Aspect
public class LogUtil {

    @Before("execution(* *(..))")
    public static void start(){
        System.out.println("@before 方法开始执行，参数：");
    }

    @AfterReturning("execution(public int com.jali.service.MyCalculator.*(int,int)) || execution(* *(..))")
    public static void stop(){
        System.out.println("@AfterReturning 方法执行完成，结果是：");
    }

    @AfterThrowing("!execution(public int com.jali.service.MyCalculator.*(int,int))")
    public static void logException(){
        System.out.println("@AfterThrowing 方法出现异常：");
    }

    @After("!execution(public int com.jali.service.MyCalculator.*(int,int))")
    public static void end(){
        System.out.println("@After 方法执行结束了...");
    }
}
