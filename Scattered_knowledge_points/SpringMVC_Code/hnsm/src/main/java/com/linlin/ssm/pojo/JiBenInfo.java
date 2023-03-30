package com.linlin.ssm.pojo;

/**
 * 基本信息-实体类
 */
public class JiBenInfo {

    /**
     * 私有化成员变量
     */
    /*默讣 Id*/
    private Integer id;

    /*键*/
    private String key;

    /*值*/
    private String value;


    /**
     * 构造方法（有参 and 无参）
     */
    public JiBenInfo() {
    }

    public JiBenInfo(Integer id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 重写toString()方法
     */
    @Override
    public String toString() {
        return "JiBenInfo{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
/**
 * 自定义方法区
 * */


}
