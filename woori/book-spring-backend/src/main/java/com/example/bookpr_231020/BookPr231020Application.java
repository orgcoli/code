package com.example.bookpr_231020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BookPr231020Application {

    public static void main(String[] args) {
        SpringApplication.run(BookPr231020Application.class, args);
    }

}
