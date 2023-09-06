package com.kakao.munjebank.VO;

import lombok.Data;

@Data
public class MunjeVO {
    private int no;             //문제번호
    private String subject;     //분류
    private String question;    //문제
    private String item1;       //항목1
    private String item2;       //항목2
    private String item3;       //항목3
    private String item4;       //항목4
    private String answer;      //정답
}
