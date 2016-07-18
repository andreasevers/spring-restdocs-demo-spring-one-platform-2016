package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import static org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType.HAL;

@SpringBootApplication
@EnableHypermediaSupport(type = HAL)
public class SOP16DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SOP16DemoApplication.class, args);
    }
}
