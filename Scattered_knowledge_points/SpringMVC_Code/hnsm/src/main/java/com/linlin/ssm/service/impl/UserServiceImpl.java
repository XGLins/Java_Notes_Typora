package com.linlin.ssm.service.impl;

import com.linlin.ssm.mapper.UserMapper;
import com.linlin.ssm.pojo.User;
import com.linlin.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Service
 * 创建业务层组件
 * */
@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    //用户登录
    @Override
    public User findOne(User user) {
        return userMapper.findOne(user);
    }

    //用户注册
    @Override
    public int addOne(User user) {
        return userMapper.addOne(user);

    }

    //注册时的重名检测
    @Override
    public User checkReg(String username) {
        return userMapper.checkReg(username);
    }


}
