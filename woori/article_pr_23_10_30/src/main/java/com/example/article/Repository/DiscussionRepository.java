package com.example.article.Repository;

import com.example.article.Entity.DiscussionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DiscussionRepository
        extends JpaRepository<DiscussionEntity, Integer> {
    //기본 삽입, 수정, 삭제, 조회
    //조회수추가
    @Modifying  //일부수정
    @Query("update DiscussionEntity u set u.viewcnt=u.viewcnt+1 where u.id= :id")
    void viewcnt(Integer id);

    Page<DiscussionEntity> findAllByOrderByViewcntDesc(Pageable pageable);

    Page<DiscussionEntity> findAllByOrderBySubjectAsc(Pageable pageable);
}
