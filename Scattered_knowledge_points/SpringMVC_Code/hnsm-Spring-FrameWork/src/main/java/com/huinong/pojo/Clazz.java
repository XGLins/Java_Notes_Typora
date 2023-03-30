package com.huinong.pojo;

import java.util.List;

public class Clazz {
    private Integer cid;
    private String cname;
    private List<Student> students;

    //无参 与 有参 构造
    public Clazz() {
    }
    public Clazz(Integer cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    //get 和 set方法
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", students=" + students +
                '}';
    }
}
