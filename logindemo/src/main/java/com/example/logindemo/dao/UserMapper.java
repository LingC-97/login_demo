package com.example.logindemo.dao;


import com.example.logindemo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;
@Mapper
public interface UserMapper {
    @Select(value = "select * from user where id=#{id}")
    public User findUserById(String id);

    @Select(value = "select * from user where name=#{name}")
    public User findByUsername(String name);

    @Insert(value = "insert into user (name,password) values (#{name},#{password})")
    public int add(String name,String password);

    @Select(value = "select * from user")
    public  List<User> getUserList();

    @Select(value = "select password from user where name=#{name}")
    public  String getPassword(String name);

}
