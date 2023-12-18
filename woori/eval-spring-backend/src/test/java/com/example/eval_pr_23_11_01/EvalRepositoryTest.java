package com.example.eval_pr_23_11_01;

import com.example.eval_pr_23_11_01.Entity.EvalEntity;
import com.example.eval_pr_23_11_01.Repository.EvalRepository;
import com.example.eval_pr_23_11_01.Service.EvalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EvalRepositoryTest {
    @Autowired
    EvalRepository evalRepository;

    @Test
    public void insert() throws Exception{
        for (int i=1; i<=30; i++) {
            EvalEntity evalEntity = EvalEntity.builder()
                    .userid("test"+i)
                    .lname("강의"+i)
                    .pname("홍길동" +i)
                    .lyear(2023)
                    .sdivide("1학기")
                    .ldivide("전공")
                    .etitle("제목" +i)
                    .econtent("내용" +i)
                    .tscore("A")
                    .gscore("A")
                    .cscore("B")
                    .lscore("A")
                    .build();
            evalRepository.save(evalEntity);
        }
    }


}
