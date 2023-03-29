#Spring简介

##简介

2002年，Rod Jahnson首次推出了Spring框架雏形interface21框架。

2004年3月24日，Spring框架以interface21框架为基础，经过重新设计，发布了1.0正式版。

很难想象Rod Johnson的学历 , 他是悉尼大学的博士，然而他的专业不是计算机，而是音乐学。

Spring理念 : 使现有技术更加实用 . 本身就是一个大杂烩 , **整合现有的框架技术**

##优点

> 1. Spring是一个开源免费的框架 , 容器
> 2. Spring是一个轻量级的框架 , 非侵入式的 
>    1. 轻量级：本身很小
>    2. 非侵入式：使用它不会影响原来代码的情况
> 3. 控制反转 IoC  , 面向切面 Aop
> 4. 对事物的支持 , 对框架的支持
> 5. 一句话概括：Spring是一个轻量级的控制反转(IoC)和面向切面(AOP)的容器（框架）。
>

##组成

![Spring七大模块](Spring01-image/Spring七大模块.jpg)

 

> 各模块概述

**1. 核心容器SpringCode：** 核心容器提供Spring框架的基本功能。—-它主要的组件就是BeanFactory,是工厂模式的实现。同时BeanFactory适用控制反转（IOC）思想将应用程序的配置和依赖性规范与实际的应用程序分开。

**2. Spring Context：** Spring上下文是一个配置文件，主要向框架提供上下文信息。

**3. SpringAop：** 通过配置管理特性，SpringAOP模块直接将面向切面地编程功能集成到了Spring框架中，所以，它可以很容易地使Spring框架管理的任何对象支持AOP。SpringAOP模块也是基于Spring的应用程序中的对象提供了事务管理服务。—–比较强大的功能

**4. SpringDAO：** 它主要和dao层相关联,可以用该结构来管理异常处理和不同数据库供应商抛出的错误信息。其中异常层次结构简化了错误处理，并且极大地降低了需要编写地异常代码数据（例如打开和关闭连接）。

**5. Spring ORM ：** Spring框架中插入了若干个ORM框架，从而提供了ORM的对象关系工具，其中包括 JDO、Hibernate 和 iBatis SQL Map。所有这些都遵从 Spring 的通用事务和 DAO 异常层次结构。

**6. SpringWEB模块：** Web 上下文模块建立在应用程序上下文模块之上，为基于 Web 的应用程序提供了上下文。Web 模块还简化了处理多部分请求以及将请求参数绑定到域对象的工作。

**7. SpringMVC**：MVC 框架是一个全功能的构建 Web 应用程序的 MVC  实现。通过策略接口，MVC 框架变成为高度可配置的，MVC 容纳了大量视图技术，其中包括  JSP、FreeMarker、Velocity、Tiles（jsp布局）、iText（报表处理） 和 poi。

##拓展

**Spring Boot与Spring Cloud**

- Spring Boot 是 Spring 的一套快速配置脚手架，可以基于Spring Boot 快速开发单个微服务;
- Spring Cloud是基于Spring Boot实现的；
- Spring Boot专注于快速、方便集成的单个微服务个体，Spring Cloud关注全局的服务治理框架；
- Spring Boot使用了约束优于配置的理念，很多集成方案已经帮你选择好了，能不配置就不配置 , Spring Cloud很大的一部分是基于Spring Boot来实现，Spring Boot可以离开Spring Cloud独立使用开发项目，但是Spring Cloud离不开Spring Boot，属于依赖的关系。
- SpringBoot在SpringClound中起到了承上启下的作用，如果你要学习SpringCloud必须要学习SpringBoot。

#IOC理论推导

##环境搭建并测试

###导入依赖

```xml
<!-- 导入这一个包，可以同时导入Spring的其他核心jar包 -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>
<!-- spring与mybatis整合所需要的包 -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.3.4</version>
</dependency>
```

###dao层接口

```java
package com.bao.dao;

public interface UserDao {
    String show();
}
```

###dao层实现类

```java
package com.bao.dao;

public class UserDaoImpl1 implements UserDao {

    @Override
    public String show() {
        return "查询用户信息";
    }
}
```

```java
package com.bao.dao;

public class UserDaoImpl2 implements UserDao {

    @Override
    public String show() {
        return "查询用户信息2";
    }
}
```

```java
package com.bao.dao;

public class UserDaoImpl3 implements UserDao {

    @Override
    public String show() {
        return "查询用户信息3";
    }
}
```

###service层接口

```java
package com.bao.service;

public interface UserService {
    String show();
}
```

###service层实现类

```java
package com.bao.service;

import com.bao.dao.UserDao;
import com.bao.dao.UserDaoImpl;
import com.bao.dao.UserDaoImpl2;
import com.bao.dao.UserDaoImpl3;

public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoImpl3();

    @Override
    public String show() {
        return userDao.show();
    }
}
```

###测试

```java
package com.bao.service;

import org.junit.Test;

public class TestUserService {
    @Test
    public void showTest(){
        UserService userService = new UserServiceImpl();
        System.out.println(userService.show());
    }
}
```

###说明

> 在操作过程中，我们发现，在我们写完的原有的功能基础之上，当用户的请求发生变化时，我们需要手动修改代码，这说明我们的代码设计的不够合理，我们需要进行设计的优化

###优化

####第一种：set注入

1. dao层不变

2. service层接口不变

3. service层实现类

   ```java
   package com.bao.service;
   
   import com.bao.dao.UserDao;
   import com.bao.dao.UserDaoImpl;
   import com.bao.dao.UserDaoImpl2;
   import com.bao.dao.UserDaoImpl3;
   
   public class UserServiceImpl implements UserService{
       /*private UserDao userDao = new UserDaoImpl3();*/
       private UserDao userDao;
   
       public void setUserDao(UserDao userDao) {
           this.userDao = userDao;
       }
   
       @Override
       public String show() {
           return userDao.show();
       }
   }
   ```

