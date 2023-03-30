package com.huinong.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {

    public static SqlSession getSqlSession() {

        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            //1.获取核心配置文件的字节输入流，返回值就是一个字节输入流动，要知道核心配置文件里面写的是什么
            is = Resources.getResourceAsStream("mybatis-config.xml");

            //2.获取SqlSessionFactoryBuilder对象，找到一个能帮我能执行sql语句的对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

            //3.获取SqlSessionFactory对象，build()通过核心配置文件输入流获取，直接把is给build()
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

            //4.获取sql的会话对象SqlSession(会自动提交事务)，是MyBatis提供的操作数据库的对象
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
