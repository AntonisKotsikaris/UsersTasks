package com.example.springbamigos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // this makes the class to serve rest points
public class SpringBAmigosApplication {


    public static void main(String[] args) {
            SpringApplication.run(SpringBAmigosApplication.class, args);
    }

}