4. 测试类

   ```java
   package com.bao.service;
   
   import com.bao.dao.UserDaoImpl2;
   import com.bao.dao.UserDaoImpl3;
   import org.junit.Test;
   
   public class TestUserService {
       @Test
       public void showTest(){
           UserService userService = new UserServiceImpl();
           ((UserServiceImpl) userService).setUserDao(new UserDaoImpl2());
           System.out.println(userService.show());
       }
   }
   ```

####第二种：构造器注入

1. dao层不变

2. service层接口不变

3. service层实现类

   ```java
   package com.bao.service;
   
   import com.bao.dao.UserDao;
   import com.bao.dao.UserDaoImpl;
   import com.bao.dao.UserDaoImpl2;
   import com.bao.dao.UserDaoImpl3;
   
   public class UserServiceImpl implements UserService{
       /*private UserDao userDao = new UserDaoImpl3();*/
       private UserDao userDao;
   
       public UserServiceImpl(UserDao userDao) {
           this.userDao = userDao;
       }
   
       @Override
       public String show() {
           return userDao.show();
       }
   }
   ```

4. 测试类

   ```java
   package com.bao.service;
   
   import com.bao.dao.UserDaoImpl2;
   import com.bao.dao.UserDaoImpl3;
   import org.junit.Test;
   
   public class TestUserService {
       @Test
       public void showTest(){
           UserService userService = new UserServiceImpl(new UserDaoImpl3());
           System.out.println(userService.show());
       }
   }
   ```

##说明

> Spring是用来管理bean对象的，bean对象就是new出来的对象

      1. 之前由程序员创建对象，控制权（创建对象的控制权）在程序员手上
      2. 使用了set或constructor注入时控制权交给了调用者（用户），程序不再有主动性，而是变成了被动的接受对象
      3. 这种思想，从本质上解决了程序员管理对象的创建的问题，系统的耦合性大大降低，这是ioc的原型

##IOC的本质

> 1. **控制反转IoC(Inversion of Control)，是一种设计思想，DI(依赖注入)是实现IoC的一种方法**，也有人认为DI只是IoC的另一种说法。没有IoC的程序中 , 我们使用面向对象编程 , 对象的创建与对象间的依赖关系完全编码在程序中，对象的创建由程序自己控制，控制反转后将对象的创建转移给第三方
> 2. 总结：控制反转就是创建对象的控制权反转了，由程序员反转到用户手上了
> 3. **IoC是Spring框架的核心内容**，使用多种方式完美的实现了IoC，可以使用XML配置，也可以使用注解，新版本的Spring也可以零配置实现IoC。Spring容器在初始化时先读取配置文件，根据配置文件或元数据创建与组织对象存入容器中，程序使用时再从Ioc容器中取出需要的对象。
> 4. 采用XML方式配置Bean的时候，Bean的定义信息是和实现分离的，而采用注解的方式可以把两者合为一体，Bean的定义信息直接以注解的形式定义在实现类中，从而达到了零配置的目的
> 
>**总结：控制反转是一种通过描述（XML或注解）并通过第三方去生产或获取特定对象的方式。在Spring中实现控制反转的是IoC容器，其实现方法是依赖注入（Dependency Injection,DI）。**

#Spring入门 

##导入spring-webmvc坐标

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>
```

##创建实体类Hello

```java
package com.bao.pojo;

public class Hello {
    private String talk;

    @Override
    public String toString() {
        return "Hello{" +
                "talk='" + talk + '\'' +
                '}';
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }
}
```

##创建spring的配置文件

<img src="Spring01-image/image-20200903154226125.png" alt="image-20200903154226125" style="zoom: 100%;" />

文件名称为：applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--使用Spring来创建对象，在spring中这些对象都被称之为bean;
        注意：交给Spring创建对象的前提是需要类创建了相应的set方法！！！-->
    <!--id:相当于对象名（变量名）
        class：该类型的全限定名称
        property:设置该对象的属性
        name：该对象的属性名
        value：属性具体的值，只能写基本数据类型
        ref：引用spring容器中创建好的对象
    -->
    <bean id="hello" class="com.bao.pojo.Hello">
        <property name="talk" value="你好，Spring"/>
    </bean>
</beans>
```

##测试类

```java
package com.bao.pojo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHello {
    @Test
    public void Test1(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
```

##结果

![image-20200903154837754](Spring01-image/image-20200903154837754.png)

#多个bean

##实体类

![image-20200903161053388](Spring01-image/image-20200903161053388.png)

##配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--使用Spring来创建对象，在spring中这些对象都被称之为bean;
        注意：交给Spring创建的对象需要添加属性时需要类创建了相应的set方法！！！-->
    <!--id:相当于对象名（变量名）
        class：该类型的全限定名称
        property:设置该对象的属性
        name：该对象的属性名
        value：具体的值，基本数据类型
        ref：引用spring容器中创建好的对象
    -->
    <bean id="hello" class="com.bao.pojo.Hello">
        <property name="talk" value="你好，Spring"/>
    </bean>

    <bean id="userDaoImpl" class="com.bao.pojo.UserDaoImpl"/>
    <bean id="userDaoImpl2" class="com.bao.pojo.UserDaoImpl2"/>
    <bean id="userDaoImpl3" class="com.bao.pojo.UserDaoImpl3"/>
    
    <!--注意：交给Spring创建对象的前提是需要类创建了相应的set方法-->
    <bean id="userServiceImpl" class="com.bao.service.UserServiceImpl">
        <property name="userDao" ref="userDaoImpl2"/>
    </bean>
