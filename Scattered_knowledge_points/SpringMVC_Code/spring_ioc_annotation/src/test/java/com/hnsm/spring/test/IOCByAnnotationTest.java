package com.hnsm.spring.test;

import com.hnsm.spring.controller.UserController;
import com.hnsm.spring.dao.UserDao;
import com.hnsm.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {

    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        /*UserController userController = ioc.getBean("userController",UserController.class);
        System.out.println(userController);
        UserService userService = ioc.getBean("userServiceImpl",UserService.class);
        System.out.println(userService);
        UserDao userDao = ioc.getBean("userDaoImpl",UserDao.class);
        System.out.println(userDao);*/
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();

    }

}
