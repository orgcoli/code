package com.example.jpauses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JpausesApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpausesApplication.class, args);
    }

}
