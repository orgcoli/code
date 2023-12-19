package com.example.thyme.DTO;
//클래스명은 첫글자 대문자
//클래스명+해당패키지
//ItemDTO - Item 그룹을 처리를 위한 DTO(그룹변수)

import lombok.Getter;
import lombok.Setter;

@Getter //get변수명() 메소드 자동생성
@Setter //set변수명() 메소드 자동생성
public class ItemDTO {
    //ItemDTO(클래스) itemDTO(변수)
    //두단어가 합쳐지면 두번째 단어의 첫글자부터 대문자시작
    //사용할 변수를 나열
    //변수명은 반드시 소문자로 시작
    private String itemNm;  //아이템이름
    private Integer price;  //아이템가격
    private  String itemDetail; //아이템 상세정보
}

    //변수에 저장
    //get변수명() 메소드로 변수값을 읽어오고
    //set변수명() 메소드로 변수값에 값을 저장한다