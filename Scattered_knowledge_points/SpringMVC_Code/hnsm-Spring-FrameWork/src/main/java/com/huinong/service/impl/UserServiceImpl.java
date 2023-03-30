package com.huinong.service.impl;

import com.huinong.dao.UserDao;
import com.huinong.service.UserService;

/**
 * 接口层，实现UserService
 * */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
