package com.blue.blboard.Controller;

import com.blue.blboard.Service.BoardService;
import com.blue.blboard.VO.BoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class BoardController {
    private Logger logger = LoggerFactory.getLogger(BoardController.class);
    @Autowired
    BoardService boardService;

    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("인덱스 처리");
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
    @GetMapping("/blboard-searchform")
    public ModelAndView searchform(HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("검색 페이지 처리");
        ModelAndView mav = new ModelAndView("blboard/searchform");
        return mav;
    }

    //목록
    @GetMapping("/blboard-list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("목록 처리");
        List<BoardVO> lists = boardService.boardAllList();
        ModelAndView mav = new ModelAndView("/blboard/list");
        mav.addObject("lists", lists);
        return mav;
    }
    //삽입페이지 이동
    @GetMapping("blboard-insert")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("삽입페이지 처리");
        ModelAndView mav = new ModelAndView("/blboard/insert");
        return mav;
    }
    //삽입페이지 처리
    @PostMapping("/blboard-insert")
    public ModelAndView insertProc(@ModelAttribute("BoardVO")BoardVO boardVO, HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("삽입 처리");
        boardService.boardInsert(boardVO);
        ModelAndView mav = new ModelAndView("redirect:/blboard-list");
        return mav;
    }
    //수정화면 처리
    @GetMapping("/blboard-update")
    public ModelAndView update(@RequestParam("bno") int bno, HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("수정화면 처리");
        BoardVO data = boardService.boardOneList(bno);
        ModelAndView mav = new ModelAndView("/blboard/update");
        mav.addObject("data", data);
        return mav;
    }
    //수정 처리
    @PostMapping("/blboard-update")
    public ModelAndView updateProc(@ModelAttribute("BoardVO") BoardVO boardVO, HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("수정 처리");
        boardService.boardUpdate(boardVO);
        ModelAndView mav = new ModelAndView("redirect:/blboard-list");
        return mav;
    }
    //삭제 처리
    @GetMapping("/blboard-delete")
    public ModelAndView delete(@RequestParam("bno") int bno, HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("삭제 처리");
        boardService.boardDelete(bno);
        ModelAndView mav = new ModelAndView("redirect:/blboard-list");
        return mav;
    }
    //상품 상세 페이지
    @GetMapping("/blboard-view")
    public ModelAndView view(@RequestParam("bno") int bno, HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("뷰 처리");
        BoardVO data = boardService.boardOneList(bno);
        ModelAndView mav = new ModelAndView("/blboard/view");
        mav.addObject("data",data);
        return mav;
    }
    @GetMapping("/blboard-search")
    public ModelAndView search(@RequestParam("bname") String bname, HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("검색 처리");
        List<BoardVO> lists = boardService.boardByName(bname);
        ModelAndView mav = new ModelAndView("/blboard/search");
        mav.addObject("lists", lists);
        return mav;
    }

}
