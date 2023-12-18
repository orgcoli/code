package com.example.movie_cl_23_11_06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MovieCl231106Application {

    public static void main(String[] args) {
        SpringApplication.run(MovieCl231106Application.class, args);
    }

}
