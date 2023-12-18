package com.example.bookpr_231020.Repository;

import com.example.bookpr_231020.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
