package com.example.logindemo.service.impl;

import com.example.logindemo.dao.UserMapper;
import com.example.logindemo.entity.User;
import com.example.logindemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    public User findUserById(String id){
        User user = userMapper.findUserById(id);
        return user;
    }



    public  User findByUsername(String name){
        User user = userMapper.findByUsername(name);
        return user;
    }


    public int add(String name,String password) {
        return userMapper.add(name,password);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public String getPassword(String name) {
        return userMapper.getPassword(name);
    }


}
