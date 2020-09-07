package com.example.mybatis_demo.demo.dao;


import com.example.mybatis_demo.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    public int getidentifyById(int id);
    public List<User> getBySex(String sex);
    public boolean UpdateName(int id, String newname);
    void add(int id, String name, String sex, String stuid);
    void del(int id);
    public String select(int id , int user_id);
}
