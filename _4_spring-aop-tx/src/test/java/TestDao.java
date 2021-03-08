import com.jali.dao.ModelDao;
import com.jali.service.BookService;
import com.jali.vo.Model;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lijiang
 * @create 2021-03-07 22:04
 */
public class TestDao {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test01(){
        ModelDao modelDao = context.getBean(ModelDao.class);
        Model model = new Model();
        model.setId_("11");
        model.setName_("jack");
        model.setKey_("jack's key");
        modelDao.save(model);

    }

    @Test
    public void test02(){
        // 测试事务
        BookService bean = context.getBean(BookService.class);
        bean.buyBook();
    }

    @Test
    public void test03(){
        // 测试事务：添加 int i = 1/0; 事务问题
        BookService bean = context.getBean(BookService.class);
        bean.buyBookByError();
    }

    @Test
    public void test04(){
        // 测试事务：添加 int i = 1/0; 无事务问题
        BookService bean = context.getBean(BookService.class);
        bean.buyBookByTX();
    }
}
