package com.linlin.ssm.pojo;

/**
 * 支付方式
 */
public class ZhiFuType {

    /**
     * 私有化成员变量
     */
    /*支付方式 Id*/
    private Integer zhiFuId;

    /*支付方式名称*/
    private String zhiFuName;


    /**
     * 构造方法（有参 and 无参）
     */
    public ZhiFuType() {
    }

    public ZhiFuType(Integer zhiFuId, String zhiFuName) {
        this.zhiFuId = zhiFuId;
        this.zhiFuName = zhiFuName;
    }

    /**
     * getter and setter 方法
     */
    public Integer getZhiFuId() {
        return zhiFuId;
    }

    public void setZhiFuId(Integer zhiFuId) {
        this.zhiFuId = zhiFuId;
    }

    public String getZhiFuName() {
        return zhiFuName;
    }

    public void setZhiFuName(String zhiFuName) {
        this.zhiFuName = zhiFuName;
    }

    /**
     * 重写toString()方法
     */
    @Override
    public String toString() {
        return "ZhiFuType{" +
                "zhiFuId=" + zhiFuId +
                ", zhiFuName='" + zhiFuName + '\'' +
                '}';
    }
/**
 * 自定义方法区
 * */


}
