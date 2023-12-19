package com.kakao.munjebank.Controller;

import com.kakao.munjebank.Service.MunjeService;
import com.kakao.munjebank.VO.MunjeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller //view와 연동, Service 이용
public class MunjeController {
    //콘솔에 로그를 이용해서 정보를 출력
    //생략 가능, getLogger(작업클래스명)
    private Logger logger = LoggerFactory.getLogger(MunjeController.class);

    @Autowired
    MunjeService munjeService;

    //View와 연결할 매핑
    //@GetMapping     //페이지 이동, 입력/수정폼 (조회, 삭제)
    //@PostMapping    //데이터베이스 처리(저장, 수정, 삭제)
    //@PutMapping     //데이터베이스 수정
    //@DeleteMapping  //데이터베이스 삭제

    @GetMapping("/")    //시작페이지, 메소드명은 사용자 마음대로
    public ModelAndView index() throws Exception{
        ModelAndView mav = new  ModelAndView("index");
        return mav;
    }
    @GetMapping("/munje-select")    //응시과목 페이지 이동
    public ModelAndView select() throws Exception{
        ModelAndView mav = new  ModelAndView("/munje/munje-select");
        return mav;
    }

    @PostMapping("/munje")      //데이터베이스에서 응시과목의 문제를 읽어 출력하는 페이지 이동
    public ModelAndView munje(@RequestParam("subject")String subject) throws Exception{
        //해당과목의 모든문제를 읽어온다
        List<MunjeVO> lists = munjeService.findSelectBySubject(subject);
        //System.out.println(lists.size());
        ModelAndView mav = new  ModelAndView("/munje/munje");
        mav.addObject("lists", lists);  //문제자료를 munje.html에 전달
        mav.addObject("subject",subject);   //선택한 과목
        return mav;
    }

    @PostMapping("/munje-result")   //답안을 데이터베이스 정답과 비교해서 결과 페이지 이동
    public ModelAndView result(@RequestParam("subject") String subject,
                               @RequestParam("dap") String[] dap) throws Exception{  //과목, 정답(배열로 받아야함)
        //해당과목의 데이터베이스를 읽기
        List<MunjeVO> lists = munjeService.findSelectBySubject(subject); //해당과목의 정보를 읽어온다

        int jumsu = 0;  //점수
        int cnt=0; //현재 배열의 위치
        String message;

        /*for(String jungdap:dap){    //시험폼에서 읽어온 답안
            System.out.println(jungdap);
        }*/
        for(MunjeVO data:lists){    //해당과목에 데이터베이스에서 읽어온 답
            if(data.getAnswer().equals(dap[cnt])){  //데이터베이스의 정답과 입력한 답안이 같으면
                jumsu += 10;
           }
            cnt++; //다음 답안으로 이동
        }
        if(jumsu>=60){
            message = "합격을 축하합니다";
        } else{
            message = "불합격입니다";
        }
        //맞은개수/전체수*100

        ModelAndView mav = new  ModelAndView("/munje/result");
        mav.addObject("jumsu", jumsu);
        mav.addObject("message", message);
        return mav;
    }

    @GetMapping("/munje-insert")    //문제 등록 페이지로 이동
    public ModelAndView insert() throws Exception{
        ModelAndView mav = new  ModelAndView("/munje/munje-insert");
        return mav;
    }

    @PostMapping("/munje-insert")   //입력한 문제를 데이터베이스에 저장 후 시작페이지로 이동
    public ModelAndView postInsert(@ModelAttribute("MunjeVO")MunjeVO munjeVO) throws Exception{
        //form에 입력한 내용을 데이터베이스에 저장
        //위에 동일한 위치로 가는 매핑이 있는 경우에는 파일이 아닌 매핑을 지정 redirect
        munjeService.save(munjeVO);
        ModelAndView mav = new  ModelAndView("redirect:/");
        return mav;
    }

    @GetMapping("/munje-update")    //수정할 문제를 읽어서 수정페이지로 이동
    public ModelAndView update(@RequestParam("no") int no) throws Exception{
        //수정페이지에 값을 전달
        MunjeVO data = munjeService.findSelectByNo(no);
        ModelAndView mav = new  ModelAndView("/munje/munje-update");
        mav.addObject("data",data);
        return mav;
    }

    @PostMapping("/munje-update")   //수정된 문제를 데이터베이스에 저장 후 시작페이지로 이동
    public ModelAndView postUpdate(@ModelAttribute("munjeVO") MunjeVO munjeVO) throws Exception{
        //전달받은 값을 데이터베이스에 수정처리
        munjeService.update(munjeVO);
        ModelAndView mav = new  ModelAndView("redirect:/munje-list");
        return mav;
    }

    @GetMapping("/munje-delete")    //지정한 문제를 삭제처리 후 시작페이지로 이동동
   public ModelAndView delete(@RequestParam("no") int no) throws Exception{
        munjeService.deleteByNo(no);
        ModelAndView mav = new  ModelAndView("redirect:/");
        return mav;
    }

    @GetMapping("/munje-list")      //관리자메뉴에서 전체 문제 목록 페이지로 이동(수정, 삭제)
    public ModelAndView list() throws Exception{
        //목록에 필요한 자료를 데이터베이스 부터 읽어온다.
        List<MunjeVO> lists = munjeService.findSelectAll();
        ModelAndView mav = new  ModelAndView("/munje/list");
        mav.addObject("lists", lists);
        return mav;
    }
}
