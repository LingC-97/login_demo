//package com.example.logindemo.controller;
//
//
//import com.example.logindemo.entity.User;
//import com.example.logindemo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//    @Autowired
//    UserService userService;
//
//    @GetMapping("/getlist")
//    public List<User> findUserById( ){
//        List<User> userlist =  userService.getUserList();
//        return userlist;
//
//    }
//
//
//    @GetMapping("/get")
//    public User findUserById(int id ){
//        User user =  userService.findUserById(id);
//        return user;
//
//    }
//    @GetMapping("/getuser")
//    public User findUserByName(String name){
//        User user =  userService.findByUsername(name);
//        return user;
//    }
//
//    @PostMapping("/add")
//    public  boolean addUser(@RequestParam String name,@RequestParam String password){
//        Integer addCount  = userService.add(name,password);
//        if(addCount > 0){
//            return true;
//        }
//        return false;
//    }
////    @PostMapping("/add")
////    public  boolean addUser(@RequestBody User user){
////        Integer addCount  = userService.add(user);
////        if(addCount > 0){
////            return true;
////        }
////        return false;
////    }
//
//
//
//
//
//
//
//}
