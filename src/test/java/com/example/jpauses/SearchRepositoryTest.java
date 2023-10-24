package com.example.jpauses;

import com.example.jpauses.Entity.BoardEntity;
import com.example.jpauses.Repository.SearchRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SearchRepositoryTest {
    @Autowired
    SearchRepository searchRepository;

    @Test
    public void boardSearchTest(){
        //제목으로 조회테스트
        List<BoardEntity> list1 = searchRepository.findAllBySubjectContains("연습용");
        System.out.println(list1.toString());

        //작성자로 조회테스트
        List<BoardEntity> list2 = searchRepository.findAllByUsernameContains("용용맨");
        System.out.println(list2.toString());

        List<BoardEntity> list3 = searchRepository.findAllByUsernameContainsOrUsernameContains("연습용", "용용맨");
        System.out.println(list3.toString());
    }
}
