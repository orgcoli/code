package com.example.jpauses;

import com.example.jpauses.DTO.BoardDTO;
import com.example.jpauses.Entity.BoardEntity;
import com.example.jpauses.Service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BoardServiceTest {
    @Autowired
    BoardService boardService;

    @Test
    public void BoardListTest() throws Exception{
        List<BoardDTO> list = boardService.findAll();   //Service 테스트
        System.out.println(list.toString());
    }

    @Test
    public void BoardListEntityTest() throws Exception{
        List<BoardEntity> list = boardService.findAllEntity();

        System.out.println(list.toString());
    }
}
