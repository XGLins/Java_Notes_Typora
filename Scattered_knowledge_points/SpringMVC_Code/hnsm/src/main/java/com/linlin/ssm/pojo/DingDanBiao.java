package com.linlin.ssm.pojo;

import java.util.Date;

/**
 * 订单-实体类
 */
public class DingDanBiao {

    /**
     * 私有化成员变量
     */
    /*默讣 Id*/
    private Integer id;

    /*订单编号*/
    private String dingDanNumber;

    /*卖家账号*/
    private String zhuRenUser;

    /*订单金额*/
    private Double price;

    /*订单状态 id*/
    private Integer stateId;

    /*下单时间*/
    private Date createTime;

    /*买家账号*/
    private String userName;

    /*支付方式 Id*/
    private Integer zhiFuId;

    /*收货地址 Id*/
    private Integer address;


    /**
     * 构造方法（有参 and 无参）
     */
    public DingDanBiao() {
    }

    public DingDanBiao(Integer id, String dingDanNumber, String zhuRenUser, Double price, Integer stateId, Date createTime, String userName, Integer zhiFuId, Integer address) {
        this.id = id;
        this.dingDanNumber = dingDanNumber;
        this.zhuRenUser = zhuRenUser;
        this.price = price;
        this.stateId = stateId;
        this.createTime = createTime;
        this.userName = userName;
        this.zhiFuId = zhiFuId;
        this.address = address;
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

    public String getDingDanNumber() {
        return dingDanNumber;
    }

    public void setDingDanNumber(String dingDanNumber) {
        this.dingDanNumber = dingDanNumber;
    }

    public String getZhuRenUser() {
        return zhuRenUser;
    }

    public void setZhuRenUser(String zhuRenUser) {
        this.zhuRenUser = zhuRenUser;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getZhiFuId() {
        return zhiFuId;
    }

    public void setZhiFuId(Integer zhiFuId) {
        this.zhiFuId = zhiFuId;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    /**
     * 重写toString()方法
     */
    @Override
    public String toString() {
        return "DingDanBiao{" +
                "id=" + id +
                ", dingDanNumber='" + dingDanNumber + '\'' +
                ", zhuRenUser='" + zhuRenUser + '\'' +
                ", price=" + price +
                ", stateId=" + stateId +
                ", createTime=" + createTime +
                ", userName='" + userName + '\'' +
                ", zhiFuId=" + zhiFuId +
                ", address=" + address +
                '}';
    }
/**
 * 自定义方法区
 * */


}
