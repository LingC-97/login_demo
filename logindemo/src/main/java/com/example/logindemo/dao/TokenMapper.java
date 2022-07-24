package com.example.logindemo.dao;


import com.example.logindemo.entity.User;

public interface TokenMapper {
    public String getToken(User user);
}
