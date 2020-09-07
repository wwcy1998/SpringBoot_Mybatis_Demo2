package com.example.mybatis_demo.demo.service;

import com.example.mybatis_demo.demo.model.User;

import java.util.List;

public interface UserService {
    public int getidentifyById(int id);
    public List<User> getBySex(String Sex);
    public boolean UpdateName(int id, String newname);
    boolean add(int id, String name, String sex, String stuid);

    boolean del(int id);
    public String select(int id,int user_id);
}

