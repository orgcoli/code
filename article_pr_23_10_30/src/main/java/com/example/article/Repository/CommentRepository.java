package com.example.article.Repository;
import com.example.article.Entity.ArticleEntity;
import com.example.article.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    //댓글(삽입, 삭제, 조회)
    //조회(해당하는 게시글에 댓글만 조회)
    //nativeQuery가 false(기본값)이면 SQL은 JSQL형식(Entity 이용)
    //@Query(value = "select u from Comment u where u.articleid=:articleid")
    @Query(value = "SELECT * from Comment where article_id= :article_id",
    nativeQuery = true) //nativeQuery = 정통방식의 SQl 문법을 사용할 때
    List<CommentEntity> findByArticleId(Integer article_id);
    //오류시 articleid 확인
}
//단위테스트 통해서 필요한 동작을 확인 및 기초데이터를 입력