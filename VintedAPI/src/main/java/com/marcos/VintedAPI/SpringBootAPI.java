package com.marcos.VintedAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.marcos.VintedAPI.Controller"})
public class SpringBootAPI {
public static void main(String[] args) {
        SpringApplication.run(SpringBootAPI.class, args);
    }
}
