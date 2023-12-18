package com.example.shopping_cl_23_11_02.Repository;

import com.example.shopping_cl_23_11_02.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
