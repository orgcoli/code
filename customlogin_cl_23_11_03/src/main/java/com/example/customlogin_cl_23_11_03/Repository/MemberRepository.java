package com.example.customlogin_cl_23_11_03.Repository;

import com.example.customlogin_cl_23_11_03.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//데이터베이스를 사용하기 위한 SQL
@Repository
public interface MemberRepository extends
        JpaRepository<MemberEntity,Integer> {
    //로그인은 이메일로 조회(MemberEntity에서 email 필드로 조회)
    MemberEntity findByEmail(String email);
}
