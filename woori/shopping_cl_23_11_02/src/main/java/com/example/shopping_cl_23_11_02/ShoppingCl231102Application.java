package com.example.shopping_cl_23_11_02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//3.
@EnableJpaAuditing
public class ShoppingCl231102Application {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCl231102Application.class, args);
    }

}
