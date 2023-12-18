/*======================================================================================================
 * 프로그램명    : PageRepository
 * 설명 : 질의어를 통해서 데이터베이스 구동처리
 *       JPA에서 기본 CRUD 작업
 *       필요시 JPA나 Query사용하여 추가.
 * 작성자 : 이민호
 * 작성일 : 2023-10-25
 * 수정사항 : ----
 ======================================================================================================*/


package com.example.page_pr_23_10_25.Repository;

import com.example.page_pr_23_10_25.Entity.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<PageEntity, Integer> {
}
