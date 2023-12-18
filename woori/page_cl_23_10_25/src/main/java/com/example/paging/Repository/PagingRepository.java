/*
 * 프로그램명   : PagingRepository
 * 설명        : 질의어를 통해서 데이터베이스를 구동처리
 *              JPA에서 제공하는 기본작업
 *              그외 필요한 작업은 개발자가 JPA 규칙이나 Query를 통해서 작업
 * 작 성 자    : 이민호
 * 작성일      : 2023년 10월 25일
 * 수정 사항 : 수정한 내용, 수정일자 수정자
 */

package com.example.paging.Repository;

import com.example.paging.Entity.PagingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagingRepository extends JpaRepository<PagingEntity, Integer> {
    //기본은 삽입, 수정, 삭제, 전체조회, 개별조회
    //검색을 위한 메소드(SQL)를 추가(조회작업이 대부분 작업)
    @Query("SELECT u from PagingEntity u where u.subject like %:subject% order by u.id desc")
    //@Query("SELECT u from PagingEntity u where u.subject like %:subject%")
    List<PagingEntity> findSearch(String subject);
    //개발자 데이터베이스의 SQL 사용법을 익혀야 한다.
    //추가된 메소드는 반드시 단위테스트로 검증
    //전달방식(결과) 메소드명(받은방식(필요한 값))

    //페이지 처리는 findAll 로 처리함
}
