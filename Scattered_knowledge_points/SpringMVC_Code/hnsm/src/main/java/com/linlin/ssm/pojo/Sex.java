package com.linlin.ssm.pojo;

/**
 * 性别-实体类
 * */
public class Sex {

    /**
     * 私有化成员变量
     */
    private Integer sexId;
    private String sexName;


    /**
     * 构造方法（有参 and 无参）
     */
    public Sex() {
    }

    public Sex(Integer sexId, String sexName) {
        this.sexId = sexId;
        this.sexName = sexName;
    }

    /**
     * getter and setter 方法
     */
    public Integer getSexId() {
        return sexId;
    }

    public void setSexId(Integer sexId) {
        this.sexId = sexId;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    /**
     * 重写toString()方法
     */
    @Override
    public String toString() {
        return "Sex{" +
                "sexId=" + sexId +
                ", sexName='" + sexName + '\'' +
                '}';
    }
/**
 * 自定义方法区
 * */


}
