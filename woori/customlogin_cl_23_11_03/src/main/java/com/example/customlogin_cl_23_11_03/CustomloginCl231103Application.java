package com.example.customlogin_cl_23_11_03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CustomloginCl231103Application {

    public static void main(String[] args) {
        SpringApplication.run(CustomloginCl231103Application.class, args);
    }

}
