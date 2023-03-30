package comm.huinong.spring.test;

import com.huinong.pojo.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {

    /**
     * 入门案例
     */
    @Test
    public void test() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IOC容器中的bean对象
        HelloWorld helloworld = (HelloWorld) ioc.getBean("helloworld");
        helloworld.sayHello();

    }

    /**
     * 获取bean的3种方式
     */
    @Test
    public void testIOC() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
//        User userOne = (User) ioc.getBean("userOne");
//        User userOne = ioc.getBean(User.class);
//        User userTwo = ioc.getBean("userTwo",User.class);
        Person person = ioc.getBean(Person.class);
        System.out.println(person);
    }


    /**
     * setter注入
     */
    @Test
    public void test2IOC() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        User userThree = ioc.getBean("userThree", User.class);
        System.out.println(userThree);
    }

    /**
     * setter注入
     */
    @Test
    public void test3IOC() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        Student student = ioc.getBean("studentSix", Student.class);
        System.out.println(student);

        /*内部bean只能在内部使用：NoSuchBeanDefinitionException: No bean named 'clazzInner' available*/
        /*Clazz clazz = ioc.getBean("clazzInner", Clazz.class);
        System.out.println(clazz);*/

        /*Clazz clazz = ioc.getBean("clazzOne", Clazz.class);
        System.out.println(clazz);*/

    }


}
