package com.jali.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


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
 *      ---------------------------------------------------------------------
 *
 *      如果想要在方法中获取对应的参数或者方法名称等信息的时候，必须要使用JoinPoint对象，并且此参数必须是第一个
 *      getSignature()
 *      getArgs()
 *      如果方法中有返回值，那么必须要在此注解中添加 Returning="result"，这个result必须要和参数列表中的参数名称一致
 *          stop(JoinPoint joinPoint,Object result)
 *      如果需要添加异常信息，那么需要在注解中添加 throwing = "e"，类型为：Throwable
 *          logException(JoinPoint joinPoint,Throwable e)
 *      如果想要添加其他参数，必须要添加args(参数列表)，argNames="参数列表"
 *          @Before(value = "execution(* *(..)) && args(i,j)",argNames = "i,j")
 *          public static void start(int i,int j){
 *
 *      通知方法在定义的时候有没有什么特殊的要求？
 *          通知方法在定义的时候对于访问内修饰符、返回值类型都没有明确的要求，但是要注意，参数不能随便添加
 *          public void start(int i,int j){
 *          public static void start(int i,int j){
 *          public int start(int i,int j){
 *          private void start(int i,int j){
 *
 *      如果有多个匹配的表达式相同，能否做抽象？
 *          定义一个没有返回值的空方法，给该方法添加@PointCut注解，后续在使用的时候直接调用方法名
 *          @Pointcut("execution(* *(..))")
 *          public void myPointCut(){}
 *          使用：@After("myPointCut()")
 *
 *      当应用程序中包含多个切面类的时候，具体的执行顺序是什么样的？
 *          按照切面类的名称首字母进行排序，按照字典排序
 *          如果需要人为的规定顺序，可以在切面类上添加@Order(1)注解，同时添加顺序的值，越小越优先
 *
 */
@Component
@Aspect
@Order(1)
public class LogUtil3 {

    public void myPointCut(){}

    public static void end(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName()+" 4 普通后置After 方法执行结束了...");
    }

    private void start(){
//        Signature signature = joinPoint.getSignature();
        System.out.println("2 普通前置Before 方法开始执行，参数：");
    }

    public static void stop(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName()+" 3 普通返回AfterReturning 方法执行完成，结果是："+result);
    }

    public static void logException(JoinPoint joinPoint,Throwable e){
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName()+" 4 普通异常AfterThrowing 方法出现异常："+e.getMessage());
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Signature signature = proceedingJoinPoint.getSignature();
        Object[] args = proceedingJoinPoint.getArgs();
        Object result = null;
        try{
            System.out.println("1环绕通知前置 before："+signature.getName()+"方法开始执行，参数："+Arrays.asList(args));
            // 通过反射的方式调用目标的方法，相当于执行method.invoke()，可以自己修改结果值
            result = proceedingJoinPoint.proceed();
//            result = 100;
            System.out.println("5环绕通知执行结束:"+signature.getName()+"方法执行结束");
        }catch (Throwable throwable){
            System.out.println("6环绕异常通知："+signature.getName()+"出现异常"+throwable.getMessage());
        }finally {
            System.out.println("6环绕返回通知"+signature.getName()+"方法返回结果是："+result);
        }
        return result;

    }
}
