package bean;

import com.jali.bean.Person;
import com.jali.controller.PersonController;
import com.jali.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    /**
     * 给测试类起名字的时候不能定义成Test
     * 测试的方法不可以有参数，返回值
     */
    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonController personController = context.getBean("personController", PersonController.class);
//        System.out.println(personController);
//
//        PersonController personController2 = context.getBean("personController", PersonController.class);
//        System.out.println(personController==personController2);
//
//        PersonService personService = context.getBean("personService", PersonService.class);
//        System.out.println(personService);

        personController.save();

    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
//        Person person = (Person) context.getBean("person");

        // 泛型：不用强转的方式
        Person person = context.getBean("person",Person.class);
//        Person person2 = (Person) context.getBean("person");
//        System.out.println(person==person2);

        /**
         * 根据bean的类型来获取对象
         * 注意：如果存在两个相同类型对象，将无法完成获取工作
         */
//        Person bean = context.getBean(Person.class);
//        System.out.println(bean);

//        Person person2 = context.getBean("person2",Person.class);
//        System.out.println(person2);

//        Person person3 = context.getBean("person3",Person.class);
//        System.out.println(person3);

        Person person4 = context.getBean("person4",Person.class);
        System.out.println(person4);
    }
}
