package com.example.todo_pr_23_10_27;

import com.example.todo_pr_23_10_27.Entity.TodoEntity;
import com.example.todo_pr_23_10_27.Repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoRepositoryTest {
    @Autowired
    TodoRepository todoRepository;

    @Test
    public void insertLot()throws Exception{
        for(int i=0; i<60; i++) {
            TodoEntity todoEntity = TodoEntity.builder()
                    .ltitle("할 일" +i)
                    .lcontent("할 내용" +i)
                    .limpt(1)
                    .fterm("2023-10-20")
                    .lterm("2023-10-27")
                    .build();

            todoRepository.save(todoEntity);
        }
    }
}
