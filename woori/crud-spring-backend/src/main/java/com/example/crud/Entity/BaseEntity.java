package com.example.crud.Entity;

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

    @Column(name = "create_date", nullable = false, updatable = false)//생성 날짜
    @CreatedDate
    private LocalDateTime createDate;

    @Column(name = "modify_date")//수정 날짜
    @LastModifiedDate
    private LocalDateTime modifyDate;
}
