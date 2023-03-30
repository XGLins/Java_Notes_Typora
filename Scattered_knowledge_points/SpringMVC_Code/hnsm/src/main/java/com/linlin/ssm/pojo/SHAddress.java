package com.linlin.ssm.pojo;

/**
 * 收货地址-实体类
 */
public class SHAddress {

    /**
     * 私有化成员变量
     */
    /*默讣 Id*/
    private Integer id;

    /*用户账号*/
    private String userName;

    /*收货人姓名*/
    private String name;

    /*手机号*/
    private String Phone;

    /*备用手机号*/
    private String bYPhone;

    /*所在地区*/
    private String city;

    /*详细地址*/
    private String address;

    /*标签*/
    private String lable;


    /**
     * 构造方法（有参 and 无参）
     */
    public SHAddress() {
    }

    public SHAddress(Integer id, String userName, String name, String phone, String bYPhone, String city, String address, String lable) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        Phone = phone;
        this.bYPhone = bYPhone;
        this.city = city;
        this.address = address;
        this.lable = lable;
    }

    /**
     * getter and setter 方法
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getbYPhone() {
        return bYPhone;
    }

    public void setbYPhone(String bYPhone) {
        this.bYPhone = bYPhone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    /**
     * 重写toString()方法
     */
    @Override
    public String toString() {
        return "SHAddress{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", Phone='" + Phone + '\'' +
                ", bYPhone='" + bYPhone + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", lable='" + lable + '\'' +
                '}';
    }
/**
 * 自定义方法区
 * */


}