</beans>
```

##测试类

```java
package com.bao.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl {
    @Test
    public void showTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = (UserService) context.getBean("userServiceImpl");
        System.out.println(userServiceImpl.show());
    }
}
```

##结果

![image-20200903161948328](Spring01-image/image-20200903161948328.png)

#IOC创建对象的方式

##无参构造方式创建（默认方式）

###思路

> 在实体类中创建有参构造，覆盖无参构造方法

###实体类

```java
package com.bao.pojo;

public class Hello {
    private String string;

    /*创建有参构造，覆盖无参构造方法*/
    public Hello(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "string='" + string + '\'' +
                '}';
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

}
```

###配置文件

![image-20200903190538010](Spring01-image/image-20200903190538010.png)

###测试

```java
package com.bao.pojo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHello {
    @Test
    public void Test1(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
```

###测试结果

![image-20200903190706177](Spring01-image/image-20200903190706177.png)

##有参构造方式创建

###实体类

```java
package com.bao.pojo;

public class User {
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

```

###spring配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--有参构造赋值：1.下标赋值-->
    <!--<bean id="user" class="com.bao.pojo.User">
        <constructor-arg index="0" value="陈一"/>
    </bean>-->
    <!--有参构造赋值：2.数据类型赋值（不建议使用）-->
    <!--<bean id="user" class="com.bao.pojo.User">
        <constructor-arg type="java.lang.String" value="刘一"/>
    </bean>-->
    <!--有参构造赋值：3.参数名赋值（常用）-->
    <bean id="user" class="com.bao.pojo.User">
        <constructor-arg name="name" value="陈二"/>
    </bean>
</beans>
```

###测试类

```java
package com.bao.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    public void userTest1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
    }
}
```

###注意

```java
/*当读取配置文件，创建容器时就会创建容器中的所有bean*/
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

/*无论获取几次相同的bean都是同一个，创建bena的方式是单例的*/
User user = (User) context.getBean("user");
User user1 = (User) context.getBean("user");
System.out.println(user == user1);
```

![image-20200903194105614](Spring01-image/image-20200903194105614.png)

#Spring的配置

##别名

###配置文件

```xml
<bean id="user" class="com.bao.pojo.User">
    <constructor-arg index="0" value="陈二"/>
</bean>
<!--设置别名：相当于多了一个名字，两个名字都可以用-->
<alias name="user" alias="userNewName"/>
```

###测试类

```java
package com.bao.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    public void userTest1(){
        /*当读取配置文件，创建容器时就会创建容器中的所有bean*/
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");
        User userNewName = (User) context.getBean("userNewName");
        System.out.println(user);
        System.out.println(userNewName);
    }
}
```

##Bean的配置

###配置文件

```xml
<!--name:在标签内设置name属性也可以设置别名，并且可以设置多个别名；
    多个别名可以用“逗号”，“空格”，“分号”分割
    -->
<bean id="user" class="com.bao.pojo.User" name="u1,u2 u3;u4">
    <constructor-arg index="0" value="陈二"/>
</bean>
```

###测试类

```java
package com.bao.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    public void userTest1(){
        /*当读取配置文件，创建容器时就会创建容器中的所有bean*/
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User userNewName1 = (User) context.getBean("u1");
        User userNewName2 = (User) context.getBean("u2");
        User userNewName3 = (User) context.getBean("u3");
        User userNewName4 = (User) context.getBean("u4");
        System.out.println(userNewName1);
        System.out.println(userNewName2);
        System.out.println(userNewName3);
        System.out.println(userNewName4);
    }
}
```

##import

1. import一般用于团队开发，它可以将多个配置文件导入合并为一个

2. 假设，现在项目中有多个人进行开发，这三个人负责不同的类开发，不同的类需要注册在不同的bean中，我们可以用import将多个bean.xml合并为一个总的

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd">
   
       <import resource="bean1.xml"/>
       <import resource="bean2.xml"/>
   
   </beans>
   ```

4. 注意：bean1.xml和bean2.xml要有所区别，否则有可能会报错

#依赖注入（Dependency injection）

##理解

> 依赖：bean对象的创建依赖容器(Spring框架)
>
> 注入：bean对象的所有属性，在容器创建

##构造器注入

​	前面已讲

##Set方式注入(重点)

###实体类

```java
package com.bao.pojo;

public class Address {
    private String address;

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
```

```java
package com.bao.pojo;

import java.util.*;

public class Student {
    private String name;
    private Address address;
    private String[] books;
    private List<String> hobbys;
    private Map<String,String> card;//学籍信息
    private Set<String> games;
    private String wife;//妻子
    private Properties info;//信息

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", books=" + Arrays.toString(books) +
                ", hobbys=" + hobbys +
                ", card=" + card +
                ", games=" + games +
                ", wife='" + wife + '\'' +
                ", info=" + info +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public void setHobbys(List<String> hobbys) {
        this.hobbys = hobbys;
    }

    public void setCard(Map<String, String> card) {
        this.card = card;
    }

    public void setGames(Set<String> games) {
        this.games = games;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }
}
```

###配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean name="address" class="com.bao.pojo.Address">
        <property name="address" value="火星"/>
    </bean>

    <bean name="student" class="com.bao.pojo.Student">
        <!--普通注入-->
        <property name="name" value="刘一"/>
        <!--bean注入-->
        <property name="address" ref="address"/>
        <!--数组注入-->
        <property name="books">
            <array>
                <value>毛泽东自传</value>
                <value>机器的灵魂时代</value>
                <value>java编程与思想</value>
            </array>
        </property>
        <!--List注入-->
        <property name="hobbys">
            <list>
                <value>读书</value>
                <value>运动</value>
                <value>敲代码</value>
            </list>
        </property>
        <!--Map注入-->
        <property name="card">
            <map>
                <entry key="姓名" value="刘一"/>
                <entry key="学号" value="2020123"/>
            </map>
        </property>
        <!--Set注入-->
        <property name="games">
            <set>
                <value>俄罗斯方块</value>
                <value>魂斗罗</value>
                <value>合金弹头</value>
            </set>
        </property>
        <!--null值注入-->
        <property name="wife">
            <null/>
        </property>
        <!--properties注入-->
        <property name="info">
            <props>
                <prop key="java">100</prop>
                <prop key="Web">99</prop>
                <prop key="MySql">95</prop>
            </props>
        </property>
    </bean>

</beans>
```

###测试类

```java
package com.bao.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {
    @Test
    public void MyTest1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
        /*
        Student{
            name='刘一',
            address=Address{address='火星'},
            books=[毛泽东自传, 机器的灵魂时代, java编程与思想],
            hobbys=[读书, 运动, 敲代码],
            card={姓名=刘一, 学号=2020123},
            games=[俄罗斯方块, 魂斗罗, 合金弹头],
            wife='null',
            info={java=100, MySql=95, Web=99}}
         * */
    }
}
```

##拓展方式注入

> 使用p命名和c命名注入

###提前导入约束

```xml
xmlns:p="http://www.springframework.org/schema/p"
xmlns:c="http://www.springframework.org/schema/c"
```

###配置类

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--p命名空间的注入，可以直接注入简单属性的值 -property-->
    <bean id="user" class="com.bao.pojo.User" p:name="陈二" p:age="18"/>

    <!--c命名空间注入，通过构造器注入  -constructor-arg
        注：需要创建有参构造-->
    <bean id="userTwo" class="com.bao.pojo.User" c:name="郑十" c:age="19"/>

</beans>
```

###测试类

```java
@Test
public void UserTest1(){
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    User user = context.getBean("user", User.class);
    User userTwo = context.getBean("userTwo", User.class);
    System.out.println(user);
    System.out.println(userTwo);
}
```

##bean的作用域

> 作用域限定了Spring  Bean的作用范围，在Spring配置文件定义Bean时，通过声明scope配置项，可以灵活定义Bean的作用范围。例如，当你希望每次IOC容器返回的Bean是同一个实例时，可以设置scope为singleton；当你希望每次IOC容器返回的Bean实例是一个新的实例时，可以设置scope为prototype。
>

> scope配置项有5个属性，用于描述不同的作用域。
>

> ① singleton（默认值）
>
> 使用该属性定义Bean时，IOC容器仅创建一个Bean实例，IOC容器每次返回的是同一个Bean实例。
>
> ② prototype
>
> 使用该属性定义Bean时，IOC容器可以创建多个Bean实例，每次返回的都是一个新的实例。
>
> ③ request
>
> 该属性仅对HTTP请求产生作用，使用该属性定义Bean时，每次HTTP请求都会创建一个新的Bean，适用于WebApplicationContext环境。
>
> ④ session
>
> 该属性仅用于HTTP Session，同一个Session共享一个Bean实例。不同Session使用不同的实例。
>
> ⑤ global-session
>
> 该属性仅用于HTTP Session，同session作用域不同的是，所有的Session共享一个Bean实例。

singleton

```xml
<bean id="user" class="com.bao.pojo.User" p:name="陈二" p:age="18" scope="singleton"/>
```

```java
@Test
public void UserTest2(){
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    User user1 = context.getBean("user", User.class);
    User user2 = context.getBean("user", User.class);
    System.out.println(user1 == user2);
}
```

prototype

```xml
<bean id="user" class="com.bao.pojo.User" p:name="陈二" p:age="18" scope="prototype"/>
```

```java
@Test
public void UserTest2(){
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    User user1 = context.getBean("user", User.class);
    User user2 = context.getBean("user", User.class);
    System.out.println(user1 == user2);
}
```

#bean的自动装配

> 自动装配理解：自动给bean的属性赋值

##Spring中bean有三种装配机制

1. 在xml中显式配置(这是我们刚才一直使用的方式)
2. 在java中显式配置(后期再讲)
3. 隐式的自动装配bean(重点)

##自动装配环境搭建

###实体类

```java
package com.bao.pojo;

public class Cat {
    public void eat(){
        System.out.println("吃鱼");
    }
}
```

```java
package com.bao.pojo;

public class Dog {
    public void eat(){
        System.out.println("吃肉");
    }
}
```

```java
package com.bao.pojo;

public class People {
    private String name;
    private Dog dog;
    private Cat cat;

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                ", cat=" + cat +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }
}
```

###配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="dog" class="com.bao.pojo.Dog"/>
    <bean id="cat" class="com.bao.pojo.Cat"/>
    <bean id="people" class="com.bao.pojo.People">
        <property name="name" value="刘一"/>
        <property name="cat" ref="cat"/>
        <property name="dog" ref="dog"/>
    </bean>

</beans>
```

###测试类

```java
import com.bao.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void MyTest1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = context.getBean("people", People.class);
        System.out.println(people.getName());
        people.getCat().eat();
        people.getDog().eat();
    }

}
```

##ByName和ByType自动装配

###配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="dog" class="com.bao.pojo.Dog"/>
    <bean id="cat" class="com.bao.pojo.Cat"/>
    <!--byName:会自动在容器的上下文中查找和自己对象set方法后面的属性名对应的beanid-->
    <!--<bean id="people" class="com.bao.pojo.People" autowire="byName">
        <property name="name" value="刘一"/>
    </bean>-->
    <!--byType:会自动在容器的上下文中查找和自己对象属性类型相同的bean-->
    <bean id="people" class="com.bao.pojo.People" autowire="byType">
        <property name="name" value="刘一"/>
    </bean>

</beans>
```

###测试类

```java
import com.bao.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void MyTest1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = context.getBean("people", People.class);
        System.out.println(people.getName());
        people.getCat().eat();
        people.getDog().eat();
    }

}
```

###注意

> 1. byName:
>    1. 会自动在容器的上下文中查找和自己对象set方法后面的属性名对应的beanId
>    2. 要求所有的bean的id唯一
> 2. byType:
>    1. 会自动在容器的上下文中查找和自己对象属性类型相同的bean
>    2. 要求bean的类型唯一
>

##使用注解自动装配

###配置文件导入约束：context约束，同时添加注解支持

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">

    <!--开启注解支持-->
    <context:annotation-config/>
    
    <!--将对象交给spring容器管理-->
    <bean id="dog" class="com.bao.pojo.Dog"/>
    <bean id="cat" class="com.bao.pojo.Cat"/>
    <bean id="people" class="com.bao.pojo.People"/>
</beans>
```

###实体类中的属性添加@Autowired注解

```java
package com.bao.pojo;

import org.springframework.beans.factory.annotation.Autowired;

public class People {
    
    /**注意：配置文件中的bean标签的id值要与实体类的属性名一致**/
    private String name;
    @Autowired
    private Dog dog;
    @Autowired
    private Cat cat;

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                ", cat=" + cat +
                '}';
    }

    public String getName() {
        return name;
    }

    public Dog getDog() {
        return dog;
    }

    public Cat getCat() {
        return cat;
    }
}
```

###测试类

```java
@Test
public void MyTest2(){
    ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
    People people = context.getBean("people", People.class);
    System.out.println(people.getName());
    people.getCat().eat();
    people.getDog().eat();
}
```

###注意

1. @Autowired直接在属性上使用即可，也可以直接在set方法上使用
2. 使用@Autowired可以不再编写set方法了，前提是你这个自动装配的的属性在IOC（Spring）容器中存在，且配置文件中的bean标签的id值要与实体类的属性名一致



# 使用使用注解开发

## 注意

1. 在Spring4之后，要使用注解开发，必须要保证aop的包已经导入

   <img src="Spring01-image/image-20200906120134574.png" alt="image-20200906120134574" style="zoom:67%;" />

2. 使用注解需要导入context约束，增加注解的支持

## 搭建环境并测试

###配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">

    <!--开启注解支持-->
    <!--<context:annotation-config/>-->
    
    <!--开启注解扫描:指定要扫描的包，这个包下的注解就会生效 -->
    <context:component-scan base-package="com.bao.pojo" />

</beans>
```

```
<context:annotation-config/>和<context:component-scan/>
	<context:annotation-config/>：可以开启注解支持，主要的目的是使用@Autowired注解
	<context:component-scan/>除了具有<context:annotation-config/>的功能之外，<context:component-scan/>还可以在指定的package下扫描以及注册javabean 。还具有自动将带有@component,@service,@Repository等注解的对象注册到spring容器中的功能。因此当使用<context:component-scan/>后，就可以将<context:annotation-config/>移除。
```



###实体类

```java
package com.bao.pojo;

import org.springframework.stereotype.Component;

/*Component:组件
* 该注解相当于配置文件中的：<bean id="user" class="com.bao.pojo.User"/>
* 说明该类被Spring容器管理了，实体类添加了该注解才能被扫描到*/
@Component
public class User {
    private String name = "陈二";

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

###测试类

```java
import com.bao.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void MyTest1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
```


## 属性如何注入

实体类

```java
package com.bao.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*Component:组件
* 该注解相当于配置文件中的：<bean id="user" class="com.bao.pojo.User"/>
* 说明该类被Spring容器管理了*/
@Component
public class User {

    @Value("孙七")/*简单的属性使用注解更加方便*/
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

## 衍生的注解

> @Component有几个衍生的注解，我们在web开发中，会按照mvc三层架构分层

1. mapper [ @Repository]
2. service[@Service]
3. controller [@Controller]
4. 注：这四个注解功能是一样的，都是代表将某个类注册到Spring容器中 

## 作用域

```java
package com.bao.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*Component:组件
* 该注解相当于配置文件中的：<bean id="user" class="com.bao.pojo.User"/>
* 说明该类被Spring容器管理了*/
@Component
@Scope("prototype")/*值可以设置相应的作用域*/
public class User {

    @Value("孙七")/*简单的属性使用注解更加方便*/
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

## 小结

###xml和注解

1. xml更加万能，适用于任何场合，维护简单方便
2. 注解维护相对复杂

###xml与注解的最佳实践

1. xml用来管理bean
2. 注解只负责完成属性的注入
3. 我们在使用过程中，只需要注意一个问题：必须让注解生效，所以一定要开启注解支持

# 使用java的方式配置bean

##思路

1. 完全不使用Spring的xml 配置，全权交给Java来做！
2. JavaConfig 是Spring的一个子项目 
3. JavaConfig 原来是 Spring 的一个子项目，它通过 Java 类的方式提供 Bean 的定义信息，在 Spring4 的版本， JavaConfig 已正式成为 Spring4 的核心功能 。

##搭建环境测试

###实体类

```java
package com.bao.pojo;

import org.springframework.beans.factory.annotation.Value;

public class User {
    @Value("刘一")
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

###新建一个config配置包，编写一个UserConfig配置类

```java
package com.bao.config;

import com.bao.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration/*该注解说明该类是一个配置类*/
public class UserConfig {
	/*当有多个bean时，都需要在这里进行注册*/
    /*使用该注解相当于在配置文件中写了一个<bean>标签
    * 方法名相当于bean标签中的id属性
    * 方法的返回值相当于bean标签中的class属性*/
    @Bean
    @Scope("prototype")
    public User getUser(){
        return new User();/*返回要注入到bean的对象*/
    }
}

```

###测试

```java
import com.bao.config.UserConfig;
import com.bao.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    @Test
    public void Test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        User user = (User) context.getBean("getUser");
        System.out.println(user);
    }
}

```

## 导入其他配置类

> 再编写一个配置类，将上一个配置类导入

```java
package com.bao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration/*该注解说明该类是一个配置类*/
@Import(UserConfig.class)/*可以使用该注解导入其他的配置类*/
@ComponentScan("com.bao.pojo")/*可以使用该注解设置扫描的包*/
public class AllConfig {

}

```



# 代理模式

## 理解

> 代理模式就是给一个对象提供一种代理对象，以控制对该对象的访问。在这个模式中，我们通过创建代理对象作为“替身”替代了原有对象，从而达到我们控制对象访问的目的
>
> 通俗来讲，代理=代替处理，是由另一个对象来代替原来对象来处理某些逻辑
>
> 例如：送外卖、跑腿业务、房产中介

> 代理模式的重要性：代理模式是SpringAOP 的底层

> 代理模式的分类：静态代理、动态代理

> 代理模式的作用：在不修改原对象代码的基础上，对原对象的功能进行修改或者增强

## 静态代理

###角色分析

> 抽象角色： 一般使用接口或者是抽象类来解决
>
> 真实角色：被代理的角色
>
> 代理角色：代理真实角色，一般还有一些附加操作
>
> 客户： 访问代理对象的人。



###搭建环境、进行测试讲解

#### 图解

![image-20210722144014080](Spring01-image/image-20210722144014080.png)

####功能接口

```java
package com.bao.demo1;

/*出租的接口*/
public interface Rent {
    void rents();
}

```

####真实角色

```java
package com.bao.demo1;

/*房东*/
public class Host implements Rent{
    public void rents() {
        System.out.println("房东出租房子");
    }
}

```

####代理角色

```java
package com.bao.demo1;

/*代理角色也有出租的功能*/
public class Proxy implements Rent {

    //但是代理角色需要代理房东的房子才能出租
    private Host host;

    public Proxy(Host host) {
        this.host = host;
    }

    public void rents() {
        
        host.rents();
        lookHost();
        contract();
        fee();
    }

    //看房
    public void lookHost(){
        System.out.println("中介带你看房");
    }

    //签合同
    public void contract(){
        System.out.println("中介带你签合同");
    }

    //收中介费
    public void fee(){
        System.out.println("中介收中介费");
    }
}

```

####客户端访问代理角色

```java
package com.bao.demo1;

import org.junit.Test;

public class TestRent {
    @Test
    public void test1(){
        Host host = new Host();
        host.rents();
    }

    @Test
    public void test2(){
        Proxy proxy = new Proxy(new Host());
        proxy.rents();
    }

}
```

###代理模式的优点

> 可以使真实角色的操作更加纯粹，不用去关注一些公共业务
>
> 公共业务交给代理对象，实现了业务的分工
>
> 公共业务发生扩展的时候，方便集中管理

###代理模式的缺点 

> 一个真实角色就会产生一个代理角色： 代码量会翻倍

##深入静态代理

###接口

```java
package com.bao.demo2;

public interface UserService {
    void add();
    void delete();
    void update();
    void query();
}
```

###真实对象

```java
package com.bao.demo2;

//真实对象
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("增");
    }

