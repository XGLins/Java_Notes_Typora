package com.linlin.ssm.pojo;

import java.util.Date;

/**
 *所有商品信息-实体类
 * */
public class ShopInfo {

    /**
     * 私有化成员变量
     */
    /*商品 Id*/
    private Integer shopId;

    /*商品名称*/
    private String shopName;

    /*商品描述*/
    private String shopMiaoShu;

    /*商品价格*/
    private Double shopPrice;

    /*尺寸*/
    private String chiCun;

    /*商品颜色*/
    private String color;

    /*卖家账号*/
    private String zhuRenUser;

    /*商品类别 id*/
    private Integer shopTypeId;

    /*商品封面图*/
    private String image;

    /*商品介绍*/
    private String context;

    /*商品发表日期*/
    private Date createTime;


    /**
     * 构造方法（有参 and 无参）
     */
    public ShopInfo() {
    }

    public ShopInfo(Integer shopId, String shopName, String shopMiaoShu, Double shopPrice, String chiCun, String color, String zhuRenUser, Integer shopTypeId, String image, String context, Date createTime) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopMiaoShu = shopMiaoShu;
        this.shopPrice = shopPrice;
        this.chiCun = chiCun;
        this.color = color;
        this.zhuRenUser = zhuRenUser;
        this.shopTypeId = shopTypeId;
        this.image = image;
        this.context = context;
        this.createTime = createTime;
    }

    /**
     * getter and setter 方法
     */
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopMiaoShu() {
        return shopMiaoShu;
    }

    public void setShopMiaoShu(String shopMiaoShu) {
        this.shopMiaoShu = shopMiaoShu;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getChiCun() {
        return chiCun;
    }

    public void setChiCun(String chiCun) {
        this.chiCun = chiCun;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getZhuRenUser() {
        return zhuRenUser;
    }

    public void setZhuRenUser(String zhuRenUser) {
        this.zhuRenUser = zhuRenUser;
    }

    public Integer getShopTypeId() {
        return shopTypeId;
    }

    public void setShopTypeId(Integer shopTypeId) {
        this.shopTypeId = shopTypeId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 重写toString()方法
     */
    @Override
    public String toString() {
        return "ShopInfo{" +
                "shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                ", shopMiaoShu='" + shopMiaoShu + '\'' +
                ", shopPrice=" + shopPrice +
                ", chiCun='" + chiCun + '\'' +
                ", color='" + color + '\'' +
                ", zhuRenUser='" + zhuRenUser + '\'' +
                ", shopTypeId=" + shopTypeId +
                ", image='" + image + '\'' +
                ", context='" + context + '\'' +
                ", createTime=" + createTime +
                '}';
    }
/**
 * 自定义方法区
 * */


}
