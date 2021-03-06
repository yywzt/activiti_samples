package com.example;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ActivitiSimplesSimplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiSimplesSimplesApplication.class, args);
    }
}
