package com.example.jpauses.Controller;

import com.example.jpauses.DTO.BoardDTO;
import com.example.jpauses.Entity.BoardEntity;
import com.example.jpauses.Service.BoardService;
import com.example.jpauses.Service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final SearchService searchService;

    //Service와 동일하게 반드시 throws Exception 처리 필요
    @GetMapping("/boardlist")   //메뉴에 선언한 매핑명
    public String boardlist(Model model) throws Exception{
        //2. 작업할 서비스와 전달할 값 설정
        List<BoardDTO> lists = boardService.findAll();
        model.addAttribute("lists", lists);
        return "board/list";    //매핑 확인
    }

    //2. Entity로 전달된 목록 (페이징 처리 할때.)
    @GetMapping("/entitylist")
    public String entitylist(Model model)throws Exception{
       List<BoardEntity> lists = boardService.findAllEntity();
       model.addAttribute("lists", lists);

       return "/board/listentity";
    }

    //3. 검색페이지
    @GetMapping("/selectlist")
    public String selectlist(Model model) throws Exception{
        return "/board/search";
    }

    //4.검색결과처리 검색어를 받아서 서비스에서 처리 후 결과를 페이지에 전달
    //1)Repository에 필요한 메소드를 생성
    //2)Service에서 해당 Repository를 수행할 메소드를 생성
    //3)Controller에서 Service의 메소드를 지정
    @PostMapping("/selectlist")
    public String selectProc(String search, Model model) throws Exception{
        //1. 내림차순 정렬 조회
        //List<BoardDTO> lists = boardService.listOrder();

        //2. 검색어를 통해 제목을 조회
        //List<BoardDTO> lists = boardService.listSubjectSearch(search);

        //3. 앞에 문자열이 포함된 제목을 조회
        //List<BoardDTO> lists = boardService.listSubjectStart(search);

        //4. 뒤에 문자열이 포함된 제목을 조회
        //List<BoardDTO> lists = boardService.listSubjectEnd(search);

        //5. 문자열이 포함된 제목을 조회(실질적으로 검색작업시 사용)
        //List<BoardDTO> lists = boardService.listSubjectContain(search);

        //6. 수동으로 문자열이 포함된 제목을 조회
        //List<BoardDTO> lists = boardService.listSubjectLike(search);

        //7. 퀴리를 이용해서 문자열이 포함된 제목을 조회
        //List<BoardDTO> lists = boardService.listSubjectSql(search);

        //8. 서로 다른 변수명으로 제목을 조회
        //List<BoardDTO> lists = boardService.listSubjectSqlNo(search);

        //9. 2개 이상의 필드로 조회
        //List<BoardDTO> lists = boardService.listManyField(search);

        //10. 2개 이상의 필드로 조회, sql 사용
        //List<BoardDTO> lists = boardService.listManyFieldSql(search);

        //11. 10보다 작은 게시물 조회
        //List<BoardDTO> lists = boardService.listLessThan(10);

        //12. 조회수가 5보다 큰 게시물 조회
        //List<BoardDTO> lists = boardService.listViewGreaterThan(5);
        //model.addAttribute("lists",lists);
        return "/board/list";

    }

}