    @Override
    public void delete() {
        System.out.println("删");
    }

    @Override
    public void update() {
        System.out.println("改");
    }

    @Override
    public void query() {
        System.out.println("查");
    }
}
```

###代理对象

```java
package com.bao.demo2;

public class UserServiceProxy implements UserService {

    private UserServiceImpl userService;

    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
       userService.add();
        log();
    }

    @Override
    public void delete() {
        userService.delete();
        log();
    }

    @Override
    public void update() {
        userService.update();
        log();
    }

    @Override
    public void query() {
        userService.query();
        log();
    }

    public void log(){
        System.out.println("日志信息");
    }
}
```

###测试

```java
package com.bao.demo2;

import org.junit.Test;

public class TestUserService {
    @Test
    public void test1(){
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setUserService(userService);
        userServiceProxy.add();
    }
}
```

###注意

> 当我们已经实现了一些功能，在不改变原有代码的情况下，实现了对原有功能的增强，这是AOP的核心思想



## 动态代理

> 动态代理的角色和静态代理的一样 
>
> 动态代理的代理类是动态生成的 . 静态代理的代理类是我们提前写好的
>
> 动态代理分为两类 : 一类是基于接口动态代理 , 一类是基于类的动态代理
>
> > 基于接口的动态代理----JDK原生的动态代理（现在学习的）
> >
> > 基于类的动态代理--cglib

> JDK的动态代理需要了解两个类
>
> > Proxy：生成动态代理这个实例
> >
> > InvocationHandler：调用处理程序并返回结果

###代码实现 

####抽象接口

```java
package com.bao.demo3;

