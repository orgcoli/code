package com.board.mboard;

import com.board.mboard.Entity.Notes_tbl;
import com.board.mboard.Repository.NotesRepository;
import groovy.util.logging.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class NotesRepositoryTest {
    @Autowired
    private NotesRepository notesRepository;

    @Test
    public void NoteTestInsertLot() throws Exception{
        IntStream.rangeClosed(1,10).forEach(i->{
            Notes_tbl result = Notes_tbl.builder()
                    .type(1)
                    .title("제목"+i)
                    .content("내용"+i)
                    .build();
            notesRepository.save(result);
        });
    }
}
