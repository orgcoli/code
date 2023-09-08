package com.example.thyme.Controller;

import com.example.thyme.DTO.ItemDTO;
import com.example.thyme.DTO.SungjukDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;   //Controller 어노테이션
import org.springframework.ui.Model;    //Model 처리
import org.springframework.web.bind.annotation.*;   //어노테이션 처리

@Controller //servlet을 통해서 매핑처리하여 동작
public class basic {
    @GetMapping("/text-basic")   //브라우저에서 주소로 접속할 때
    //메소드명은 매핑이나 작업방식을 활용해서 이름을 지정한다.
    //${data} = String data 가져올때
    public String textbasic(Model model) {
        //html에 ${변수명}에 해당하는 값을 전달
        //"data" = ${data} 보낼때
        model.addAttribute("data", "hello world!");

        //templates/text-basic.html
        //spring.thymeleaf.prefix=classpath:/templates/ = templates/
        //spring.thymeleaf.suffix=.html = .html
        return "text-basic";  //html 파일명
    }

    //DTO를 이용한 값전달 연습
    @GetMapping("/text-dto")
    public String dtoText(Model model) {
        //클래스를 사용하려면 반드시 클래스 생성
        ItemDTO itemDTO = new ItemDTO();    //클래스생성
        //@Autowired 자동생성
        //ItemDTO itemDTO;  //get 가져옴 set 넣는것
        itemDTO.setItemNm("테스트 상품1");
        itemDTO.setPrice(10000);
        itemDTO.setItemDetail("상품 상세 설명입니다.");

        model.addAttribute("itemDTO", itemDTO);
        return "text-dto";  //이동페이지

    }
    @GetMapping("/text-test")
    public String textTest(Model model){
        model.addAttribute("name","홍길동");
        model.addAttribute("age","24");
        model.addAttribute("address","부천시");

        SungjukDTO sungjukDTO = new SungjukDTO();

        sungjukDTO.setKor(90);
        sungjukDTO.setEng(80);
        sungjukDTO.setMat(90);

        model.addAttribute("sungjukDTO", sungjukDTO);
        return "text-test";

    }

    @GetMapping("/text-unescaped")
    public String textUnescaped(Model model){
        //HTML에서 ${data}선언해서 사용
        model.addAttribute("data", "Hello <b>World!!</b>");
        return "text-unescaped";
    }
}

