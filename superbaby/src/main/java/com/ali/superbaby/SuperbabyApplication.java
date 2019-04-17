package com.ali.superbaby;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ali.superbaby.dao")
public class SuperbabyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperbabyApplication.class, args);
    }

}
