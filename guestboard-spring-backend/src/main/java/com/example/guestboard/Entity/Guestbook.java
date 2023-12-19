package com.example.guestboard.Entity;

//Entity는 클래스명에 테이블명+Entity로 사용하는 것보다 테이블명으로 지정
//Entity는 맴버변수와 테이블을 매핑(클래스명=테이블명)

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity //엔티티클래스 선언
@Getter //멤버변수에 값을 읽기위한 get메소드 자동생성
@Setter //맴버변수에 값을 저장하기 위한 set메소드 자동생성
@AllArgsConstructor //생성자
@NoArgsConstructor
@ToString   //전체 주고받기 위해서
@Builder    //전체맴버변수에 값을 쉽게 저장하기 위해
//@Table(name="연결할 테이블명") 클래스이름과 테이블이름이 다른경우
public class Guestbook {
    //필드와 변수의 관계를 지정
    //변수를 선언하고 DTO에 그대로 복사
    //테이블과의 관계를 어노테이션 지정
    @Id //기본키만 id로 선언
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gno;               //번호

    //기본키를 제외하고는 모두 Column 선언
    //@Column(name = "필드명", length = 길이, nullable = 생략가능여부)
    //변수명과 필드명이 동일하면 name은 생략
    //length를 생략하면 255바이트로 자동 지정
    @Column(length = 100, nullable = false) //필드명 title,길이100, 생략 불가능
    private String title;           //제목

    @Column(length = 1000, nullable = false)
    private String content;         //내용

    @Column(length = 30, nullable = false)
    private String writer;          //작성자

    //이름은 대소문자 구분함
    @CreatedDate    //생성시 날짜를 자동으로 생성
    @Column(name="regdate", updatable = false)  //updateable=false 수정불가능(최초등록이므로)
    private LocalDateTime regDate;  //생성일자

    @LastModifiedDate   //최종 수정시 날짜를 자동으로 생성
    @Column(name = "moddate")
    private LocalDateTime modDate;  //수정일자

    //추가로 필요한 메소드를 생성(getter, setter, 생성자를 제외한 일반메소드)
    //부분적으로 값을 처리할 작업에 맞는 메소드를 임의로 생성
    public void changeTitle(String title){
        this.title = title;
    }
    public void changeContent(String content){
        this.content = content;
    }
    public void changeWriter(String writer){
        this.writer = writer;
    }
    //실행 후 데이터베이스에서 테이블생성을 확인한 후
    //application에서 create를 none으로 변경
    //다음에 Repository를 생성
}
