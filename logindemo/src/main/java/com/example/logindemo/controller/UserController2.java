package com.example.logindemo.controller;


import com.example.logindemo.annotation.PassToken;
import com.example.logindemo.annotation.UserLoginToken;
import com.example.logindemo.common.ApiResponse;
import com.example.logindemo.common.ApiStatusEnum;
import com.example.logindemo.entity.User;
import com.example.logindemo.service.TokenService;
import com.example.logindemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController2 {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    @PostMapping("/login")
    public ApiResponse login(@RequestParam String name ,@RequestParam String password){
        boolean flag ;
        HashMap<String ,Object> userMap = new HashMap<>();
//      先查用户名有没有
        User user = userService.findByUsername(name);
        if(user !=null){   //user不是null，再去查密码
            String  userpassword = userService.getPassword(name);
            if(userpassword.equals(password)){
                flag = true;
            }
            else{
                flag = false;
                return ApiResponse.fail("密码不正确");
            }
            userMap.put("isMarch",flag);
            String token = tokenService.getToken(user);
            System.out.println(token);
            userMap.put("token",token);
        }
        else{  //user为null，再去查就没有意义
            return ApiResponse.fail("用户不存在");
        }
        return ApiResponse.success(userMap);
    }

    @PostMapping("/register")
    public ApiResponse register(@RequestParam String name,@RequestParam String password ){
        //判断用户名是否已经存在了，存在了就不能注册
        User user = userService.findByUsername(name);
        if(user!=null){//说明已经存在
            return ApiResponse.fail("用户已经存在，不能注册");
        }
        Integer addCount  = userService.add(name,password);  //插入了之后addcount就是1
        if(addCount > 0){
            return ApiResponse.success();
        }
        return ApiResponse.fail();

    }

    // 请求的时候在header中传入token
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }


    @PassToken
    @RequestMapping("/getInfo")
    public String getInfo(){
        return "欢迎来到java后端指南";
    }



    @GetMapping("/getlist")
    public ApiResponse getUserList( ){
        List<User> userlist =  userService.getUserList();
        HashMap<String ,Object> userMap = new HashMap<>();
        userMap.put("list",userlist);
        return ApiResponse.success(userMap);

    }

    @GetMapping("/getuser")
    public ApiResponse findUserByName(@RequestParam String name){
        User user =  userService.findByUsername(name);
        HashMap<String ,Object> userMap = new HashMap<>();
        userMap.put("list",user);
        return ApiResponse.success(userMap);
    }

    @PostMapping("/getpassword")
    public ApiResponse getPassword(@RequestParam String name ){
        String  str = userService.getPassword(name);
        HashMap<String ,Object> userMap = new HashMap<>();
        userMap.put("str",str);
        return ApiResponse.success(userMap);
    }



}