/*出租的接口*/
public interface Rent {
    void rents();
}
```

####真实角色

```java
package com.bao.demo3;

/*房东*/
public class Host implements Rent {
    public void rents() {
        System.out.println("房东出租房子");
    }
}
```

####代理类

> 生成代理类的类

```java
package com.bao.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*自定义一个代理类，需要实现InvocationHandler接口*/
public class ProxyInvocationHandler implements InvocationHandler {
    /*被代理类代理的接口(出租房子的接口)*/
    private Rent rent;

    /*注入接口*/
    public void setRent(Rent rent) {
        this.rent = rent;
    }

    /*生成得到代理类
    * 参数一：传入一个ClassLoader
    * 参数二：传入接口的接口数组 Class<?>[] interfaces = rent.getClass().getInterfaces();
    * 参数三：传入一个InvocationHandler
    * 下面这个方法基本是固定的，可以先使用，然后慢慢理解*/
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);
    }

/*    *//*重写该方法，处理代理实例，返回结果*//*
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //动态代理的本质就是使用反射机制
        Object invoke = method.invoke(rent, args);
        return invoke;
    }*/

    /*重写该方法，处理代理实例，返回结果*/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        lookHost();
        contract();
        Object invoke = method.invoke(rent, args);//相当于对象名.方法名的方式调用
        fee();
        return invoke;
    }

    //看房
    public void lookHost(){
        System.out.println("中介带你看房");
    }

    //签合同
    public void contract(){
        System.out.println("中介带你签合同");
    }

    //收中介费
    public void fee(){
        System.out.println("中介收中介费");
    }

}

