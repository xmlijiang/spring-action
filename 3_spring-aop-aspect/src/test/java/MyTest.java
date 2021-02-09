import com.jali.service.Calculator;
import com.jali.service.MyCalculator;
import com.jali.service.impl.MyCalculator2;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void testXmlAspect(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        MyCalculator bean = context.getBean(MyCalculator.class);
        System.out.println(bean.add(1, 2));
    }

    @Test
    public void testMyCalculator2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        MyCalculator bean = context.getBean(MyCalculator.class);
//        System.out.println(bean.add(1, 2));

        MyCalculator2 bean2 = context.getBean(MyCalculator2.class);
        System.out.println(bean2.div(6, 0));
    }

    @Test
    public void testAspect(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Calculator bean = (Calculator)context.getBean("myCalculator");

        // 下列无效
        // 报错：Bean named 'myCalculator' is expected to be of type 'com.jali.service.MyCalculator'
        // but was actually of type 'com.sun.proxy.$Proxy18'
//        Calculator bean = context.getBean("myCalculator",MyCalculator.class);
//        MyCalculator bean = context.getBean("myCalculator",MyCalculator.class);

        // 如果有接口，getBean的时候需要获取接口的bean，不能直接使用实现类，否则切面无效
//        Calculator bean = context.getBean(Calculator.class);
//        System.out.println(bean.add(1, 2));
//        System.out.println(bean.getClass());// $Proxy18

        MyCalculator bean = context.getBean(MyCalculator.class);
        System.out.println(bean.add(1, 2));
        System.out.println(bean.sub(1, 2));
        System.out.println(bean.show(1,1.0));
        // 没有实现接口的代理方式是使用cglib实现的，有接口则使用jdk的$Proxy。
        System.out.println(bean.getClass());// MyCalculator$$EnhancerBySpringCGLIB$$6526c5d6
    }
}
