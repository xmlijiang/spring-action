import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.jali.vo.Model;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lijiang
 * @create 2021-03-06 22:49
 */
public class MyTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test01(){
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        DruidPooledConnection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
        JdbcTemplate bean = context.getBean("jdbcTemplate",JdbcTemplate.class);
        System.out.println(bean);
    }

    @Test
    public void test02(){
        // 插入一条数据
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into act_re_model(ID_,NAME_,KEY_) values(?,?,?)";
        // 返回插入行数
        int update = jdbcTemplate.update(sql, "1","lisi", "myKey");
        System.out.println(update);
    }

    @Test
    public void test03(){
        // 批量插入数据
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into act_re_model(ID_,NAME_,KEY_) values(?,?,?)";
        // 参数
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"2","zhangsan","zzz"});
        batchArgs.add(new Object[]{"3","liwu","lll"});
        batchArgs.add(new Object[]{"4","wangliu","www"});
        // 批量执行
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test04(){
        // 删除一条数据
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "delete from act_re_model where id_ = ?";
        int delete = jdbcTemplate.update(sql, "1");
        System.out.println(delete);
    }

    @Test
    public void test05(){
        // 更新一条数据
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "update act_re_model set key_ = ? where id_ = ?";
        int update = jdbcTemplate.update(sql, "update","2");
        System.out.println(update);
    }

    @Test
    public void test06(){
        // 查询一条数据
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from act_re_model where id_ = ?";
        Model model = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Model.class),"2");
        System.out.println(model);
    }

    @Test
    public void test07(){
        // 批量查询数据
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from act_re_model";
        List<Model> result = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Model.class));
        for (Model model : result) {
            System.out.println(model);
        }
    }
}
