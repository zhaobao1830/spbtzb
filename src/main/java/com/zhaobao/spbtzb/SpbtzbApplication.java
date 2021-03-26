package com.zhaobao.spbtzb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zhaobao.spbtzb.dao")
public class SpbtzbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbtzbApplication.class, args);
    }

}
