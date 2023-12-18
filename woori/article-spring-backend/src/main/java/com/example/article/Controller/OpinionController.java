package com.example.article.Controller;

import com.example.article.DTO.OpinionDTO;
import com.example.article.Service.OpinionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class OpinionController {
    private final OpinionService opinionService;


    @PostMapping("/opinion/register")
    public String registerProc(int no, OpinionDTO opinionDTO,
                               RedirectAttributes redirectAttributes) throws Exception{

        opinionService.register(no, opinionDTO);    //의견 저장

        redirectAttributes.addAttribute("id",no);
        return "redirect:/discussion/read"; //전달하는 id가 없어서 오류가 발생 redirectAttribute 있어서 오류 발생 X
    }
    @GetMapping("/opinion/goodcnt") //좋아요
    public String goodcntProc(int id,int no,RedirectAttributes redirectAttributes) throws Exception{

        opinionService.goodcnt(id);

        redirectAttributes.addAttribute("id",no);
        return "redirect:/discussion/read";
    }
    @GetMapping("/opinion/badcnt") //싫어요
    public String badcntProc(int id,int no, RedirectAttributes redirectAttributes) throws Exception{

        opinionService.badcnt(id);

        redirectAttributes.addAttribute("id",no);
        return "redirect:/discussion/read";
    }
    @GetMapping("/opinion/remove") //삭제
    public String removeProc(int no, int id, RedirectAttributes redirectAttributes) throws Exception{
        opinionService.remove(id);
        redirectAttributes.addAttribute("id",no);
        return "redirect:/discussion/read";
    }
}
