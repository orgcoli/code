package com.example.crud.Repository;

import com.example.crud.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends
        JpaRepository<MemberEntity, Integer> {
    //사용할 Entity와 id의 데이터형만 정확히 기재
}
