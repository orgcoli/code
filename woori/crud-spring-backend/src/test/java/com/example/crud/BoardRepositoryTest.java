package com.example.crud;

import com.example.crud.Entity.BoardEntity;
import com.example.crud.Repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

//   호출       이용  호출  이용   호출  이용
//Controller->Service->Repository->Entity
//         DTO      Entity

@SpringBootTest
public class BoardRepositoryTest {
    //테스트를 진행할 Repository 주입
    @Autowired
    BoardRepository boardRepository;

    //각 메소드가 하나의 작업을 테스트
    @Test
    public void insert(){   //게시물 등록
        //테스트 진행을 위한 준비
        //builder를 이용해서 entity에 선언된 변수에 값을 저장
        for(int i=0; i<50; i++) {
            BoardEntity boardEntity = BoardEntity.builder()
                    .subject("초기 연습용 제목"+i)
                    .content("초기 연습용 내용"+i)
                    .grade(5)
                    .username("연습맨"+i)
                    .build();

            //테스트 진행
            boardRepository.save(boardEntity);
        }
    }

    @Test
    public void delete(){   //게시물 삭제
        int id = 3; //기본 Long id = 3L
        boardRepository.deleteById(id);
        //boardRepository.deleteAll(); 모두삭제
    }

    @Test
    public void update(){   //게시물 수정
        int id =1;

        Optional<BoardEntity> data = boardRepository.findById(id);  //개별조회(대상)
        BoardEntity test = data.orElseThrow();  //조회성공시 저장
        test.setSubject("수정제목");

        boardRepository.save(test); //테스트
    }

    @Test
    public void list(){     //게시물 목록
        List<BoardEntity> list = boardRepository.findAll(); //모두 조회 테스트

        for(BoardEntity data:list){
            System.out.println(data.toString());
        }
    }

    @Test
    public void detail(){   //게시물 상세
        int id = 2;
        Optional<BoardEntity> data = boardRepository.findById(id);
        System.out.println(data.toString());
    }
}
