package com.board.mboard.Service;

import com.board.mboard.DTO.NotesDTO;
import com.board.mboard.Entity.Notes_tbl;
import com.board.mboard.Repository.NotesRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotesService {

    private final NotesRepository notesRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<NotesDTO> selectAllNotes(){
        List<Notes_tbl> result =notesRepository.findAll();
        List<NotesDTO> resultDTO = Arrays.asList(modelMapper.map(result, NotesDTO[].class));
        return resultDTO;
    }

    public NotesDTO selectOneNotes(long no) throws Exception{
        Optional<Notes_tbl> notes_tbl = notesRepository.findById(no);
        return modelMapper.map(notes_tbl, NotesDTO.class);
    }

    public Notes_tbl insertNotes(NotesDTO notesDTO)throws  Exception{
        Notes_tbl notes_tbl = modelMapper.map(notesDTO, Notes_tbl.class);
        return notesRepository.save(notes_tbl);
    }

    public void updateNotes(NotesDTO notesDTO)throws  Exception{
        Long no = notesDTO.getNo();
        Optional<Notes_tbl> notes_tbl = notesRepository.findById(no);
        Notes_tbl update = notes_tbl.orElseThrow();
        update.notesChange(notesDTO.getType(), notesDTO.getTitle(), notesDTO.getContent());
        notesRepository.save(update);
    }

    public void delete(long no) throws Exception{
        notesRepository.deleteById(no);
    }
}
