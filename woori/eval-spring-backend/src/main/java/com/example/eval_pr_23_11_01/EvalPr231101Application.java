package com.example.eval_pr_23_11_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EvalPr231101Application {

    public static void main(String[] args) {
        SpringApplication.run(EvalPr231101Application.class, args);
    }

}
