package com.example.movie_cl_23_11_06.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Column(name = "regDate", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime regDate;  //생성날짜

    @Column(name = "modDate")
    @LastModifiedDate
    private LocalDateTime modDate;  //수정날짜
}
