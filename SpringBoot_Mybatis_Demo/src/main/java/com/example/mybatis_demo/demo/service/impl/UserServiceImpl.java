package com.example.mybatis_demo.demo.service.impl;

import com.example.mybatis_demo.demo.dao.UserDao;
import com.example.mybatis_demo.demo.model.User;
import com.example.mybatis_demo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int getidentifyById(int id) {
        //业务
        int a = userDao.getidentifyById(id);
      return   a;
    }
    @Override
    public List<User> getBySex(String sex){
        return userDao.getBySex(sex);
    }

    @Override
    public boolean UpdateName(int id, String newname) {
         try{
            userDao.UpdateName(id,newname);
            return true;}
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    @Override
    public boolean add(int id, String name ,String sex,String stuid){
        try{

                userDao.add(id, name, sex, stuid);
                return true;



        }
        catch ( Exception e){
            return false;
        }

    }

    @Override
    public boolean del(int id) {
        userDao.del(id);
        return true;
    }

    //select
    @Override
    public String select(int id ,int user_id){

            return  userDao.select(id,user_id);

    }
}
