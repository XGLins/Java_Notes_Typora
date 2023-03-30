package com.linlin.ssm.pojo;

/**
 * 订单详情-实体类
 */
public class DingDanXiangQing {

    /**
     * 私有化成员变量
     */
    /*默讣 Id*/
    private Integer id;

    /*订单编号*/
    private String dingDanNumber;

    /*商品 Id*/
    private Integer shopId;

    /*尺寸*/
    private String chiCui;

    /*颜色*/
    private String color;


    /**
     * 构造方法（有参 and 无参）
     */
    public DingDanXiangQing() {
    }

    public DingDanXiangQing(Integer id, String dingDanNumber, Integer shopId, String chiCui, String color) {
        this.id = id;
        this.dingDanNumber = dingDanNumber;
        this.shopId = shopId;
        this.chiCui = chiCui;
        this.color = color;
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

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
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

    /**
     * 重写toString()方法
     */
    @Override
    public String toString() {
        return "DingDanXiangQing{" +
                "id=" + id +
                ", dingDanNumber='" + dingDanNumber + '\'' +
                ", shopId=" + shopId +
                ", chiCui='" + chiCui + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
/**
 * 自定义方法区
 * */


}
