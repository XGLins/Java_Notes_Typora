package com.huinong.mapper;

import com.huinong.pojo.User;
import com.huinong.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 动态SQL
 * */
public interface DynamicSQLMapper {

    /**
     * 根据条件查询员工信息
     * */
    List<UserInfo> getUserInfoByCondition(UserInfo userInfo);

    /**
     * 使用list集合批量添加记录
     * */
    void insertMoreUser(@Param("user") List<User> user);

    void deleteMoreUser(@Param("user") Integer[] user);

}
