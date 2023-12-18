package com.example.article.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "comment")
@SequenceGenerator(
        name = "comment_SEQ",
        sequenceName = "comment_SEQ",
        initialValue =1,
        allocationSize = 1)
public class CommentEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "comment_SEQ")
    private Integer id;

    @Column(name="body", length = 100)
    private String body;    //댓글내용

    @Column(name="nickname", length = 200)
    private String nickname;    //작성자

    //부모, 자식 구분... 현재 테이블의 위치
    //현재위치 To 대상위치
    //현재댓글들은 하나의 게시글에 존재가 가능 (하나의 게시글에 여러개의 댓글 존재 그러니까 ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)  //외래키 즉시 로딩과 지연로딩
    @JoinColumn(name = "article_id") //외래키는 joinColumn 사용
    private ArticleEntity articleEntity;    //해당참조 테이블을 선언

    //@Column(name = "articleid")
    //private Integer articleid;
}
