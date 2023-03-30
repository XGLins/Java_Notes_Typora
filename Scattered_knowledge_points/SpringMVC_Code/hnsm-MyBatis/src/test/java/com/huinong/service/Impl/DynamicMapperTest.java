package com.huinong.service.Impl;

import com.huinong.mapper.DynamicSQLMapper;
import com.huinong.pojo.User;
import com.huinong.pojo.UserInfo;
import com.huinong.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DynamicMapperTest {

    @Test
    public void testGetUserInfoBycondition(){

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        UserInfo userInfo = new UserInfo("","unic","黄蓉",null,null,null,null,0,0,0,0,null,null);
        List<UserInfo> userInfoByConditionList = mapper.getUserInfoByCondition(userInfo);

        userInfoByConditionList.forEach(System.out::println);

    }

    @Test
    public void testInsertMoreUser(){
        Date date = new Date();

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);

        User user1 = new User(0,"丽丽1","19",1,date);
        User user2 = new User(0,"丽丽2","19",1,date);
        User user3 = new User(0,"丽丽3","19",3,date);

        List<User> list = Arrays.asList(user1, user2, user3);

        mapper.insertMoreUser(list);

    }

    @Test
    public void testDeleteMoreUser(){
        Date date = new Date();

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);

        Integer[] userIds = new Integer[]{13,16};
        mapper.deleteMoreUser(userIds);

    }

}
