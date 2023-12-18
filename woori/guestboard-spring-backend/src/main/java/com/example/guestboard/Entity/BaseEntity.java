package com.example.guestboard.Entity;

//모든 테이블에 공통적으로 존재하는 필드

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Service
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
