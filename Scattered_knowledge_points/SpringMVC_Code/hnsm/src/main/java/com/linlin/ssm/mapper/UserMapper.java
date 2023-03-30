package com.linlin.ssm.mapper;

import com.linlin.ssm.pojo.User;

public interface UserMapper {

    //用户登录
    User findOne(User user);

    //用户注册
    int addOne(User user);

    //注册时的重名检测
    User checkReg(String username);


}
