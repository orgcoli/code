/*
 * 프로그램명   : PagingEntity
 * 설명        : 게시판 테이블을 연동하는 클래스
 *               1. 메소드 명 : 기능설명
 * 작 성 자    : 이민호
 * 작성일      : 2023년 10월 25일
 * 수정 사항 : 수정한 내용, 수정일자 수정자
 */



package com.example.paging.Entity;

import com.example.paging.Entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

//실질적으로 작업할 Entity(작업별로 1개이상 존재)
@Entity //클래스의 사용 목적, 데이터베이스 연동

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder    //생성자 없이 값을 저장처리

@Table(name = "board_paging")
public class PagingEntity extends BaseEntity {
    //private : 클래스내에서만 사용가능한 범위(외부접속 불가능)
    //public : 외부에서 사용가능한 범위
    //변수 및 연동 필드 지정
    //변수가 private : 외부에서 접근이 불가능하므로 getter, setter라는 메소드로 접근
    //프로그램을 작성하면서 가독성을 높이기 위해서 프로그램을 정리하면서 작성(빈줄, 탭키)
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //생성시 관리하는방법
    private int     id;                 //번호

    @Column(name = "subject", length = 100)
    private String  subject;            //제목

    @Column(name = "content", length = 255)
    private String  content;            //내용

    @Column(name = "username", length = 20)
    private String  username;           //작성자

    @Column(name = "viewcnt")
    private int     viewcnt;            //조회수
    //개발자의 추가적 메소드를 추가
    //주석은 ! @ ? 기호나 Todo(앞으로 진행할 내용), FixMe(수정이 필요한 내용) 등을 이용해서 작성
}
