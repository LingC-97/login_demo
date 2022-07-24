package com.example.logindemo.service.impl;

import com.example.logindemo.entity.User;
import com.example.logindemo.service.TokenService;
import com.example.logindemo.util.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public String getToken(User user) {
        return JwtUtil.getToken(user);
    }
}
