package com.example.article.Repository;

import com.example.article.Entity.OpinionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpinionRepository extends JpaRepository<OpinionEntity, Integer> {
    //기본 삽입, 수정, 삭제, 조회
    //조회수추가
    @Modifying  //일부수정
    @Query("update OpinionEntity u set u.goodcnt=u.goodcnt+1 where u.id=:id")
    void goodcnt(Integer id);

    //기본 삽입, 수정, 삭제, 조회
    //조회수추가
    @Modifying  //일부수정
    @Query("update OpinionEntity u set u.badcnt=u.badcnt+1 where u.id=:id")
    void badcnt(Integer id);

    //부모테이블에 해당하는 레코드를 조회
    @Query(value = "SELECT * from opinion where discussionid=:id",
    nativeQuery = true)
    List<OpinionEntity> findByDiscussionid(@Param("id") Integer id);
}
//단위테스트 및 기초 데이터

//EL 오류 - HTML 변수 , 전달값 오류