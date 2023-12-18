package com.example.jpauses.Repository;

import com.example.jpauses.Entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<BoardEntity, Integer> {
    List<BoardEntity> findAllBySubjectContains(String subject); //제목만 조회
    List<BoardEntity> findAllByUsernameContains(String username);
    @Query("Select u FROM BoardEntity u where u.subject like %:subject% or u.username like %:subject%")
    List<BoardEntity> findSearch(String subject);

    List<BoardEntity> findAllByUsernameContainsOrUsernameContains(String subject, String username);
}
//Query(DML- 데이터베이스 조작어)
//삽입 : INSERT 테이블(필드명...) into (값, ....) - save()
//수정 : UPDATE 테이블 set 필드=값, 필드값,.... WHERE 조건 - save()
//삭제 : DELETE FROM 테이블 WHERE 조건 - delete()
//조회 : SELECT *(필드명,....)FROM 테이블명 WHERE 조건 AND(OR) 조건... ORDER BY 정렬 ASC(DESC)
//      SELECT 별칭. 필드명 FROM 테이블명 별칭 JOIN 테이블명2 별칭2 WHERE 조건 - find~()