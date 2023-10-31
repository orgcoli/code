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

@Table(name = "discussion")
@SequenceGenerator(name = "discussion_SEQ",
        sequenceName = "discussion_SEQ",
        initialValue = 1,
        allocationSize = 1)
public class DiscussionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "discussion_SEQ")
    private Integer id; //토론번호

    @Column(name="subject", length = 200)
    private String subject;


    @Column(name = "viewcnt")
    @ColumnDefault("0")
    private Integer viewcnt;
}
