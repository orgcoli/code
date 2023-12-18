package com.example.guestboard.Controller;

import com.example.guestboard.DTO.GuestboardDTO;
import com.example.guestboard.Service.GuestboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class GuestboardController {
    private final GuestboardService guestboardService;
    //시작페이지
    //방명록 목록
    @GetMapping({"/","/guestboard/list"})
    public String ListForm(@RequestParam(value = "type", defaultValue = "")String type,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "keyword", defaultValue = "") String keyword,
                           Model model) throws Exception{

        Page<GuestboardDTO> guestboardDTOS = guestboardService.list(type, page, keyword);
        //페이지 처리
        int blockLimit = 10; //한번에 출력할 페이지 번호 개수
        int startPage=(((int)(Math.ceil((double)page/blockLimit)))-1) * blockLimit+1;
        int endPage=((startPage+blockLimit-1)<guestboardDTOS.getTotalPages())? startPage+blockLimit-1: guestboardDTOS.getTotalPages();

        model.addAttribute("type",type);
        model.addAttribute("keyword",keyword);
        model.addAttribute("startpage",startPage);  //시작페이지
        model.addAttribute("endpage",endPage);      //종료페이지
        model.addAttribute("lists", guestboardDTOS);//데이터

        return "guestboard/list";
    }

    //방명록 등록폼
    @GetMapping("/guestboard/register")
    public String registerForm(Model model) throws Exception{
        return "guestboard/register";
    }

    //방명록 등록처리
    @PostMapping("/guestboard/register")
    public String registerProc(GuestboardDTO guestboardDTO, Model model) throws Exception{
        guestboardService.register(guestboardDTO);
        return "redirect:/guestboard/list";
    }

    //방명록 수정폼
    @GetMapping("/guestboard/modify")
    public String modifyForm(int gno, Model model) throws Exception{
        GuestboardDTO guestboardDTO = guestboardService.read(gno);

        model.addAttribute("list",guestboardDTO);
        return "guestboard/modify";
    }
    //방명록 수정처리
    @PostMapping("/guestboard/modify")
    public String modifyProc(GuestboardDTO guestboardDTO,Model model) throws Exception{
        guestboardService.modify(guestboardDTO);
        return "redirect:/guestboard/list";
    }
    //방명록 삭제처리
    @GetMapping("/guestboard/remove")
    public String removeProc(int gno, Model model) throws Exception{
        guestboardService.remove(gno);
        return "redirect:/guestboard/list";
    }
    //방명록 상세보기
    @GetMapping("/guestboard/read")
    public String readForm(int gno, Model model) throws Exception{
        GuestboardDTO guestboardDTO = guestboardService.read(gno);
        model.addAttribute("data",guestboardDTO);
        return "guestboard/read";
    }

}
