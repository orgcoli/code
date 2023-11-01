package com.example.eval_pr_23_11_01.Repository;

import com.example.eval_pr_23_11_01.Entity.EvalEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EvalRepository extends JpaRepository<EvalEntity, Integer> {

    @Modifying
    @Query("update EvalEntity u set u.lcount=u.lcount where u.id= :id")
    void lcount(Integer id);

    @Query("select u from EvalEntity u where u.pname like %:keyword%")
    Page<EvalEntity> searchPname(String keyword, Pageable pageable);

    @Query("select u from EvalEntity u where u.lname like %:keyword%")
    Page<EvalEntity> searchLname(String keyword, Pageable pageable);

    @Query("select u from EvalEntity u where u.etitle like %:keyword%")
    Page<EvalEntity> searchEtitle(String keyword, Pageable pageable);

    @Query("select u from EvalEntity u where u.pname like %:keyword% or u.lname like %:keyword%")
    Page<EvalEntity> searchPnameLname(String keyword, Pageable pageable);

    @Query("select u from EvalEntity u where u.pname like %:keyword% or u.lname like %:keyword% or u.etitle like %:keyword%")
    Page<EvalEntity> searchPnameLnameEtitle(String keyword, Pageable pageable);
}
