package com.example.article.Controller;

import com.example.article.DTO.CommentDTO;
import com.example.article.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comment/register")
    public String registerProc(int no, CommentDTO commentDTO, RedirectAttributes redirectAttributes) throws Exception{

        commentService.insert(no, commentDTO);

        //상세페이지로 이동
        //read(조회할 게시글 번호)
        //페이지로 이동시 값을 전달 model.addAttribute
        //리다이렉트(매핑)로 이동시 값을 전달 RedirectAttribute

        redirectAttributes.addAttribute("id",no);
        return "redirect:/article/read";
    }

    @GetMapping("/comment/remove")
    public String removeProc(int no, int id, RedirectAttributes redirectAttributes) throws Exception{
        commentService.remove(id);

        redirectAttributes.addAttribute("id",no);
        return "redirect:/article/read";
    }
}
