package com.example.todo_pr_23_10_27.Repository;

import com.example.todo_pr_23_10_27.Entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    List<TodoEntity> findAllByOrderByLtermAsc();
}
