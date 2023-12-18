package com.example.article.Repository;
import com.example.article.Entity.ArticleEntity;
import com.example.article.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {
    //게시글(삽입, 수정, 삭제, 페이지조회)
    //조회수 증가
    @Query(value = "update article set viewcnt = viewcnt+1 where id=:id",
            nativeQuery = true) //nativeQuery = 정통방식의 SQl 문법을 사용할 때
    void viewcnt(Integer id);
}
