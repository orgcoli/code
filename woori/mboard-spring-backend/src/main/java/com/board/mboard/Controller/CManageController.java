package com.board.mboard.Controller;

import com.board.mboard.DTO.CManageDTO;
import com.board.mboard.Service.CManageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class CManageController {
    private final CManageService cManageService;

    @GetMapping("/")
    public String main(){
        return "index";
    }

    @GetMapping("/cmanage-list")
    public String list(Model model){
        List<CManageDTO> lists = cManageService.selectAll();
        model.addAttribute("lists", lists);
        return "cmanage/list";
    }

    @GetMapping("/cmanage-view")
    public String view(String cid, Model model) throws Exception{
        CManageDTO data = cManageService.SelectOne(cid);
        model.addAttribute("data", data);
        return "cmanage/view";
    }

    @GetMapping("/cmanage-insert")
    public String insert(){
        return "cmanage/insert";
    }

    @PostMapping("cmanage-insert")
    public String insertPost(CManageDTO cManageDTO)throws Exception{
        cManageService.insert(cManageDTO);
        return "redirect:/";
    }

    @GetMapping("/cmanage-update")
    public String update(String cid, Model model) throws Exception{
        CManageDTO data = cManageService.SelectOne(cid);
        model.addAttribute("data", data);
        return "cmanage/update";
    }

    @PostMapping("/cmanage-update")
    public String updatePost(CManageDTO cManageDTO) throws Exception{
        cManageService.update(cManageDTO);
        return "redirect:/cmanage-list";
    }

    @GetMapping("/cmanage-delete")
    public String delete(String cid) throws Exception{
        cManageService.delete(cid);
        return "redirect:/cmanage-list";
    }
}
