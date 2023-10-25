/*======================================================================================================
 * 프로그램명 : BaseEntity
 * 설명 : 테이블에 id, subject, content, username을 추가하는 클래스
 *       어노테이션
 *       @Entity, @Getter, @Setter, @ToString, @AllArgsConstructor,
 *       @NoArgsConstructor, @Builder, @Table 추가
 *       page_tbl(테이블 명), id(기본키, 번호, GenerationType.IDENTITY)
 *       subject(제목, 최대길이 100), content(내용, 최대길이 255)
 *       username(작성자, 최대길이 20)
 * 작성자 : 이민호
 * 작성일 : 2023-10-25
 * 수정사항 : ----
 ======================================================================================================*/


package com.example.page_pr_23_10_25.Entity;

import lombok.*;

import javax.persistence.*;

@Entity

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "page_tbl")
public class PageEntity extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "subject", length = 100)
    private String subject;

    @Column(name = "content")
    private String content;

    @Column(name = "username", length = 20)
    private String username;
}