```

####测试类

```java
package com.bao.demo3;

import org.junit.Test;

public class TestRent {

    @Test
    public void test1(){
        //创建得到真实角色
        Host host = new Host();

        //得到可以生成代理类的对象
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        //传入需要生成的代理对象的真实角色
        pih.setRent(host);

        //得到代理对象，可以强转为rent类型，因为得到的类是Rent的实现类
        Rent proxy = (Rent) pih.getProxy();

        //测试
        proxy.rents();
    }
}
```

> 理解：
>
> 一个动态代理 , 一般代理某一类业务 
>
> 一个动态代理可以代理多个类，只要实现了同一个接口即可
>
> 动态代理可以理解为是代理类



### 深化理解

> 我们可以尝试编写一个通用的动态代理实现的类，所有的代理对象设置为Object即可

####抽象接口

```java
package com.bao.demo4;

public interface UserService {
    public void add();
    public void delete();
    public void update();
    public void query();
}

```

####真实角色

```java
package com.bao.demo4;

public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("增");
    }

    public void delete() {
        System.out.println("删");
    }

    public void update() {
        System.out.println("改");
    }

    public void query() {
        System.out.println("查");
    }
}

```

####代理类

```java
package com.bao.demo4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*自定义一个代理类，需要实现InvocationHandler接口*/
public class ProxyInvocationHandler implements InvocationHandler {
    /*被代理类代理的接口(出租房子的接口)*/
    private Object object;

