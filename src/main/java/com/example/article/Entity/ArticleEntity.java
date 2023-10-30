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
@Table(name = "article")
@SequenceGenerator(
        name = "article_SEQ",
        sequenceName = "article_SEQ",
        initialValue =1,
        allocationSize = 1)
public class ArticleEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "article_SEQ")
    private Integer id;

    @Column(name="title", length = 100)
    private String title;

    @Column(name="content", length = 200)
    private String content;

    @Column(name="viewcnt")
    private Integer viewcnt;
}
