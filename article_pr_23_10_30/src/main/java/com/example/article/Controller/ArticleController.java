package com.example.article.Controller;
import com.example.article.DTO.ArticleDTO;
import com.example.article.DTO.CommentDTO;
import com.example.article.Service.ArticleService;
import com.example.article.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final CommentService commentService;
    //private final ModelMapper modelMapper = new ModelMapper();  //상황에 따라

    @GetMapping("/article/register")
    public String registerForm(Model model) throws Exception{
        ArticleDTO articleDTO = new ArticleDTO();
        model.addAttribute("articleDTO", articleDTO);
        return "/article/register";
    }
    @PostMapping("/article/register")
    public String registerProc(@Valid ArticleDTO articleDTO, BindingResult bindingResult, Model model) throws Exception{
        //검증처리시 DTO와 변수명은 동일하게 맞추어 준다.
        if (bindingResult.hasErrors()){
            return "/article/register";
        }
        articleService.insert(articleDTO);
        return "redirect:/article/list";
    }

    @GetMapping("/article/modify")
    public String modifyForm(int id, Model model) throws Exception{
        ArticleDTO articleDTO = articleService.read(id);

        model.addAttribute("articleDTO",articleDTO);
        return "article/modify";
    }
    @PostMapping("/article/modify")
    public String modifyProc(@Valid ArticleDTO articleDTO, BindingResult bindingResult, Model model) throws Exception{
        if (bindingResult.hasErrors()){
            return "article/modify";
        }
        articleService.update(articleDTO);
        return "redirect:/article/list";
    }

    @GetMapping("article/remove")
    public String removeProc(int id, Model model) throws Exception{

        articleService.remove(id);

        return "redirect:/article/list";
    }


    //페이지처리 목록조회
    @GetMapping("/article/list")
    public String 조회(@PageableDefault(page = 1) Pageable pageable, Model model) throws Exception{
        Page<ArticleDTO> articleDTOS = articleService.list(pageable);

        //페이지정보
        int blockLimit = 10;
        //시작페이지
        int startPage = (((int)(Math.ceil((double)pageable.getPageNumber()/blockLimit)))-1) * blockLimit+1;
        int endPage = Math.min(startPage+blockLimit-1, articleDTOS.getTotalPages());

        //페이지 버튼 정보(HTML에서 작성도 가능 [첫, 이전, 페이지번호, 다음, 끝]
        int prevPage = articleDTOS.getNumber(); //이전페이지
        int currentPage = articleDTOS.getNumber()+1;//현재페이지
        int nextPage = articleDTOS.getNumber()+2; //다음페이지
        int lastPage = articleDTOS.getTotalPages();

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("prevPage", prevPage);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("nextPage", nextPage);
        model.addAttribute("lastPage", lastPage);

        model.addAttribute("articleDTOS",articleDTOS);
        return "article/list";
    }

    @GetMapping("/article/read")
    public String read(int id, Model model)throws Exception{
        //해당게시글 조회
        ArticleDTO articleDTO = articleService.read(id);
        //댓글 조회
        List<CommentDTO> commentDTOS = commentService.list(id);
        //해당 게시글에 여러개의 댓글이 있을 수 있으므로 List로 받음

        model.addAttribute("articleDTO",articleDTO);    //게시글
        model.addAttribute("commentDTOS",commentDTOS);  //해당 댓글
        return "/article/read";
    }
}
