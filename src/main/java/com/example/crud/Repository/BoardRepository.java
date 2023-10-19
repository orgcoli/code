package com.example.crud.Repository;

import com.example.crud.Entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository -> Service -> Controller 작업을 해야 화면에서 확인 가능
//Test를 통해서 확인
//JpaRepository<사용할 엔티티, id의 데이터형>
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
}
