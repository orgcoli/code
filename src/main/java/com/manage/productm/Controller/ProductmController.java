package com.manage.productm.Controller;

import com.manage.productm.DTO.ProductmDTO;
import com.manage.productm.Service.ProductmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//컨트롤러는 View와 연결(Mapping)
//서비스로 이용
@Controller
@Log4j2
@RequiredArgsConstructor
public class ProductmController {
    private final ProductmService productmService;
    //매핑, 메소드+입력
    //return 사용메소드에 설계한 파일로 연결
    //출력값이 있는 경우 Model선언
    //입력값이 있는 경우 DTO선언
    //서비스를 이용해서 해당 메소드 이용, addAttribute로 값을 저장
    @GetMapping("/")
    public String main(){
        return "index";
    }

    @GetMapping("/productm-list")
    public String list(Model model) {
        List<ProductmDTO> lists = productmService.selectAll();
        model.addAttribute("lists", lists);
        return "productm/list";
    }

    @GetMapping("/productm-view")
    public String view(long pno, Model model) throws Exception{
        ProductmDTO data = productmService.selectOne(pno);
        model.addAttribute("data",data);
        return "productm/view";
    }

    @GetMapping("/productm-insert")
    public String insert(){
        return "productm/insert";
    }

    @PostMapping("/productm-insert")
    public String insertPost(ProductmDTO productmDTO)throws Exception{
        productmService.insert(productmDTO);
        return "redirect:/productm-list";
    }

    @GetMapping("/productm-update")
    public String update(long pno, Model model) throws Exception{
        ProductmDTO data = productmService.selectOne(pno);
        model.addAttribute("data", data);
        return "productm/update";
    }

    @PostMapping("/productm-update")
    public String updatePost(ProductmDTO productmDTO) throws Exception{
        productmService.update(productmDTO);
        return "redirect:/productm-list";
    }
    @GetMapping("/productm-delete")
    public String delete(long pno) throws Exception{
        productmService.delete(pno);
        return "redirect:/productm-list";
    }
}
