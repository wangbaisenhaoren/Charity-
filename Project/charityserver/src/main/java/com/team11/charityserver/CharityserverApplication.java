package com.team11.charityserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.team11.charityserver")
public class CharityserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(CharityserverApplication.class, args);
    }

}
