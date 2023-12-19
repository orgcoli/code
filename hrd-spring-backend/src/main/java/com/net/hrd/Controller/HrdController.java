package com.net.hrd.Controller;

import com.net.hrd.Service.HrdService;
import com.net.hrd.VO.HrdVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HrdController {

    @Autowired
    HrdService hrdService;

    @GetMapping("/")
    public String index(Model model) throws Exception{
        List<HrdVO> lists = hrdService.SelectAll(); //불러오기
        model.addAttribute("lists", lists); //저장
        return "/list";
    }

    @GetMapping("/insert")
    public String insert(Model model) throws Exception{
        return "/insert";
    }

    @PostMapping("/insert")
    public String insertProc(@ModelAttribute("HrdVO")HrdVO hrdVO, Model model) throws Exception{
        hrdService.insert(hrdVO);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) throws Exception{
        HrdVO data = hrdService.SelectById(id);
        model.addAttribute("data", data);
        return "/update";
    }

    @PostMapping("/update")
    public String updateProc(@ModelAttribute("HrdVO") HrdVO hrdVO, Model model) throws Exception{
        hrdService.update(hrdVO);   //수정하기
        return "redirect:/";        //이동
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id")int id, Model model) throws Exception{
        hrdService.deleteById(id);  //삭제하기
        return "redirect:/";        //이동
    }

    //1. ModelAndView 메소드(@RequestParam() 전달받은값, HttpServletRequest request, HttpServletResponse response)
    //2. ModelAndView 메소드(@RequestParam() 전달받은값)
    //3. String 메소드(전달받은값)
}
