package com.huinong.mapper;

import com.huinong.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.ListResourceBundle;
import java.util.Map;

/**
 * 对用户的操作-接口
 * */
@Mapper
public interface UserMapper {

    //添加用户信息
    int insertUser();

    //修改用户信息
    int updateUser();

    //删除用户记录
    int deleteUser();

    //查询单个用户的数据
    User getUserById();

    //查询所有的用户信息
    List<User> getAllUser();

    //查询指定用户
    List<User> getAppointUserName(int userName);

    //验证登录
    User checkLoginByMap(Map<String , Integer> map);

    //通过${} 或者 #{ } 添加记录
    int insertUser2(User user);

    //验证登录@Param
    User checkLoginByParam(@Param("userName") String userName , @Param("passWord") String passWord);

    //模糊查询like通配符
//    @MapKey("id")
//    Map<String ,Object> getUserByLike(@Param("userName") String userName);
    List<User> getUserByLike(@Param("userName") String userName);

    //获取自增的主键
    void insertUserAutoKey(User user);

    //通过Map自定义映射关系查询表中的所有数据
//    @MapKey("id")
//    Map<String , Object> CustomMapping();
    List<User> CustomMapping();

    /**
     * 通过分布查询查询用户以及所对应的用户基本信息的第一步
     * 通过分步查询，根据user表中的UserName字段查出UserInfo表中的用户名和真实姓名
     * */
    User getUserAndUserInfoByStepOne(@Param("id") Integer id);



}
