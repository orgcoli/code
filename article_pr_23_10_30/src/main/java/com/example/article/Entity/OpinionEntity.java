package com.example.article.Entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@DynamicInsert
@DynamicUpdate
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

@Table(name = "opinion")
@SequenceGenerator(name = "opinion_SEQ",
        sequenceName = "opinion_SEQ",
        initialValue = 1,
        allocationSize = 1)
public class OpinionEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "opinion_SEQ")
    private Integer id; //의견번호

    @Column(name = "comment", length = 200)
    private String comment; //의견

    @Column(name = "goodcnt")
    @ColumnDefault("0")
    private Integer goodcnt;    //좋아요

    @Column(name = "badcnt")
    @ColumnDefault("0")
    private Integer badcnt; //싫어요

    //토론과 의견을 연결하기 위해 토론번호를 저장
    //의견의 내용이 존재해도 토론을 삭제할 수 있다.
    //토론삭제시 의견쓰레기가 존재
    //@Column(name="discussionid")
    //private Integer discussionid;
    //보완하기 위해서 외래키(연관관계) 적용
    //여러개의 의견(Many)이 하나의 토론(one)과 관련
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discussionid")  //discussionid와 discussionEntity의 id를 조인
    private DiscussionEntity discussionEntity;
}
