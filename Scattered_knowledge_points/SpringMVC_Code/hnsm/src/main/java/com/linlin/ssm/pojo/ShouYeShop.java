package com.linlin.ssm.pojo;

/**
 * 首页商品-实体类
 */
public class ShouYeShop {

    /**
     * 私有化成员变量
     */
    /*默讣 Id*/
    private Integer id;

    /*商品 Id*/
    private Integer shopId;

    /*商品类型 Id*/
    private Integer shopTypeId;


    /**
     * 构造方法（有参 and 无参）
     */
    public ShouYeShop() {
    }

    public ShouYeShop(Integer id, Integer shopId, Integer shopTypeId) {
        this.id = id;
        this.shopId = shopId;
        this.shopTypeId = shopTypeId;
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

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getShopTypeId() {
        return shopTypeId;
    }

    public void setShopTypeId(Integer shopTypeId) {
        this.shopTypeId = shopTypeId;
    }

    /**
     * 重写toString()方法
     */
    @Override
    public String toString() {
        return "ShouYeShop{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", shopTypeId=" + shopTypeId +
                '}';
    }
/**
 * 自定义方法区
 * */


}
