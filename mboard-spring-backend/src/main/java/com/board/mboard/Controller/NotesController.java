package com.board.mboard.Controller;

import com.board.mboard.DTO.NotesDTO;
import com.board.mboard.Service.NotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class NotesController {
    private final NotesService notesService;

    @GetMapping("/notes-list")
    public String notesList(Model model){
        List<NotesDTO> notes = notesService.selectAllNotes();
        model.addAttribute("notes", notes);
        return "notes/list";
    }

    @GetMapping("/notes-view")
    public String notesView(long no ,Model model) throws Exception{
        NotesDTO dto = notesService.selectOneNotes(no);
        model.addAttribute("dto", dto);
        return "notes/view";
    }

    @GetMapping("/notes-insert")
    public String notesInsert(){
        return "notes/insert";
    }

    @PostMapping("/notes-insert")
    public String notesInsertPost(NotesDTO notesDTO) throws Exception{
        notesService.insertNotes(notesDTO);
        return "redirect:/notes-list";
    }

    @GetMapping("/notes-update")
    public String notesUpdate(long no, Model model) throws Exception{
        NotesDTO dto = notesService.selectOneNotes(no);
        model.addAttribute("dto", dto);
        return "notes/update";
    }

    @PostMapping("/notes-update")
    public String notesUpdatePost(NotesDTO notesDTO) throws Exception{
        notesService.updateNotes(notesDTO);
        return "redirect:/notes-list";
    }

    @GetMapping("/notes-delete")
    public String delete(long no) throws Exception{
        notesService.delete(no);
        return "redirect:/notes-list";
    }

}
