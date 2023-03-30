package com.huinong.dao.impl;

import com.huinong.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("保存用户成功！");
    }
}
