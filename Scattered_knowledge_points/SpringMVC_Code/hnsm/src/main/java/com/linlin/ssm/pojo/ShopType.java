package com.linlin.ssm.pojo;

/**
 * 商品类型-实体类
 * */
public class ShopType {

    /**
     * 私有化成员变量
     */
    /*商品 id*/
    private Integer shopTypeId;

    /*商品类别名称*/
    private String shopTypeName;


    /**
     * 构造方法（有参 and 无参）
     */
    public ShopType() {
    }

    public ShopType(Integer shopTypeId, String shopTypeName) {
        this.shopTypeId = shopTypeId;
        this.shopTypeName = shopTypeName;
    }

    /**
     * getter and setter 方法
     */
    public Integer getShopTypeId() {
        return shopTypeId;
    }

    public void setShopTypeId(Integer shopTypeId) {
        this.shopTypeId = shopTypeId;
    }

    public String getShopTypeName() {
        return shopTypeName;
    }

    public void setShopTypeName(String shopTypeName) {
        this.shopTypeName = shopTypeName;
    }

    /**
     * 重写toString()方法
     */
    @Override
    public String toString() {
        return "ShopType{" +
                "shopTypeId=" + shopTypeId +
                ", shopTypeName='" + shopTypeName + '\'' +
                '}';
    }
/**
 * 自定义方法区
 * */


}
