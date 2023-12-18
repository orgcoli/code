package com.example.jpauses.Repository;

import com.example.jpauses.DTO.BoardDTO;
import com.example.jpauses.Entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//JpaRepository <사용할 Entity, id의 데이터형
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    //기본 save, delete, findAll, findById, count는 제공
    //1. 목록 정렬처리(기본키를 이용해서 정렬)
    //오름차순(ASC), 내림차순(DESC)
    //findBy ~1개의 결과물 조회, findAllBy~ 조건에 맞는 모든 결과물을 조회
    //Select * From Board Order By Id desc
    //List<BoardEntity> findAllByOrderByIdDesc();    //모든 결과물을 id로 내림차순

    //2. 제목을 검색해서 조회
    //검색할 값을 subject로 받아서 subject 필드에서 동일한 값을 조회
    //Select * from board where subject= :subject
    //List<BoardEntity> findAllBySubject(String subject);

    //3. 앞에 문자열이 포함되어 있는 제목을 조회
    //StartsWith는 앞에 문자열이 포함되어 있는 경우 ==> 문자열%
    //Select * from board where subject= :subject%
    //List<BoardEntity> findAllBySubjectStartsWith(String subject);

    //4. 뒤에 문자열이 포함되어 있는 제목을 조회
    //EndsWith는 뒤에 문자열이 포함되어 있는 경우 ==> %문자열
    //Select * from board where subject= %:subject
    //List<BoardEntity> findAllBySubjectEndsWith(String subject);

    //5. 문자열이 포함된 제목을 조회
    //Contains 문자열이 포함되어 있는 경우 ==>%문자열%
    //Select * from board where subject= %:subject%
    //List<BoardEntity> findAllBySubjectContains(String subject);

    //6. 문자열의 위치를 수동으로 지정해서 제목을 조회
    //Like 는 %을 추가해서 문자열의 위치를 지정 --> %문자열%, %문자열, 문자열%
    //Select * from board where subject= %:subject%
    //List<BoardEntity> findAllBySubjectLike(String subject);

    //7. 질의어를 임의로 작성해서 제목을 조회
    //Query("Select 별칭명 From 테이블명 별칭명 where 별칭명.필드명=....
    // u (boardEntity의 모든 필드) from boardEntity u (앞으로 boardEntity를 u로 호칭)
    //u.subject(boardentity의 subject 필드) : subject(받은 변수명)
    //@Query("SELECT u FROM BoardEntity u WHERE u.subject like :subject")
    //List<BoardEntity> findAllBySubjectSql(String subject);

    //8. 필드명과 전달받은 변수명이 다른 경우
    //@Param("subject") String name을 subject 변수로 사용용
    //@Query("SELECT u FROM BoardEntity u WHERE u.subject like :subject")
    //List<BoardEntity> findAllBySubjectSqlNo(@Param("subject") String name);

    //9. 2개의 필드를 이용해서 조회(제목과 작성자)
    //List<BoardEntity> findAllBySubjectContainsOrUsernameContains(String subject, String username);

    //10. 2개의 필드를 이용해서 조회(제목과 작성자) sql
    //@Query("Select u FROM BoardEntity u where u.subject like :subject or u.username like :username")
    //List<BoardEntity> findAllByField(String subject, String username);

    //11. 번호 10보다 작은 자료만 조회 이하(LessThanEqual) 미만(lessThan)
    //List<BoardEntity> findAllByIdLessThan(int id);

    //11. 조회수가 5보다 큰 자료만 조회 이상(GreaterThanEqual) 초과(GreaterThan) orderby는 오름차, 내림차순
    //List<BoardEntity> findAllByViewcntGreaterThanOrderByViewcntDesc(int id);

    //12. 검색 처리(제목, 작성자, 제목+작성자)
    List<BoardEntity> findAllBySubjectContains(String subject); //제목만 조회
    List<BoardEntity> findAllByUsernameContains(String username);
    //@Query("Select u FROM BoardEntity u where u.subject like %:subject% or u.username like %:subject%")
    //List<boardEntity findSearch(String subject);
    List<BoardEntity> findAllByUsernameContainsOrUsernameContains(String subject, String username);

}
//선언 후 테스트를 진행해서 기본 데이터를 작성
//find(조회)All(모든내용)bySubject(제목에서)EndsWith