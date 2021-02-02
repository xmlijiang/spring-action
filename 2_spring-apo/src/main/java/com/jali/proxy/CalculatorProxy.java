package com.jali.proxy;

import com.jali.service.Caculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 必须要有接口，如果没有接口，不能使用，这种方式是用jdk提供的reflect包下的类
 * 但是在生产环境中我不能保证每个类都有实现的接口，所以有第二种方式cglib
 *
 * cglib在实现的时候有没有接口都无所谓
 */
public class CalculatorProxy {

    public static Object getCalculator(final Object calculator){
        //获取被代理对象的类加载器
        ClassLoader loader = calculator.getClass().getClassLoader();

        //被代理对象的所有接口
        Class<?>[] interfaces = calculator.getClass().getInterfaces();

        //用来执行被代理类需要执行的方法
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("代理日志，开始执行方法"+ method.getName()+",参数："+ Arrays.asList(args));
                    // 开始调用被代理类的方法
                    result = method.invoke(calculator, args);
                    System.out.println("代理日志，方法"+method.getName()+",返回结果："+result);
                }catch (Exception e){
                    System.out.println(method.getName()+"方法抛出异常："+e.getMessage());
                    e.printStackTrace();
                }finally {
                    System.out.println(method.getName()+"方法执行结束");
                }
                return result;
            }
        };

        Object o = Proxy.newProxyInstance(loader, interfaces, handler);
        return (Caculator) o;
    }
}
