package com.example.jpauses.Entity;

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
    //값 생략 불가능, 수정 불가능
    @Column(name = "created_Date" , nullable = false, updatable = false)
    @CreatedDate    //생성시 날짜 추가
    private LocalDateTime createdDate;

    @Column(name = "modified_Date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
