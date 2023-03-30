package com.huinong.mapper;

import com.huinong.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户基础信息表
 * */
@Mapper
public interface UserInfoMapper {

    /**
     * 通过分布查询查询用户以及所对应的用户基本信息的第二步
     * 通过分步查询，根据user表中的UserName字段查出UserInfo表中的用户名和真实姓名
     * */
    UserInfo getUserAndUserInfoByStepTwo(@Param("username") String userName);



}
