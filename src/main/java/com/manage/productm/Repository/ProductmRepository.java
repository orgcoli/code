package com.manage.productm.Repository;

import com.manage.productm.Entity.Productm_tbl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductmRepository extends JpaRepository<Productm_tbl, Long> {
}
