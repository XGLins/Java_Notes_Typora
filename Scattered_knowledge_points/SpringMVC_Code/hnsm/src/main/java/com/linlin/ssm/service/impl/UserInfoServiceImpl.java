package com.linlin.ssm.service.impl;

import com.linlin.ssm.mapper.UserInfoMapper;
import com.linlin.ssm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    private UserInfoMapper userInfoMapper;



}
