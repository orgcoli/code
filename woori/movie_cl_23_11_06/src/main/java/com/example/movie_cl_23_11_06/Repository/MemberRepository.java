package com.example.movie_cl_23_11_06.Repository;

import com.example.movie_cl_23_11_06.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
    MemberEntity findByEmail(String email);
}
