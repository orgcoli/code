package com.example.paging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  //날짜 자동 생성
public class PagingApplication {

    public static void main(String[] args) {
        SpringApplication.run(PagingApplication.class, args);
    }

}
