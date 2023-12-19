package com.example.guestboard.Controller;

import com.example.guestboard.DTO.GuestbookDTO;
import com.example.guestboard.DTO.PageRequestDTO;
import com.example.guestboard.Service.GuestBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller //컨트롤 클래스로 선언
@Log4j2     //로그처리
@RequiredArgsConstructor    //autowired 대체로 자동주입

public class GuestbookController {
    //반드시Service를 지정
    //             서비스클래스이름    컨트롤에서 사용할 이름
    private final GuestBoardService guestBoardService;

    //각 매핑별 작업을 지정정
    //@GetMapping 페이지 연결, 일반 href, 버튼으로 클릭했을 때 (조회, 삭제)
    //@PostMapping Form처리시(삽입, 수정)
    //@GetMapping("/매핑명")
    //여러개의 매핑 사용시
    //@GetMapping({"/매핑명", "/매핑명"})

    //return에 같은 파일인데 주고받는 내용이 서로 다르면
    //반드시 redirect를 이용하고 연결.

    //시작페이지 브라우저에서 http://localhost:8080/ 시 처리
   @GetMapping("/")
    public String index(){  //String을 void 선언하면 매핑이름으로 파일이 연결
        return "redirect:/guestbook/list";
    }
    //목록 페이지(서비스작업+화면이동)
    //검색분류, 검색어, 현재페이지...가져와서 해당 정보를 읽어서 화면에 목록 출력
    @GetMapping("/guestbook/list")
    //              html에서 전달받은 내용              , html에 전달할 값
    public String list(PageRequestDTO pageRequestDTO, Model model){

       //html에 실질적으로 전달할 값 "변수명" 중요!!!!!
       model.addAttribute("result", guestBoardService.getList(pageRequestDTO));
       return "guestbook/list";
    }

    //등록/수정은 폼이동 작업, 데이터베이스 처리작업

    //게시물 등록
    @GetMapping("/guestbook/register")   //화면으로 이동
    public String register(){
       return "guestbook/register";
    }
    //등록폼에서 입력한 내용을 DTO로 컨트롤에 전달해서 서비스 처리하고, 지정한 페이지로 이동.
    //DTO를 받아서 서비스처리를 gno를 컨트롤에 전달.... 등록이 아닌 목록페이지로 이동List
    //서비스 작업
    @PostMapping("/guestbook/register")
    //                          html에서 받은 값,  (등록)에 값을   (목록)에 값을 전달
    public String registerPost(GuestbookDTO dto, RedirectAttributes redirectAttributes){
        Long gno = guestBoardService.register(dto);  //게시물 번호를 결과로 받는다.

        //상태 정보를 전달
        redirectAttributes.addFlashAttribute("msg",gno);    //다른 페이지에 결과값을 전달
        return "redirect:/guestbook/list";  //등록 후 목록페이지로 이동
    }
    //값을 전달 시
    //return "주소"           Model로 선언
    //return "redirct:주소"   RedirectAttributes로 선언

    //상세페이지(상세페이지(보기만)->수정페이지로(활성화 입력가능))
    //상세페이지에 자료와 수정페이지의 자료가 동일
    @GetMapping("/guestbook/read")
    //                  데이터 조회를 위한 값                                    결과를 전달할 값
    public String read(long gno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model){
        GuestbookDTO guestbookDTO = guestBoardService.read(gno); //해당 자료를 읽어온다
        model.addAttribute("dto",guestbookDTO);  //읽어온 자료를 전달
        return "guestbook/read";
    }

    //수정페이지이동, 서비스작업
    @GetMapping("/guestbook/modify")
    public String modify(long gno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model){
        GuestbookDTO guestbookDTO = guestBoardService.read(gno); //해당 자료를 읽어온다
        model.addAttribute("dto", guestbookDTO);    //수정페이지에 값을 전달
        return "guestbook/modify";
    }

    //수정처리(수정페이지에서 수정내용을 받아서 -> 서비스에 처리 -> 목록으로 이동
    @PostMapping("/guestbook/modify")
    public String modifyPost(GuestbookDTO dto, @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
                             RedirectAttributes redirectAttributes){
        guestBoardService.modify(dto);
        //상세보기에 필요한 값 저장(변수값을 전달) flash 상태정보
        redirectAttributes.addAttribute("page",requestDTO.getPage());
        redirectAttributes.addAttribute("type",requestDTO.getType());
        redirectAttributes.addAttribute("keyword",requestDTO.getKeyword());
        redirectAttributes.addAttribute("gno",dto.getGno());
        return "redirect:/guestbook/read";   //상세보기로 이동
    }

    //삭제처리
    @PostMapping("/guestbook/remove")
    public String remove(long gno, RedirectAttributes redirectAttributes){
        guestBoardService.remove(gno);   //삭제작업
        redirectAttributes.addFlashAttribute("msg", gno);
        return "redirect:/guestbook/list";
    }
    //컨트롤에 기본 매핑 작업은 6~7개 정도로 구성
    //Get        Get        Get         Get        Post     Post(put) Get/Post(Delete)
    //목록폼 이동, 삽입폼 이동, 수정폼 이동, 상세폼 이동, 삽입 처리, 수정 처리, 삭제 처리==> 가장 기본작업
}
