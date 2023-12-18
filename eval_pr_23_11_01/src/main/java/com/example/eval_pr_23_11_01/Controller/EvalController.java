package com.example.eval_pr_23_11_01.Controller;

import com.example.eval_pr_23_11_01.DTO.EvalDTO;
import com.example.eval_pr_23_11_01.Service.EvalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class EvalController {
    private final EvalService evalService;


    @GetMapping({"/","/eval-list"})
    public String getList(@PageableDefault(page=1)Pageable pageable, Model model,
                          @RequestParam(value = "type", defaultValue = "")String type,
                          @RequestParam(value = "keyword",defaultValue = "") String keyword) throws Exception{
        Page<EvalDTO> evalDTOS = evalService.list(pageable, keyword, type);

        int blockLimit = 5; //한페이지에 출력할 페이지 번호 갯수

        int startPage= (((int)(Math.ceil((double)pageable.getPageNumber()/blockLimit)))-1) *blockLimit+1;
        int endPage= Math.min(startPage+blockLimit-1, evalDTOS.getTotalPages());

        int prevPage = evalDTOS.getNumber();
        int currentPage = evalDTOS.getNumber()+1;
        int nextPage = evalDTOS.getNumber()+2;
        int lastPage = evalDTOS.getTotalPages();

        //값을 저장해서 전달
        //보낼데이터
        model.addAttribute("type",type);
        model.addAttribute("evalDTOS",evalDTOS);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("nextPage",nextPage);
        model.addAttribute("prevPage",prevPage);
        model.addAttribute("lastPage",lastPage);

        return "eval/list";
    }

    @GetMapping("/eval-detail")
    public String getDetail() throws Exception{
        return "eval/detail";
    }

    @GetMapping("/eval-insert")
    public String getInsert() throws Exception{

        return "eval/insert";
    }

    @PostMapping("/eval-insert")
    public String postInsert(EvalDTO evalDTO) throws Exception{
        evalService.insert(evalDTO);
        return "redirect:/eval-list";
    }

    @GetMapping("/eval-update")
    public String getUpdate() throws Exception{
        return "eval/update";
    }

    @PostMapping("/eval-update")
    public String postUpdate() throws Exception{
        return "redirect:/eval-list";
    }

    @GetMapping("/eval-delete")
    public String getDelete() throws Exception{
        return "redirect:/eval-list";
    }
}
