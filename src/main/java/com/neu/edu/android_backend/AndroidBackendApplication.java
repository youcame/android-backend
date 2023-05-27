package com.neu.edu.android_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.neu.edu.android_backend.mapper")
public class AndroidBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AndroidBackendApplication.class, args);
    }

}
