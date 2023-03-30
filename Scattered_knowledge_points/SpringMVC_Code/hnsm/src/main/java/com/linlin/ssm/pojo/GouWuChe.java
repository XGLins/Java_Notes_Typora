package com.linlin.ssm.pojo;

/**
 * 购物车-实体类
 */
public class GouWuChe {

    /**
     * 私有化成员变量
     */
    /*默讣 Id*/
    private Integer id;

    /*用户账号*/
    private String userName;

    /*商品标题*/
    private String shopName;

    /*尺寸*/
    private String chiCui;

    /*颜色*/
    private String color;

    /*数量*/
    private Integer count;

    /*单价*/
    private Double price;

    /*商品图片*/
    private String image;


    /**
     * 构造方法（有参 and 无参）
     */
    public GouWuChe() {
    }

    public GouWuChe(Integer id, String userName, String shopName, String chiCui, String color, Integer count, Double price, String image) {
        this.id = id;
        this.userName = userName;
        this.shopName = shopName;
        this.chiCui = chiCui;
        this.color = color;
        this.count = count;
        this.price = price;
        this.image = image;
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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getChiCui() {
        return chiCui;
    }

    public void setChiCui(String chiCui) {
        this.chiCui = chiCui;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 重写toString()方法
     */
    @Override
    public String toString() {
        return "GouWuChe{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", shopName='" + shopName + '\'' +
                ", chiCui='" + chiCui + '\'' +
                ", color='" + color + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
/**
 * 自定义方法区
 * */


}
