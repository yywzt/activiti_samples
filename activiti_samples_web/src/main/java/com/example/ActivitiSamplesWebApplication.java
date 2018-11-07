package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {
        org.activiti.spring.boot.SecurityAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
//@ComponentScan({"org.activiti.rest.editor","com.example"})
@ComponentScan("com.example")
public class ActivitiSamplesWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiSamplesWebApplication.class, args);
    }
}