    /*注入接口*/
    public void setRent(Object object) {
        this.object = object;
    }

    /*生成得到代理类
    * 参数一：传入一个ClassLoader
    * 参数二：传入接口的接口数组 Class<?>[] interfaces = rent.getClass().getInterfaces();
    * 参数三：传入一个InvocationHandler
    * 下面这个方法基本是固定的，可以先使用，然后慢慢理解*/
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    /*重写该方法，处理代理实例，返回结果*/
/*    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(object, args);
        return invoke;
    }*/

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object invoke = method.invoke(object, args);
        return invoke;
    }

    public void log(String methodName){
        System.out.println("执行了"+methodName+"方法");
    }
}
```

####测试类

```java
package com.bao.demo4;

import org.junit.Test;

public class TestRent {

    @Test
    public void test1(){
        //创建得到真实角色
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        //得到可以生成代理类的类
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        //传入需要生成的代理对象的真实角色
        pih.setRent(userServiceImpl);

        //得到代理对象，可以强转为rent类型，因为得到的类是Rent的实现类
        UserService proxy = (UserService) pih.getProxy();

        //测试
        proxy.delete();

    }
}
```

###动态代理的好处

> 可以使得我们的真实角色更加纯粹 . 不再去关注一些公共的事情 .
>
> 公共的业务由代理来完成 . 实现了业务的分工 ,
>
> 公共业务发生扩展时变得更加集中和方便 .
>
> 一个动态代理 , 一般代理某一类业务
>
> 一个动态代理可以代理多个类，代理的是接口！



# AOP

## 什么是AOP

1.  AOP 翻译过来就是面向切面编程
2.  AOP是维护的一种技术，底层使用的是动态代理，是Spring框架中一个重要内容
3.  作用：利用AOP 可以使业务逻辑之间的耦合度降低，提高程序的可重用性，同时提高开发的效率

> 理解：在原有的业务逻辑中添加验证参数、前置日志、后置日志等功能，并且要求不能改变原有的代码

![image-20210310115108278](Spring01-image/image-20210310115108278.png)



## AOP在Spring中的作用

> 作用：提供声明式事务，允许用户自定义切面

> 名词了解：
>
> > 连接点（JointPoint）：类当中可以被增强的方法。
>
> > 切入点（PointCut）：类当中实际上真正被增强的方法
>
> > 通知（Advice）：具体的增强的功能，比如添加的日志、验证参数等功能
>
> > 切面（ASPECT）：将通知应用到切入点的过程

![image-20210310121159299](Spring01-image/image-20210310121159299.png)



> SpringAOP中，通过Advice定义横切逻辑，Spring中支持5种类型的Advice
>
> 前置增强：org.springframework.aop.BeforeAdvice代表前置增强，因为Spring只支持方法级的增强，故MethodBeforeAdvice是目前可实现的前置增强，**表示在目标方法执行前实施增强**，而BeforeAdvice是为了将来版本扩展需要而定义的；
> 后置增强：org.springframework.aop.AfterReturningAdvice代表后增强，**表示在目标方法执行后实施增强**；
> 环绕增强：org.aopalliance.intercept.MethodInterceptor代表环绕增强，**表示在目标方法执行前后实施增强**；(了解)
> 异常抛出增强：org.springframework.aop.ThrowsAdvice代表抛出异常增强，**表示在目标方法抛出异常后实施增强**；(了解)
> 引介增强（最终增强）：org.springframework.aop.InteoductionInterceptor代表引介增强，**表示在目标类中添加一些新的方法和属性**；(了解)



## execution切入点表达式

```
1.切入点表达式的作用：知道对哪个类里面的哪个方法进行增强
2.语法结构：
	execution([权限修饰符] [返回类型] [类的全路径][方法名](参数列表) [异常模式])
	除了返回类型、方法名和参数外，其它项都是可选的。
	* 代表所有
