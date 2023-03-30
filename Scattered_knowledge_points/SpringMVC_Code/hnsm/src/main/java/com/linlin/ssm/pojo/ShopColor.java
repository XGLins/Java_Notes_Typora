package com.linlin.ssm.pojo;

/**
 * 商品颜色类
 */
public class ShopColor {

    /**
     * 私有化成员变量
     */
    /*商品id*/
    private Integer shopId;

    /*颜色参数*/
    private String color;

    /*小图*/
    private String sImg;

    /*大图*/
    private String bImg;


    /**
     * 构造方法（有参 and 无参）
     */
    public ShopColor() {
    }

    public ShopColor(Integer shopId, String color, String sImg, String bImg) {
        this.shopId = shopId;
        this.color = color;
        this.sImg = sImg;
        this.bImg = bImg;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getsImg() {
        return sImg;
    }

    public void setsImg(String sImg) {
        this.sImg = sImg;
    }

    public String getbImg() {
        return bImg;
    }

    public void setbImg(String bImg) {
        this.bImg = bImg;
    }

    /**
     * 重写toString()方法
     */
    @Override
    public String toString() {
        return "ShopColor{" +
                "shopId=" + shopId +
                ", color='" + color + '\'' +
                ", sImg='" + sImg + '\'' +
                ", bImg='" + bImg + '\'' +
                '}';
    }
/**
 * 自定义方法区
 * */


}
