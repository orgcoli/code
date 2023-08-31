package com.inssa.goods.Controller;

import com.inssa.goods.Service.GoodsService;
import com.inssa.goods.VO.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    GoodsService goodsService;  //서비스 주입

    @GetMapping("/")
    public ModelAndView start(HttpServletRequest request, HttpServletResponse response)throws Exception{
        ModelAndView mav = new ModelAndView("/index");
        return mav;
    }
    //상품목록
    @GetMapping("/goods-list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response)throws Exception{
        //메소드에 선언된 모양 그대로(GoodsService)
        List<GoodsVO> lists = goodsService.selectAll(); //데이터베이스 처리
        ModelAndView mav = new ModelAndView("/goods/list");
        mav.addObject("lists", lists); //위에 처리된 변수명을 전달
        return mav;
    }
    //상품 상세 페이지
    @GetMapping("/goods-view")
    public ModelAndView view(@RequestParam("gno") int gno, HttpServletRequest request, HttpServletResponse response)throws Exception{
        GoodsVO list = goodsService.selectByGno(gno);
        ModelAndView mav = new ModelAndView("/goods/view");
        mav.addObject("list",list);
        return mav;
    }
    //삽입
    @GetMapping("/goods-insert")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)throws Exception{
        ModelAndView mav = new ModelAndView("/goods/insert");
        return mav;
    }
    //상품처리
    @PostMapping("/goods-insert")
    public ModelAndView insertProc (@ModelAttribute("GoodsVo") GoodsVO goodsVO, HttpServletRequest request, HttpServletResponse response)throws Exception{
        goodsService.insert(goodsVO);
        ModelAndView mav = new ModelAndView("redirect:/goods-list2");
        return mav;
    }
    //상품수정
    @GetMapping("/goods-update")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response)throws Exception{
        ModelAndView mav = new ModelAndView("/goods/update");
        return mav;
    }
    //상품수정 처리
    @PostMapping("/goods-update")
    public ModelAndView updateProc(@ModelAttribute("GoodsVo") GoodsVO goodsVO, HttpServletRequest request, HttpServletResponse response)throws Exception{
        goodsService.updateByGno(goodsVO);
        ModelAndView mav = new ModelAndView("redirect:/goods-list2");
        return mav;
    }
    //상품삭제처리
    @GetMapping("/goods-delete")
    public ModelAndView deleteProc(@RequestParam("gno") int gno, HttpServletRequest request, HttpServletResponse response)throws Exception{
        goodsService.deleteByGno(gno);
        ModelAndView mav = new ModelAndView("redirect:/goods-list2");
        return mav;
    }
    //관리자 상품 목록
    @GetMapping("/goods-list2")
    public ModelAndView list2(HttpServletRequest request, HttpServletResponse response)throws Exception{
        List<GoodsVO> lists = goodsService.selectAll();
        ModelAndView mav = new ModelAndView("/goods/list2");    //다시보기
        mav.addObject("lists",lists);
        return mav;
    }

}
