package com.board.mboard.Entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notes_tbl")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Notes_tbl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;

    @Column(name="type", length = 5, nullable = false)
    private int type;

    @Column(name="title", length = 40, nullable = false)
    private String title;

    @Column(name="content", length = 200 ,nullable = false)
    private String content;

    @CreatedDate
    @Column(name = "nregdate")
    private LocalDateTime nregdate;

    @LastModifiedDate
    @Column(name = "nmoddate")
    private LocalDateTime nmoddate;

    public void notesChange(int type, String title, String content){
        this.type = type;
        this.title = title;
        this.content = content;
    }
}
