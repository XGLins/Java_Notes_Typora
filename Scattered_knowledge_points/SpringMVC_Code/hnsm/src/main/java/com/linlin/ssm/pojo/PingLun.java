package com.linlin.ssm.pojo;

import java.util.Date;

/**
 * 商品评论-实体类
 * */
public class PingLun {

    /**
     * 私有化成员变量
     * */
    /*默讣 Id*/
    private Integer id;

    /*商品 Id*/
    private Integer shopId;

    /*卖家账号*/
    private String zhuRenUser;

    /*评论的内容*/
    private String context;

    /*买家账号*/
    private String ziJiUser;

    /*评论时间*/
    private Date createTime;



    /**
     * 构造方法（有参 and 无参）
     * */
    public PingLun() {
    }

    public PingLun(Integer id, Integer shopId, String zhuRenUser, String context, String ziJiUser, Date createTime) {
        this.id = id;
        this.shopId = shopId;
        this.zhuRenUser = zhuRenUser;
        this.context = context;
        this.ziJiUser = ziJiUser;
        this.createTime = createTime;
    }
    /**
     * getter and setter 方法
     * */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getZhuRenUser() {
        return zhuRenUser;
    }

    public void setZhuRenUser(String zhuRenUser) {
        this.zhuRenUser = zhuRenUser;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getZiJiUser() {
        return ziJiUser;
    }

    public void setZiJiUser(String ziJiUser) {
        this.ziJiUser = ziJiUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
/**
     * 重写toString()方法
     * */
    @Override
    public String toString() {
        return "PingLun{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", zhuRenUser='" + zhuRenUser + '\'' +
                ", context='" + context + '\'' +
                ", ziJiUser='" + ziJiUser + '\'' +
                ", createTime=" + createTime +
                '}';
    }
/**
     * 自定义方法区
     * */





}
