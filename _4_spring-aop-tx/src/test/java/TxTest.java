import com.jali.service.BookService;
import com.jali.service.MultService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lijiang
 * @create 2021-03-12 23:57
 */
public class TxTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test01() {
        // 测试propagation=required
        MultService bean = context.getBean(MultService.class);
        bean.mult();
    }
}
