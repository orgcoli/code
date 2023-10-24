package com.example.jpauses.Controller;

import com.example.jpauses.DTO.BoardDTO;
import com.example.jpauses.Service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;


    //Service, Repository, Entity, DTO는 클래스명은 중복불가능
    //내용은 중복가능
    //Controller는 Mapping은 중복불가능, 메소드는 중복 가능
    //검색+게시판 구현
    @GetMapping("/searchlist")  //중복 불가능
    public String searchListForm(Model model) throws Exception{ //get방식 처음목록, 검색..등 모든 기능을 통합
        //목록 조회 후 결과를 출력
        List<BoardDTO> lists = searchService.subjectSearch("","");
        model.addAttribute("lists", lists);
        return "/board/searchlist";
    }

    @PostMapping("/searchlist")
    public String searchListProc(String search, String gubun, Model model) throws Exception{
        List<BoardDTO> lists = searchService.subjectSearch(gubun, search);
        model.addAttribute("lists",lists);
        //검색을 통해서 결과를 출력
        return "board/searchlist";
    }
}
