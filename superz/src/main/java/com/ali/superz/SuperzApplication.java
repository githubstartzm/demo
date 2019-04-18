package com.ali.superz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ali.superz.dao")
public class SuperzApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperzApplication.class, args);
    }

}
