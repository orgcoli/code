package com.example.crud;

import com.example.crud.DTO.BoardDTO;
import com.example.crud.Service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BoardServiceTest {
    //테스트 대상
    @Autowired
    BoardService boardService;

    @Test
    public void insertTest() throws Exception{  //삽입테스트
        BoardDTO boardDTO = BoardDTO.builder()
                .subject("서비스테스트")
                .content("서비스테스트내용")
                .grade(3)
                .username("서비스")
                .build();

        boardService.insert(boardDTO);  //in(DTO)=>out()
    }

    @Test
    public void updateTest() throws Exception{  //수정테스트
        BoardDTO boardDTO = BoardDTO.builder()
                .id(1)
                .subject("서비스테스트")
                .content("서비스테스트내용")
                .grade(3)
                .username("서비스")
                .build();

        boardService.update(boardDTO);  //in(DTO)==>out()
    }

    @Test
    public void deletetTest() throws Exception{ //삭제테스트
        int id = 10;
        boardService.delete(id);  //in(int)-->out()
    }

    @Test
    public void findAllTest() throws Exception{ //전체조회테스트
        List<BoardDTO> list = boardService.findAll(); //in()==>out(List<DTO>
        System.out.println(list.toString());
    }

    @Test
    public void findOneTest() throws Exception{ //개별조회테스트
        int id = 21;
        BoardDTO boardDTO = boardService.fineOne(id); //in(id)==>out(DTO)
        System.out.println(boardDTO);
    }
}
