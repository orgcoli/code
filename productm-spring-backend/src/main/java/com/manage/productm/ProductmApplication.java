package com.manage.productm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  //Entity 처리시 날짜처리
public class ProductmApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductmApplication.class, args);
    }

}
