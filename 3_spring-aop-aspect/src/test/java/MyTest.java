import com.jali.service.Calculator;
import com.jali.service.MyCalculator;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void testAspect(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // getBean的时候需要获取接口的bean，不能直接使用实现类，否则切面无效
        Calculator bean = context.getBean(Calculator.class);
//        Calculator bean = (Calculator)context.getBean("myCalculator");

        // 下列无效
        // 报错：Bean named 'myCalculator' is expected to be of type 'com.jali.service.MyCalculator'
        // but was actually of type 'com.sun.proxy.$Proxy18'
//        Calculator bean = context.getBean("myCalculator",MyCalculator.class);
//        MyCalculator bean = context.getBean("myCalculator",MyCalculator.class);
        System.out.println(bean.add(1, 2));
    }
}
