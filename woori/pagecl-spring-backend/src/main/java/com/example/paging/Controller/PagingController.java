package com.example.paging.Controller;

import com.example.paging.DTO.PagingDTO;
import com.example.paging.Service.PagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//작업별 매핑처리
@Controller //클래스의 목적을 지정, 매핑용
@RequiredArgsConstructor    //자동주입
public class PagingController {
    //주입
    private final PagingService pagingService;
    //기본 GetMapping -> 처리 PostMapping, PutMapping, DeleteMapping
    @GetMapping("/paging/searchboard") //API 설계참고, html파일에서 href, action을 참고
    //@RequestParma(html에서 전달받을 변수)(value="변수명", default= "값이 없을 때 대체할 값")
    public String searchBoard(@RequestParam(value = "subject", defaultValue = "") String subject, Model model) throws Exception{
        //Service 처리
        List<PagingDTO> pagingDTOList = pagingService.search(subject);

        //결과값을 전달
        model.addAttribute("pagingDTOList",pagingDTOList);
        model.addAttribute("subject", subject);

        return "paging/searchlist";
    }

    @GetMapping("/paging/pagingboard")
    public String pagingBoard(@PageableDefault(page=1) Pageable pageable,
                              Model model) throws Exception{
        //조회할 페이지 정보를 가지고 Service에서 조회처리
        Page<PagingDTO> pagingDTOS = pagingService.paging(pageable);
        //HTML에 페이지 번호를 출력에 필요한 변수를 작업
        int blockLimit = 10;    //한페이지의 출력개수, Service에서 pageLimit과 동일하게
        //시작페이지(현재페이지번호/출력 개수 -1 * 출력개수+1)
        //0,1,2,3.....==>1,2,3.... Math(수학관련 함수).ceil(소숫점을 올림처리)
        int startPage = (((int)(Math.ceil((double)pageable.getPageNumber()/blockLimit)))-1) *blockLimit +1;
        //끝페이지(한 화면에 페이지 번호는 10개씩)
        //1~10페이지 출력 1~5페이지
        //              끝페이지        전체페이지보다 작으면
        int endPage = ((startPage+blockLimit-1)<pagingDTOS.getTotalPages()) ? startPage+blockLimit-1: pagingDTOS.getTotalPages();

        model.addAttribute("pagingDTOS", pagingDTOS);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "paging/paginglist";
    }
}
