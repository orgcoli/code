package com.example.guestboard.Repository;

import com.example.guestboard.Entity.Guestbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

@EnableJpaRepositories
public interface GuestbookRepository extends JpaRepository<Guestbook, Long>, QuerydslPredicateExecutor<Guestbook> {
    //JpaRepository<테이블명(Entity명), 기본키의 데이터형 >=> 삽입, 수정, 삭제, 조회처리가 가능
    //QuerydslPredicateExecutor<테이블명(Entity명)> => 페이징하고 검색처리
    //DTO를 이동해서 작업할 DTO를 생성
}
