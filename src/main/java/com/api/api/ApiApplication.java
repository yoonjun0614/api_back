package com.api.api;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@Slf4j
@MapperScan("com.api.api")
public class ApiApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
