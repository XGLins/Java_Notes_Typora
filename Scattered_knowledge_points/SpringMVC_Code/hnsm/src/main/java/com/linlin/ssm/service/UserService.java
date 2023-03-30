package com.linlin.ssm.service;

import com.linlin.ssm.pojo.User;

public interface UserService {

    //用户登录
    User findOne(User user);

    //用户注册
    int addOne(User user);

    //注册时的重名检测
    User checkReg(String username);


}
