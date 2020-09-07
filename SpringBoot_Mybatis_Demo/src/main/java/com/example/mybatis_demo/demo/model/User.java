package com.example.mybatis_demo.demo.model;



public class User {

    private int id;
    private String name;
    private String Sex;
    private int identify;
    public int getIdentify() {
        return identify;
    }

    public void setidentify(int identify) {
        this.identify = identify;
    }



    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    private String stuid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdentify(int identify) {
        this.identify = identify;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}