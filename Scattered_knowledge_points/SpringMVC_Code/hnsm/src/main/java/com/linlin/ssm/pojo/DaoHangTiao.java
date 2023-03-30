package com.linlin.ssm.pojo;

/**
 * 导航条-实体类
 * */
public class DaoHangTiao {

    /**
     * 私有化成员变量
     */
    /*默讣 Id（自增 1）*/
    private Integer id;

    /*导航条名称*/
    private String daoHangTiaoName;

    /*Uri 连接*/
    private String href;

    /*是否停用（0 正常 1 停用）*/
    private Integer isTingYong;


    /**
     * 构造方法（有参 and 无参）
     */
    public DaoHangTiao() {
    }

    public DaoHangTiao(Integer id, String daoHangTiaoName, String href, Integer isTingYong) {
        this.id = id;
        this.daoHangTiaoName = daoHangTiaoName;
        this.href = href;
        this.isTingYong = isTingYong;
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

    public String getDaoHangTiaoName() {
        return daoHangTiaoName;
    }

    public void setDaoHangTiaoName(String daoHangTiaoName) {
        this.daoHangTiaoName = daoHangTiaoName;
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

    /**
     * 重写toString()方法
     */
    @Override
    public String toString() {
        return "DaoHangTiao{" +
                "id=" + id +
                ", daoHangTiaoName='" + daoHangTiaoName + '\'' +
                ", href='" + href + '\'' +
                ", isTingYong=" + isTingYong +
                '}';
    }
/**
 * 自定义方法区
 * */


}
