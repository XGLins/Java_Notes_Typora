package com.linlin.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 *用户-实体类
 * */
/*getter and setter 方法*/
@Data
/*有参构造*/
@AllArgsConstructor
/*无参构造*/
@NoArgsConstructor
/*ToString方法*/
@ToString
public class User {

    /**
     * 私有化成员变量
     * */
    /*默认Id*/
    private Integer id;

    /*用户账号*/
    private String userName;

    /*用户密码*/
    private String passWord;

    /*账号是否停用（0是正常1是停用）*/
    private int state;

    /*注册日期*/
    private Date createTime;
}
