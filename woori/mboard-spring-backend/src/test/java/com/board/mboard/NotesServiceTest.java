package com.board.mboard;

import com.board.mboard.DTO.NotesDTO;
import com.board.mboard.Entity.Notes_tbl;
import com.board.mboard.Service.NotesService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class NotesServiceTest {

    @Autowired
    NotesService notesService;

    @DisplayName("서비스 추가 테스트")
    @Test
    public void notesTestInsert()throws Exception{
        NotesDTO notesDTO = NotesDTO.builder()
                .type(2)
                .title("서비스 제목")
                .content("서비스 내용")
                .build();
        Notes_tbl result = notesService.insertNotes(notesDTO);
        log.info("성공적으로 저장 처리" + result.getNo());
    }
}
