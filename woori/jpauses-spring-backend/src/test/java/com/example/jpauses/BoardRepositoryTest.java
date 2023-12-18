package com.example.jpauses;

import com.example.jpauses.Entity.BoardEntity;
import com.example.jpauses.Repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    //삽입,수정,삭제,조회를 테스트를 진행(삽입, 조회)
    @Test
    public void insertTest(){
        //삽입시 Entity가 필요
        for(int i=1;i<50; i++) {
            BoardEntity boardEntity = BoardEntity.builder()
                    .subject("연습용 테스트" +i)
                    .content("연습용 내용" +i)
                    .username("용용이" +i)
                    .viewcnt(i)
                    .build();
            boardRepository.save(boardEntity);
        }
        //삽입시 Entity가 필요
        for(int i=1;i<50; i++) {
            BoardEntity boardEntity = BoardEntity.builder()
                    .subject("실습용 테스트" +i)
                    .content("실습용 내용" +i)
                    .username("실용이" +i)
                    .viewcnt(i)
                    .build();
            boardRepository.save(boardEntity);
        }
    }

    @Test
    public void listTest(){
        List<BoardEntity> list = boardRepository.findAll();

        System.out.println(list.toString() );
    }

    @Test
    public void boardSearchTest(){
        //제목으로 조회테스트
        List<BoardEntity> list1 = boardRepository.findAllBySubjectContains("연습용");
        System.out.println(list1.toString());

        //작성자로 조회테스트
        List<BoardEntity> list2 = boardRepository.findAllByUsernameContains("용용맨");
        System.out.println(list2.toString());

        List<BoardEntity> list3 = boardRepository.findAllByUsernameContainsOrUsernameContains("연습용", "용용맨");
        System.out.println(list3.toString());
    }
}
//테스트 완료 후 Service에서 Controller로 부터받아서