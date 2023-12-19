package com.example.crud.Controller;

import com.example.crud.DTO.BoardDTO;
import com.example.crud.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor    //자동주입 ==>@Autowired
public class BoardController {
    //Service 주입
    private final BoardService boardService;

    //메소드를 완성하고 서버 실행해서 주소창에 get방식에 대한 연결확인인
    //PostMan 프로그램을 사용하면 get, post 연동 테스트 가능
   @GetMapping("/boardlist")
    public String listForm(Model model) throws Exception{
       List<BoardDTO> lists =  boardService.findAll();

       model.addAttribute("lists",lists);   //html에 전달
        return "board/list";    //해당페이지로 이동, 전닿받은 값을 처리하도록 수정
    }

    @GetMapping("/boardinsert")
    public String insertForm(Model model) throws Exception{
        //검증을 위해서 빈 DTO
        model.addAttribute("boardDTO",new BoardDTO());
        return "board/insert";
    }

    @PostMapping("/boardinsert")
    public String insertProc(@Valid BoardDTO boardDTO,
                             BindingResult bindingResult, Model model) throws Exception{
        //검증결과에 확인해서 페이지이동
        if(bindingResult.hasErrors()){
            return "board/insert";  //오류시 입력페이지로 이동
        }
        boardService.insert(boardDTO);  //저장작업
        return "redirect:/boardlist";   //다른 맵핑으로 이동
    }
    //검증처리로 작업시 insert.html 복사해서 update(검증없음).html 수정
    //검증처리가 필요없으면 update(검증없음).html object 필요없음
    @GetMapping("/boardupdate")
    public String updateForm(int id, Model model) throws Exception{
       //int id = >수정할 대상
       BoardDTO boardDTO = boardService.fineOne(id);    //개별조회

       model.addAttribute("boardDTO", boardDTO);    //전달

        return "board/update";
    }

    @PostMapping("/boardupdate")    //삽입과 동일한 작업
    public String updateProc(@Valid BoardDTO boardDTO,BindingResult bindingResult, Model model) throws Exception{
       if(bindingResult.hasErrors()){
           return "board/update";   //오류발생시 수정페이지 이동
       }

       boardService.update(boardDTO);   //수정작업

        return "redirect:/boardlist";
    }

    @GetMapping("/boarddelete")
    public String deleteProc(int id, Model model) throws Exception{
        //int id ==> 삭제할 대상
        //if(id > 0) 조건식 가능
        boardService.delete(id);
        return "redirect:/boardlist";
    }

    @GetMapping("/boarddetail")
    public String detailForm(int id ,Model model) throws Exception{
        //int id ==> 조회할 대상
        BoardDTO boardDTO = boardService.fineOne(id);

        model.addAttribute("boardDTO",boardDTO);

        return "board/detail";
    }


}
