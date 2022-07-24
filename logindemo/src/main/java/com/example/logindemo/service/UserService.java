package com.example.logindemo.service;

import com.example.logindemo.entity.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {
    public User findUserById(String id);

    public User findByUsername(String name);

    public int add(String name,String password);

    public List<User> getUserList();

    public String getPassword(String name);
}
