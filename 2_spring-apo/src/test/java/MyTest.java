import com.jali.proxy.CalculatorProxy;
import com.jali.service.*;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class MyTest {

    @Test
    public void testAop() throws NoSuchMethodException {
//        Caculator caculator = new MyCalculator();
//        System.out.println(caculator.add(1, 4));

        // 缺点：不知道执行的方法是什么
//        Caculator caculator = new MyCalculator2();
//        System.out.println(caculator.add(1, 4));

//        Caculator caculator = new MyCalculator3();
//        System.out.println(caculator.add(1, 4));
//        System.out.println(caculator.sub(1, 4));
//        System.out.println(caculator.mul(1, 4));
//        System.out.println(caculator.div(1, 4));

        // 使用代理类
        Caculator calculator = (Caculator)CalculatorProxy.getCalculator(new MyCalculator4());
        calculator.add(10, 20);
        calculator.sub(10, 20);
        calculator.mul(10, 20);
        calculator.div(10, 10);

    }
}
