package com.huinong.pojo;


import java.util.Date;

/**
 * 用户实体类
 * */
public class User {
    //私有化成员变量
    private int id ;
    private String userName;
    private String passWord;
    private int state;
    private Date createTime;
    private Date dd = new Date();
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    //构造方法
    public User() {
    }

    public User(int id, String userName, String passWord, int state, Date createTime) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.state = state;
        this.createTime = createTime;
    }

    //get and set方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", userInfo=" + userInfo +
                '}';
    }
}
