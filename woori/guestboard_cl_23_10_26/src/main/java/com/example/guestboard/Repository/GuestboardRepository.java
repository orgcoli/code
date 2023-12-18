package com.example.guestboard.Repository;

import com.example.guestboard.Entity.GuestboardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestboardRepository extends JpaRepository<GuestboardEntity, Integer> {
    //검색이 없는 페이지처리 FindAll 사용
    //제목으로 검색시 페이지 처리
    @Query("SELECT u FROM GuestboardEntity u where u.title like %:keyword%")
    Page<GuestboardEntity> searchTitle(String keyword, Pageable pageable);

    //내용으로 검색시 페이지 처리
    @Query("SELECT u FROM GuestboardEntity u where u.content like %:keyword%")
    Page<GuestboardEntity> searchContent(String keyword, Pageable pageable);

    //작성자로 검색시 페이지처리
    @Query("SELECT u FROM GuestboardEntity u where u.writer like %:keyword%")
    Page<GuestboardEntity> searchWriter(String keyword, Pageable pageable);

    //제목+내용으로 검색시 페이지처리
    @Query("SELECT u FROM GuestboardEntity u where u.title like %:keyword% or u.content like %:keyword%")
    Page<GuestboardEntity> searchTitleContent(String keyword , Pageable pageable);

    //제목+내용+작성자로 검색시 페이지처리
    @Query("SELECT u FROM GuestboardEntity u where u.title like %:keyword% or u.content like %:keyword% or u.writer like %:keyword%")
    Page<GuestboardEntity> searchTitleContentWriter(String keyword, Pageable pageable);
}
//테스트를 통해서 더미데이터 입력 ->생성한 메소드를 동작처리
