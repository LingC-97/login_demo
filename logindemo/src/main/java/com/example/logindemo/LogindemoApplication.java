package com.example.logindemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


//@ComponentScan(basePackages = "com.example.logindemo.dao")
@SpringBootApplication
@MapperScan(basePackages = "com.example.logindemo.dao")
public class LogindemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogindemoApplication.class, args);
	}

}
