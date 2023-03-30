package com.linlin.ssm.pojo;

/**
 * 订单状态-实体类
 * */
public class DingDanState {

    /**
     * 私有化成员变量
     * */
    /*订单状态 Id*/
    private Integer stateId;

    /*订单状态名称*/
    private String stateName;



    /**
     * 构造方法（有参 and 无参）
     * */
    public DingDanState() {
    }

    public DingDanState(Integer stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }
    /**
     * getter and setter 方法
     * */
    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
/**
     * 重写toString()方法
     * */
    @Override
    public String toString() {
        return "DingDanState{" +
                "stateId=" + stateId +
                ", stateName='" + stateName + '\'' +
                '}';
    }
/**
     * 自定义方法区
     * */





}
