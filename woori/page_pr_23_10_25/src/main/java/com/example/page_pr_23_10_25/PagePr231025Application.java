package com.example.page_pr_23_10_25;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PagePr231025Application {

    public static void main(String[] args) {
        SpringApplication.run(PagePr231025Application.class, args);
    }

}
