package com.example.thyme.Controller;

import com.example.thyme.DTO.ItemDTO;
import com.example.thyme.DTO.SungjukDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;   //Controller 어노테이션
import org.springframework.ui.Model;    //Model 처리
import org.springframework.web.bind.annotation.*;   //어노테이션 처리

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.sql.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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

    //HttpSession 요청한 컴퓨터의 정보를 읽어온다.
    @GetMapping("/basic-object")
    public String basicObject(HttpSession session){
        session.setAttribute("sessionData", "Hello Session");
        return  "basic-object";
    }

    @GetMapping("/date")
    public String date(Model model){
        //LocalDateTime(현재시스템, 서버).now(현재시간)
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "date";
    }

    @GetMapping("/link")
    public String link(Model model){
        model.addAttribute("param1","data1");
        model.addAttribute("param2","data2");

        return "/link";
    }
    //변수에 값이 없으면 오류 발생
    //null 아무것도 없음, 값없이 오류를 방지하기 위해서 주로 사용
    //변수 선언시 지정할 값이 없을 떄
    @GetMapping("/operation")
    public String operation(Model model){
        model.addAttribute("data","Spring!!!");
        model.addAttribute("nulldata", null);

        return "operation";
    }

    @GetMapping("/attribute")
    public String attribute(){
        return "attribute";
    }

    @GetMapping("/each")
    public String each(Model model){
        //실질적으로 데이터베이스에서 처리하는 부분
        //임시로 값을 3개를 저장해서 전달
        List<User> users =  Arrays.asList(
                new User("userA", 10),
                new User("userB", 20),
                new User("userC", 30)

        );
        model.addAttribute("users", users);
        return "each";
    }

    @GetMapping("/condition")
    public String condition(Model model){
        //실질적으로 데이터베이스에서 처리하는 부분
        //임시로 값을 3개를 저장해서 전달
        List<User> users =  Arrays.asList(
                new User("userA", 10),
                new User("userB", 20),
                new User("userC", 30)

        );
        model.addAttribute("users", users);
        return "condition";
    }
    @Data
    static  class User{
        private String userName;
        private int age;
        public User(String userName, int age){
            this.userName = userName;
            this.age = age;
        }
    }

    @GetMapping("layout")
    public String layout(){
        return "layoutEx";
    }

}

