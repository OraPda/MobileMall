package com.edu.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.edu.mall.mapper")
@ComponentScan(basePackages = {"com.edu.mall.pojo"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
