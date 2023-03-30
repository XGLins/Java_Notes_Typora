package com.hnsm.spring.dao.impl;

import com.hnsm.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("添加用户信息成功！");
    }

}
