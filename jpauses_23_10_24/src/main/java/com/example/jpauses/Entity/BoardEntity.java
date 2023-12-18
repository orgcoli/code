package com.example.jpauses.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "board")  //매핑할 테이블 영
public class BoardEntity extends BaseEntity{    //공용필드 상속
    //테이블의 필드와 변수를 연동
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; //번호

    @Column(name = "subject", length = 100, nullable = false)
    private String subject; //제목

    //@Lob 32765byte 제공
    @Column(name = "content")
    private String content; //내용

    @Column(name = "username", length = 20)
    private String username; //작성자

    @Column(name ="viewcnt")
    private int viewcnt;    //열람수
}
//변수선언 후 복사해서 DTO에 붙여넣기
//서버를 실행해서 테이블이 정상적으로 생성되었는지 확인
//다음 DTO에서 검증처리