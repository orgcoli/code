package com.board.mboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  //날짜처리
public class MboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MboardApplication.class, args);
    }

}
