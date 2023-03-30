package com.huinong.pojo;

import java.util.Date;

/**
 * 用户基础信息实体类
 * */
public class UserInfo {

    //私有化成员变量
    private String userName;
    private String userNick;
    private String name;
    private String shenFenZheng;
    private String address;
    private String email;
    private String phone;
    private int sexId;
    private int isDianPu;
    private double money;
    private double dianPuMoney;
    private String image;
    private String jianJie;

    //构造方法
    public UserInfo() {
    }

    public UserInfo(String userName, String userNick, String name, String shenFenZheng,
                    String address, String email, String phone, int sexId, int isDianPu,
                    double money, double dianPuMoney, String image, String jianJie) {
        this.userName = userName;
        this.userNick = userNick;
        this.name = name;
        this.shenFenZheng = shenFenZheng;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.sexId = sexId;
        this.isDianPu = isDianPu;
        this.money = money;
        this.dianPuMoney = dianPuMoney;
        this.image = image;
        this.jianJie = jianJie;
    }

    //get and set方法

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShenFenZheng() {
        return shenFenZheng;
    }

    public void setShenFenZheng(String shenFenZheng) {
        this.shenFenZheng = shenFenZheng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSexId() {
        return sexId;
    }

    public void setSexId(int sexId) {
        this.sexId = sexId;
    }

    public int getIsDianPu() {
        return isDianPu;
    }

    public void setIsDianPu(int isDianPu) {
        this.isDianPu = isDianPu;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getDianPuMoney() {
        return dianPuMoney;
    }

    public void setDianPuMoney(double dianPuMoney) {
        this.dianPuMoney = dianPuMoney;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getJianJie() {
        return jianJie;
    }

    public void setJianJie(String jianJie) {
        this.jianJie = jianJie;
    }


    //重写toString方法


    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", userNick='" + userNick + '\'' +
                ", name='" + name + '\'' +
                ", shenFenZheng='" + shenFenZheng + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sexId=" + sexId +
                ", isDianPu=" + isDianPu +
                ", money=" + money +
                ", dianPuMoney=" + dianPuMoney +
                ", image='" + image + '\'' +
                ", jianJie='" + jianJie + '\'' +
                '}';
    }
}
