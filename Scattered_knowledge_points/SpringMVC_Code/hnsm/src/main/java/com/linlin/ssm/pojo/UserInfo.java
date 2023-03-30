package com.linlin.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户信息-实体类
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfo {

    /**
     * 私有化成员变量
     */
    /*用户账号*/
    private String userName;

    /*用户昵称*/
    private String userNick;

    /*真实姓名*/
    private String name;

    /*身份证号*/
    private String shenFenZheng;

    /*居住地址*/
    private String address;

    /*邮箱*/
    private String email;

    /*手机号码*/
    private String phone;

    /*性别 Id*/
    private Integer sexId;

    /*是否是庖铺*/
    private Integer isDianPu;

    /*余额*/
    private Double money;

    /*庖铺余额*/
    private Double dianPuMoney;

    /*头像*/
    private String image;

    /*庖铺说明*/
    private String jianJie;





}
