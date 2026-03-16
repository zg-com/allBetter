package com.learningmplat.backend;

import org.mybatis.spring.annotation.MapperScan; // 记得导入这个包
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan("com.learningmplat.backend.mapper")
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}