package com.linlin.ssm.pojo;

/**
 * Banner -实体类
 */
public class Banner {

    /**
     * 私有化成员变量
     */
    /*默讣 Id*/
    private Integer id;

    /*Banner 图*/
    private String image;

    /*背景颜色*/
    private String bgColor;

    /*Uri 连接*/
    private String href;

    /*是否停用(0 正常 1 停用)*/
    private Integer isTingYong;

    /*备注*/
    private String note;


    /**
     * 构造方法（有参 and 无参）
     */
    public Banner() {
    }

    public Banner(Integer id, String image, String bgColor, String href, Integer isTingYong, String note) {
        this.id = id;
        this.image = image;
        this.bgColor = bgColor;
        this.href = href;
        this.isTingYong = isTingYong;
        this.note = note;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getIsTingYong() {
        return isTingYong;
    }

    public void setIsTingYong(Integer isTingYong) {
        this.isTingYong = isTingYong;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 重写toString()方法
     */
    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", bgColor='" + bgColor + '\'' +
                ", href='" + href + '\'' +
                ", isTingYong=" + isTingYong +
                ", note='" + note + '\'' +
                '}';
    }
/**
 * 自定义方法区
 * */


}