3.练习：
	(1)对com.bao.dao.UserDao类里面的add方法进行增强
		execution(* com.bao.dao.UserDao.add(..))
		修饰符类型省略，返回类型为任意类型，com.bao.dao.UserDao类的add方法，(..)表示参数
    (2)对com.bao.dao.UserDao类里面的所有的方法进行增强
    	execution(* com.bao.dao.UserDao.*(..))
    (3)对com.bao.dao包下的所有类里面的所有的方法进行增强
    	execution(* com.bao.dao.*.*(..))
```



## 使用Spring实现AOP

###pom文件中导包

```xml
<!--导入aspectj核心包-->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.4</version>
</dependency>
```

> Spring 框架一般都是基于 AspectJ 实现 AOP 操作 
>
> AspectJ 不是 Spring 组成部分， AOP 一般把 AspectJ 和 Spirng 框架一起使用，进行 AOP 操作

###方式一：使用Spring的api接口

####创建接口

```java
package com.bao.service;

import org.springframework.stereotype.Component;

public interface UserService {
    void add();
    void delete();
    void update();
    void query();
}

```

####创建实现类

```java
package com.bao.service;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("增");
    }

    public void delete() {
        System.out.println("删");
    }

    public void update() {
        System.out.println("改");
    }

    public void query() {
        System.out.println("查");
    }
}

```

####创建配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/aop
       https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!--设置扫描包-->
    <context:component-scan base-package="com.bao"/>
<!--
//  配置bean
    <bean id="userServiceImpl" class="com.bao.service.UserServiceImpl"/>
    <bean id="beforeLog" class="com.bao.log.BeforeLog"/>
    <bean id="afterLog" class="com.bao.log.AfterLog"/>-->

    <!--配置aop：导入aop的约束-->
    <aop:config>
        <!--
            设置切入点，这里需要了解execution表达式
        -->
        <aop:pointcut id="pointcut" expression="execution(* com.bao.service.UserServiceImpl.*(..))"/>
        <!--执行前置增强-->
        <!--将log类切入到id为pointcut的切入点-->
        <aop:advisor advice-ref="beforeLog" pointcut-ref="pointcut"/>
        <!--执行后置增强-->
        <!--将afterLog类切入到id为pointcut的切入点-->
        <aop:advisor advice-ref="afterLog" pointcut-ref="pointcut"/>
    </aop:config>
</beans>
```

####创建日志类

```java
package com.bao.log;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/*创建前置增强的日志类，需要实现MethodBeforeAdvice接口*/
@Component
public class BeforeLog implements MethodBeforeAdvice {
    
    /* method:要执行的目标对象的方法
     * objects:参数
     * o：目标对象
     */
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("执行前置增强");
        System.out.println("被执行的类是："+o.getClass().getName());
        System.out.println("被执行的方法是："+method.getName());
    }
}

```

```java
package com.bao.log;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
@Component
public class AfterLog implements AfterReturningAdvice {
    /* o：返回值
     * method:要执行的目标对象的方法
     * objects:参数
     * o1: 目标对象
     */
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行后增强");
        System.out.println("执行的方法是："+method.getName());
        System.out.println("返回结果是："+o);

    }
}
```

####测试类

```java
package com.bao.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userServiceImpl", UserService.class);
        userService.add();
    }
}

```

###方式二：自定义类实现aop

####创建自定义类

```java
package com.bao.diy;

import org.springframework.stereotype.Component;

@Component
public class DiyPointCut {
    public void before(){
        System.out.println("方法执行前");
    }

    public void after(){
        System.out.println("方法执行后");
    }
}

```

####修改配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/aop
       https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!--设置扫描包-->
    <context:component-scan base-package="com.bao"/>

    <!--方式二：自定义类-->
    <!--aspect:切面
        pointcut:切点
        expression:表达
    -->
    <aop:config>
        <!--自定义切面，ref是要引用的类-->
        <aop:aspect ref="diyPointCut">
            <!--设置切入点-->
            <aop:pointcut id="point" expression="execution(* com.bao.service.UserServiceImpl.*(..))"/>
            <!--通知-->
            <!--确定在切入点执行哪一个方法-->
            <aop:before method="before" pointcut-ref="point"/>
            <aop:after method="after" pointcut-ref="point"/>
        </aop:aspect>
    </aop:config>
</beans>
```

####测试类

```java
import com.bao.service.UserService;
import com.bao.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userServiceImpl", UserService.class);
        userService.add();
    }
}
```

###方式三：注解实现aop

####创建切入点类

```java
package com.bao.diy;

/*方式三：使用注解实现aop*/

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect//标注这个类是一个切面
public class AnnotationPointCut {
    /*切入点之前执行的方法*/
    @Before("execution(* com.bao..*.*(..))")
    public void before(){
        System.out.println("方法前");
    }
    /*切入点之后执行的方法*/
    @After("execution(* com.bao..*.*(..))")
    public void after(){
        System.out.println("方法后");
    }

}
```

####修改配置类

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/aop
       https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!--开启注解支持-->
    <!--使用aop的注解，需要手动开启aop的注解支持-->
    <aop:aspectj-autoproxy/>
    <!--注入bean-->
    <bean id="annotationPointCut" class="com.bao.diy.AnnotationPointCut"/>

</beans>
```

####测试类

```java
import com.bao.service.UserService;
import com.bao.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }
}
```

