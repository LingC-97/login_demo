package com.example.logindemo.service;

import com.example.logindemo.entity.User;

public interface TokenService {
    public String getToken(User user);
}
