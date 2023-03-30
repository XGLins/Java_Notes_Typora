package com.linlin.ssm.pojo;

/**
 * 商品明细表-实体类
 */
public class ShopMingXi {

    /**
     * 私有化成员变量
     */
    /*商品 id*/
    private Integer shopId;

    /*商品小图*/
    private String sImg;

    /*商品大图*/
    private String bImg;


    /**
     * 构造方法（有参 and 无参）
     */
    public ShopMingXi() {
    }

    public ShopMingXi(Integer shopId, String sImg, String bImg) {
        this.shopId = shopId;
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
        return "ShopMingXi{" +
                "shopId=" + shopId +
                ", sImg='" + sImg + '\'' +
                ", bImg='" + bImg + '\'' +
                '}';
    }
/**
 * 自定义方法区
 * */


}
