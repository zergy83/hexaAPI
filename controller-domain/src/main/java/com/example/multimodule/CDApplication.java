package com.example.multimodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CDApplication {

    public static void main(String[] args) {
        SpringApplication.run(CDApplication.class, args);
    }
}
